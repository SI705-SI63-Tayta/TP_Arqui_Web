package pe.edu.upc.taytagrupo5.serviceinterfaces;

import pe.edu.upc.taytagrupo5.entities.Recipes;

import java.time.LocalDate;
import java.util.List;

public interface IRecipesService {
    public void insert(Recipes recipes);
    public List<Recipes> list();
    public void update(Recipes recipes);
    public void delete(int idRecipes);
    public Recipes listId(int idRecipes);


}
