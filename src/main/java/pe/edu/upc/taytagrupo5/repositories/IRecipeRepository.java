package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.Recipe;

import java.util.List;

@Repository
public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {
    @Query(value ="SELECT u.full_name, count(*) quantity FROM appointments ap inner join recipes r on ap.id_appointment=r.id_appointment \n" +
            " inner join users u on u.id_user=ap.id_cliente where u.id_user=1 and r.state='Finalizado' \n" +
            " group by u.full_name " ,nativeQuery = true)
    public List<String[]> recetasFinalizadasPorCliente();

}
