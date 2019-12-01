package searchlinks.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import searchlinks.dao.LinksRepository;
import searchlinks.dao.SitesRepository;
import searchlinks.entities.Link;
import searchlinks.entities.Site;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MarkLinksForDeletingController  {

    @Autowired
    LinksRepository linksRepository;

    @Autowired
    SitesRepository sitesRepository;

    @PostMapping("/markfordelete")
    protected String markForDelete (HttpSession session,
                          @RequestParam List<Integer> delete,
                          ModelMap model) {
        List<Link> links;
        Integer siteId = (Integer) session.getAttribute("siteId");
        Site site = sitesRepository.findById(siteId).get();

        for (Integer idLinkForDelete: delete) {
            Link link  = linksRepository.findById(idLinkForDelete).get();
            link.setWillBeDeleted(true);
            linksRepository.save(link);
        }
        links = linksRepository.findAllByWillBeDeleted(site);
        model.addAttribute("links", links);
        return "linkswillbedeleted";
    }
}
