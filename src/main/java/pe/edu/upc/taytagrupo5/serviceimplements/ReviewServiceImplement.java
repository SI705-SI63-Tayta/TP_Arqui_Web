package pe.edu.upc.taytagrupo5.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.taytagrupo5.entities.Review;
import pe.edu.upc.taytagrupo5.repositories.IReviewRepository;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IReviewService;

import java.util.List;

@Service
public class ReviewServiceImplement implements IReviewService {
    @Autowired
    private IReviewRepository rR;

    @Override
    public List<Review> list(){
        return rR.findAll();
    }

    @Override
    public void insert(Review r) {
        rR.save(r);
    }

    @Override
    public Review listById(int id) {

        return rR.findById(id).orElse(new Review());
    }

    @Override
    public void update(Review r) {
        rR.save(r);
    }

    @Override
    public void deleteById(int id) {
        rR.deleteById(id);
    }


}
