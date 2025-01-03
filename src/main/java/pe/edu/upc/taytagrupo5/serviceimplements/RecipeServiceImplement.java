package pe.edu.upc.taytagrupo5.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.taytagrupo5.entities.Recipe;
import pe.edu.upc.taytagrupo5.repositories.IRecipeRepository;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IRecipeService;

import java.util.List;

@Service

public class RecipeServiceImplement implements IRecipeService {
    @Autowired
    private IRecipeRepository rR;

    @Override
    public Recipe insert(Recipe recipe) {
        // Lógica para insertar la receta en la base de datos
        Recipe savedRecipe = rR.save(recipe); // Aquí guardas la receta y obtienes el id automáticamente
        return savedRecipe; // Devuelves la receta completa, con el id generado
    }


    @Override
    public List<Recipe>list(){return rR.findAll();}

    @Override
    public void update(Recipe recipe) {
        rR.save(recipe);
    }

    @Override
    public void delete(int idRecipe) {
        rR.deleteById(idRecipe);
    }

    @Override
    public Recipe listId(int idRecipe) {
        return rR.findById(idRecipe).orElse(new Recipe());
    }

    @Override
    public List<String[]> recipesFinishedPerClient() {
        return rR.recipesFinishedPerClient();
    }


}
