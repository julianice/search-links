package searchlinks.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import searchlinks.dao.PagesRepository;
import searchlinks.dao.SitesRepository;
import searchlinks.dao.UsersRepository;
import searchlinks.entities.Page;
import searchlinks.entities.Site;
import searchlinks.entities.User;
import searchlinks.web.service.GettingSomeLinksService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class GetPagesController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PagesRepository pagesRepository;

    @Autowired
    SitesRepository sitesRepository;

    @Autowired
    GettingSomeLinksService gettingSomeLinksService;

    @PostMapping(path = "/getpages")
    protected String getPages(HttpSession session,
                              @RequestParam String domain,
                              ModelMap model) {

        int userId = (int) session.getAttribute("userId");
        Optional<User> user = usersRepository.findById(userId);

        //TODO delete Optional.get()
        Site newSite = new Site(user.get(), domain);
        sitesRepository.save(newSite);
        session.setAttribute("siteId", newSite.getId());

        List<Page> pages = gettingSomeLinksService.getPages(newSite);
        for (Page page : pages) {
            pagesRepository.save(page);
        }
        model.addAttribute("pages", pages);
        return "pages";
    }
}
