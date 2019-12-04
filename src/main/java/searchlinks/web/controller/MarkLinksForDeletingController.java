package searchlinks.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import searchlinks.dao.LinksRepository;
import searchlinks.dao.SitesRepository;
import searchlinks.entities.*;
import searchlinks.web.exception.NotFoundEntityException;
//import searchlinks.entities.Site;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MarkLinksForDeletingController  {

    @Autowired
    LinksRepository linksRepository;

    @Autowired
    SitesRepository sitesRepository;

    @PostMapping("/markfordeleting")
    protected String markForDeleting (HttpSession session,
                          @RequestParam List<Integer> linkIdForDeleting,
                          ModelMap model) throws NotFoundEntityException {
        List<Link> linksForDeleting;
        Integer siteId = (Integer) session.getAttribute("siteId");
        Site site = sitesRepository.findById(siteId).orElseThrow(() -> new NotFoundEntityException("Site is not found"));

        for (Integer linkId: linkIdForDeleting) {
            Link link  = linksRepository.findById(linkId).get();
            link.setWillBeDeleted(true);
            linksRepository.save(link);
        }
        linksForDeleting = linksRepository.findAllByWillBeDeleted(site);
        model.addAttribute("links", linksForDeleting);
        return "linkswillbedeleted";
    }
}
