package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.Appointment;

import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
    @Query(value ="SELECT mode, COUNT(*) \n" +
            " FROM appointments \n" +
            " GROUP BY mode ;" ,nativeQuery = true)
    public List<String[]>CantidadModalidadCitas();

}
