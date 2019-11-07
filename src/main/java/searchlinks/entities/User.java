package searchlinks.entities;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 32, unique = true, nullable = false)
    private String login;

    @Column(length = 32, nullable = false)
    private String password;

    public User(){}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
