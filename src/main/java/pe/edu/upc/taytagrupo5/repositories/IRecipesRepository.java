package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.taytagrupo5.entities.Recipes;

import java.util.List;

@Repository
public interface IRecipesRepository extends JpaRepository<Recipes, Integer> {


}
