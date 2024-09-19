package pe.edu.upc.taytagrupo5.serviceinterfaces;

import pe.edu.upc.taytagrupo5.entities.Recipe;

import java.util.List;

public interface IRecipeService {
    public void insert(Recipe recipe);
    public List<Recipe> list();
    public void update(Recipe recipe);
    public void delete(int idRecipe);
    public Recipe listId(int idRecipe);
    public List<String[]>recipesFinishedPerClient();


}
