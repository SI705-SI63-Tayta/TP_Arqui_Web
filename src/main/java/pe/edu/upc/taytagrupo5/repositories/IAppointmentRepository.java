package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
}
