package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.Role;

import java.util.List;


@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {


    @Query(value = "select r.tipo_rol , count(*) from rol as r \n" +
            "inner join users as u ON u.id_rol=r.id_rol \n" +
            "group by r.id_rol ", nativeQuery = true)
    public List<String[]> quantityUserPerRol();








}
