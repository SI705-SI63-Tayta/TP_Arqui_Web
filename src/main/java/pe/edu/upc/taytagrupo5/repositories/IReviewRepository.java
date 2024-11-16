package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.Review;

import java.util.List;

@Repository
public interface IReviewRepository extends JpaRepository<Review, Integer> {
     @Query(value = " select * from Reviews r where r.score > 3", nativeQuery = true)
     public List<String[]> listarcalificacionmayor3() ;

     @Query(value ="select u.full_name,avg(re.score) as promedio from reviews re inner join users u on u.id_user= re.id_personal \n" +
             " inner join rol r on r.id_rol=u.id_rol where (r.tipo_rol='ENFERMERO' or r.tipo_rol='DOCTOR') \n" +
             " group by u.full_name \n" +
             " order by promedio desc \n" +
             " limit 5" ,nativeQuery = true)
     public List<String[]> top5CalificacionPersonal();
}
