package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.DailyActivities;

@Repository
public interface IDailyActivitiesRepository extends JpaRepository<DailyActivities, Integer> {

}
