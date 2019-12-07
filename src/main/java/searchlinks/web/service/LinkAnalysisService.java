package searchlinks.web.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import searchlinks.entities.Link;
import searchlinks.entities.Page;
import searchlinks.entities.Site;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class LinkAnalysisService {
    ExecutorService executorService = Executors.newCachedThreadPool();
    Logger logger = LoggerFactory.getLogger(LinkAnalysisService.class);


    public List<Page> getPages(Site site) {
        List<Page> pages = new ArrayList<>();
        Document doc = null;
        try {
            doc = Jsoup.connect(site.getDomain()).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Future<Page>> futures = new ArrayList<>();
        for (Element element : doc.select("loc")) {
            Future<Page> futurePage = executorService.submit(() -> {
                Page page = new Page(site, element.text());
                return page;
            });
            futures.add(futurePage);
        }

        for (Future<Page> futurePage : futures) {
            if (futurePage.isDone()) {
                try {
                    pages.add(futurePage.get());
                } catch (InterruptedException | ExecutionException e) {
                    logger.error("Getting page was interrupted");
                }
            }
        }
        return pages;
    }

    public List<Link> getLinks(Site site, Page page) throws ExecutionException, InterruptedException {
        List<Link> links = new ArrayList<>();
        Document doc = null;
        try {
            doc = Jsoup.connect(page.getPath()).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Future<Link>> futures = new ArrayList<>();

        for (Element e : doc.select("a[href]")) {
            if (e.attr("href").contains("http")) {
                Future<Link> future = executorService.submit(() -> {
                    Link link = new Link(site, page, e.attr("href"));
                    return link;
                });
                futures.add(future);
            }
        }

        for (Future<Link> linkFuture : futures) {
            if (linkFuture.isDone()) {
                links.add(linkFuture.get());
            }
        }
        return links;
    }
}
