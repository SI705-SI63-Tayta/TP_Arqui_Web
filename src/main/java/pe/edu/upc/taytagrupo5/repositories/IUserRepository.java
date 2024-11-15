package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.User;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value ="SELECT u.full_name, u.dni, count(*) as q from users u inner join appointments ap on u.id_user=ap.id_cliente \n" +
            "inner join rol r on r.id_rol=u.id_Rol \n" +
            "where r.tipo_rol='CLIENTE' AND (ap.date between :date1 and :date2) \n" +
            "group by u.full_name,u.dni",nativeQuery = true )
    public List<String[]> listarfecha(@Param("date1") LocalDate date1, @Param("date2") LocalDate date2);

    public User findByUsername(String username);

    public Boolean existsByUsername(String username);

    public Boolean existsByDni(String dni);
}
