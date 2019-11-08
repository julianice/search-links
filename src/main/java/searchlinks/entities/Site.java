package searchlinks.entities;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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

    public List<Page> getPages(String domain) {
        Document doc = null;
        try {
            doc = Jsoup.connect(domain).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Element e : doc.select("loc")) {
            pages.add(new Page(this, e.text()));
            System.out.println(e.text());
        }
        return pages;
    }
}
