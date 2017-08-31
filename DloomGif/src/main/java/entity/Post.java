package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="POSTS", schema ="ADMIN")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    private String url;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Long idUser;

    @OneToMany(mappedBy = "comment_id")
    private List<Comment> commentList;

    public Long getId() {
        return id;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Post(String url, Long idUser) {

        this.url = url;
        this.idUser = idUser;
    }
}
