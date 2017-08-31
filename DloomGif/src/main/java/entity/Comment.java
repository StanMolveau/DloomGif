package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="COMMENTS", schema ="ADMIN")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Long idUser;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Long idPost;

    private Date date;
    private String data;
    @Column(name = "previous_ID")
    private Long previousId;


    public Long getId() {
        return id;
    }

    public Long getIdUser() {

        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getPreviousId() {
        return previousId;
    }

    public void setPreviousId(Long previousId) {
        this.previousId = previousId;
    }

    public Comment(Long idUser, Long idPost, Date date, String data, Long previousId) {

        this.idUser = idUser;
        this.idPost = idPost;
        this.date = date;
        this.data = data;
        this.previousId = previousId;
    }
}
