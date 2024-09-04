package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.Notifications;

@Repository
public interface INotificationsRepository extends JpaRepository<Notifications, Integer> {

}
