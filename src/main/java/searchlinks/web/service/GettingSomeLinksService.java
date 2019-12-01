package searchlinks.web.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import searchlinks.entities.Link;
import searchlinks.entities.Page;
import searchlinks.entities.Site;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GettingSomeLinksService {

    public List<Page> getPages(Site site) {
        List<Page> pages = new ArrayList<>();
        Document doc = null;
        try {
            doc = Jsoup.connect(site.getDomain()).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = doc.select("loc");
        for (int i = 0; i < 10; i++) {
            Page page = new Page(site, elements.get(i).text());
            pages.add(page);
        }
        //пока ограничила 10 страницами
//        for (Element e : doc.select("loc")) {
//            pages.add(new Page(this, e.text()));
//        }
        return pages;
    }

    public List<Link> getLinks(Site site, Page page) {
        List<Link> links = new ArrayList<>();
        Document doc = null;
        try {
            doc = Jsoup.connect(page.getPath()).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Element e : doc.select("a[href]")) {
            if (e.attr("href").contains("http")) {
                links.add(new Link(site, page, e.attr("href")));
            }
        }
        return links;
    }
}
