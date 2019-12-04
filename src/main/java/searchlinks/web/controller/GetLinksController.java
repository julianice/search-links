package searchlinks.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import searchlinks.dao.LinksRepository;
import searchlinks.dao.PagesRepository;
import searchlinks.dao.SitesRepository;
import searchlinks.dao.UsersRepository;
import searchlinks.entities.Link;
import searchlinks.entities.Page;
import searchlinks.entities.Site;
import searchlinks.web.exception.NotFoundEntityException;
import searchlinks.web.service.LinkAnalysisService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetLinksController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PagesRepository pagesRepository;

    @Autowired
    SitesRepository sitesRepository;

    @Autowired
    LinksRepository linksRepository;

    @Autowired
    LinkAnalysisService linkAnalysisService;

    @PostMapping(path = "/getlinks")
    protected String getLinks(HttpSession session,
                              ModelMap model) throws NotFoundEntityException {

        Integer siteId = (Integer) session.getAttribute("siteId");
        Site site = sitesRepository.findById(siteId).orElseThrow(()  -> new NotFoundEntityException("Site is not found"));

        List<Page> pages = pagesRepository.findBySite(site);
        List<Link> allLinks = new ArrayList<>();

        for (Page page : pages) {
            List<Link> linksForOnePage = linkAnalysisService.getLinks(site, page);
            allLinks.addAll(linksForOnePage);
        }

        model.addAttribute("links", allLinks);

        //TODO нужна ли добавка листа разом?если указать @transactional над методом, то в одну транзакцию объединятся все в методе?
        for (Link link : allLinks) {
            linksRepository.save(link);
        }
        return "links";
    }
}
