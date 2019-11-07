package searchlinks.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sites")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true, nullable = false)
    private String domain;

    @ManyToOne
    private User owner;

    @OneToMany
    private List<Page> pages;

    public Site(User user, String domain) {
        this.owner = user;
        this.domain = domain;
        pages = new ArrayList<>();
    }
}
