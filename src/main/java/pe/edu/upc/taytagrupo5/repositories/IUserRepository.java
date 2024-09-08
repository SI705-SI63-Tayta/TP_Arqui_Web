package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.taytagrupo5.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    public User findByUserName(String username);

    @Query("select count(u.userName) from User u where u.userName =:username")
    public int buscarUsername(@Param("username") String nombre);


    @Transactional
    @Modifying
    @Query(value = "insert into roles (descriptionRole, user_id) VALUES (:descriptionRole, :user_id)", nativeQuery = true)
    public void insRol(@Param("descriptionRole") String authority, @Param("user_id") Long user_id);
}
