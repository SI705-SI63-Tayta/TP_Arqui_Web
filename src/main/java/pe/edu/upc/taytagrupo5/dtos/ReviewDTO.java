package pe.edu.upc.taytagrupo5.dtos;

public class ReviewDTO {
    private int idReview;
    private int scoreReview;
    private String commentReview;

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
