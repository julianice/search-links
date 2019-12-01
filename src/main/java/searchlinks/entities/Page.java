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

    //TODO узнать про fetch
    @OneToMany(fetch = FetchType.EAGER)
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
}
