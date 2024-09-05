package pe.edu.upc.taytagrupo5.serviceinterfaces;

import pe.edu.upc.taytagrupo5.entities.DailyActivities;

import java.util.List;

public interface IDailyActivitiesService {
    public List<DailyActivities> list();
    public void insert(DailyActivities d);
    public DailyActivities listById(int id);
    public void update(DailyActivities d);
    void delete(int id);
}
