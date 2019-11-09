package searchlinks.entities;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import searchlinks.dao.PagesDAO;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sites")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String domain;

    @ManyToOne
    private User owner;

    @OneToMany
    private List<Page> pages;

    public Site(){}

    public Site(User user, String domain) {
        this.owner = user;
        this.domain = domain;
        pages = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "";
    }

    public List<Page> getPages(String domain) {
        Document doc = null;
        try {
            doc = Jsoup.connect(domain).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = doc.select("loc");
        for(int i  = 0; i < 10; i++) {
            Page page = new Page(this, elements.get(i).text());
            pages.add(page);
        }
//        for (Element e : doc.select("loc")) {
//            pages.add(new Page(this, e.text()));
//        }
        return pages;
    }
}
