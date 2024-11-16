package pe.edu.upc.taytagrupo5.entities;


import jakarta.persistence.*;

@Entity
@Table(name="Reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReview;

    @Column(name = "score", nullable = false)
    private int scoreReview;

    @Column(name = "comment", nullable = false, length = 50)
    private String commentReview;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private User userCliente;

    @ManyToOne
    @JoinColumn(name = "idPersonal")
    private User userPersonal;

    public Review() {
    }

    public Review(int idReview, int scoreReview, String commentReview, User userCliente, User userPersonal) {
        this.idReview = idReview;
        this.scoreReview = scoreReview;
        this.commentReview = commentReview;
        this.userCliente = userCliente;
        this.userPersonal = userPersonal;
    }

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
