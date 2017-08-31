package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="USERS", schema ="ADMIN")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    private String mail;
    private String passHash;
    private String username;

    @OneToMany(mappedBy = "idUser")
    private List<Post> posts;

    @OneToMany(mappedBy = "idUser")
    private List<Comment> comments;

    @OneToOne(mappedBy = "idUser")
    private List<UpvoteComment> upvoteComments;

    @OneToOne(mappedBy = "idUser")
    private List<UpvotePost> upvotePosts;

    public User(String mail, String passHash, String username) {
        this.mail = mail;
        this.passHash = passHash;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getMail() {

        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
