package pe.edu.upc.taytagrupo5.serviceinterfaces;

import pe.edu.upc.taytagrupo5.entities.Review;

import java.util.List;

public interface IReviewService {
    public List<Review> list();

    public void insert(Review r);

    public Review listById(int id);

    public void update(Review r);

    public void deleteById(int id);
}
