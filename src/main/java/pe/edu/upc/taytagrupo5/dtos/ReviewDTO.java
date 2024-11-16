package pe.edu.upc.taytagrupo5.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.taytagrupo5.entities.User;

public class ReviewDTO {
    private int idReview;

    private int scoreReview;

    private String commentReview;

    private User userCliente;

    private User userPersonal;

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public int getScoreReview() {
        return scoreReview;
    }

    public void setScoreReview(int scoreReview) {
        this.scoreReview = scoreReview;
    }

    public String getCommentReview() {
        return commentReview;
    }

    public void setCommentReview(String commentReview) {
        this.commentReview = commentReview;
    }

    public User getUserCliente() {
        return userCliente;
    }

    public void setUserCliente(User userCliente) {
        this.userCliente = userCliente;
    }

    public User getUserPersonal() {
        return userPersonal;
    }

    public void setUserPersonal(User userPersonal) {
        this.userPersonal = userPersonal;
    }
}
