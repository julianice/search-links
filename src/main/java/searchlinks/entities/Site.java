package searchlinks.entities;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

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
        this.pages = new ArrayList<>();
    }
}
