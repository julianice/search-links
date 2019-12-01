package searchlinks.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "links")
public class Link {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String url;

    @ManyToOne
    private Page page;

    @ManyToOne
    private Site site;

    @Column
    private boolean willBeDeleted;

    public Link() {}

    public Link(Site site, Page page, String url) {
        this.site = site;
        this.page  = page;
        this.url = url;
        this.willBeDeleted = false;
    }
}
