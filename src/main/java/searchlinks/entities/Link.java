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

    @Column
    private boolean willBeDeleted;

    public Link() {}

    @Override
    public String toString() {
        return "";
    }

    public Link(Page page, String url) {
        this.page  = page;
        this.url = url;
        this.willBeDeleted = false;
    }

    //TODO метод для пометки удаления
}
