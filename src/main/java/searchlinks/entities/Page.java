package searchlinks.entities;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pages")
public class Page {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String title;

    @Column(unique = true, nullable = false)
    private String path;

    @OneToMany
    private List<Link> links;

    @ManyToOne
    private Site site;

    public Page() {}

    @Override
    public String toString() {
        return path;
    }

    public Page(Site site, String path) {
        this.site = site;
        this.path = path;
        this.links = new ArrayList<>();
    }

    public List<Link> getLinks(String pagePath) {
        Document doc = null;
        try {
            doc = Jsoup.connect(pagePath).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Element e : doc.select("a[href]")) {
            System.out.println(e.attr("href"));
            this.links.add(new Link(this, e.attr("href")));
        }
        return links;
    }
}
