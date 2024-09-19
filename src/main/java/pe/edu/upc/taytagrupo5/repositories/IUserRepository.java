package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.User;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value ="SELECT u.dni, u.full_name, count(*) as q from users u inner join appointments ap on u.id_user=ap.id_cliente\n" +
            "where u.id_rol=1 AND(ap.date between '2024-01-01' and '2024-12-31')\n" +
            "group by u.dni, u.full_name",nativeQuery = true )
    public List<String[]> listarfecha(@Param("fecha") String fecha);
}
