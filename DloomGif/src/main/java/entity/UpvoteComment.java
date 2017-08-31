package entity;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UpvoteComment implements Serializable {

    @ManyToOne
    @JoinColumn(name="comment_id")
    private Long idComment;

    @OneToOne
    @JoinColumn(name="user_id")
    @RestResource(path = "userAddress", rel="UpvoteCommentUserAdress")
    private Long idUser;

    public UpvoteComment(Long idComment, Long idUser) {
        this.idComment = idComment;
        this.idUser = idUser;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
