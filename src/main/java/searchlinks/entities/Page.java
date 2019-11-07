package searchlinks.entities;

import lombok.Data;

import javax.persistence.*;
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
    public Page(Site site, String path) {
        this.site = site;
        this.path = path;
    }
}
