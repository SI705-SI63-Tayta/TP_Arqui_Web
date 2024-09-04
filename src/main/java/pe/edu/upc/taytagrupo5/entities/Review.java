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

    public Review() {
    }

    public Review(int idReview, int scoreReview, String commentReview) {
        this.idReview = idReview;
        this.scoreReview = scoreReview;
        this.commentReview = commentReview;
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
}
