package pe.edu.upc.taytagrupo5.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.taytagrupo5.entities.DailyActivities;
import pe.edu.upc.taytagrupo5.repositories.IDailyActivitiesRepository;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IDailyActivitiesService;

import java.util.List;

@Service
public class DailyActivitiesServiceImplement implements IDailyActivitiesService {
    @Autowired
    private IDailyActivitiesRepository dR;

    @Override
    public List<DailyActivities> list() {
        return dR.findAll();
    }

    @Override
    public void insert(DailyActivities d) {
        dR.save(d);
    }

    @Override
    public DailyActivities listById(int id) {
        return dR.findById(id).orElse(new DailyActivities());
    }

    @Override
    public void update(DailyActivities d) {
        dR.save(d);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }
}
