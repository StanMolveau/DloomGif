package entity;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="UPVOTE_POSTS", schema="ADMIN")
public class UpvotePost implements Serializable {


    @ManyToOne
    @JoinColumn(name="post_id")
    private Long idPost;

    @OneToOne
    @JoinColumn(name = "user_id")
    @RestResource(path = "userAddress", rel="UpvotePostUserAdress")
    private Long idUser;

    public UpvotePost(Long idPost, Long idUser) {
        this.idPost = idPost;
        this.idUser = idUser;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
