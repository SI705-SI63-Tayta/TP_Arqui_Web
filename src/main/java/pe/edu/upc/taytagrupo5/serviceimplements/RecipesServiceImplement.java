package pe.edu.upc.taytagrupo5.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.taytagrupo5.entities.Recipes;
import pe.edu.upc.taytagrupo5.repositories.IRecipesRepository;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IRecipesService;

import java.time.LocalDate;
import java.util.List;

@Service

public class RecipesServiceImplement implements IRecipesService {
    @Autowired
    private IRecipesRepository rR;

    @Override
    public void insert(Recipes recipes) {
        rR.save(recipes);
    }

    @Override
    public List<Recipes>list(){return rR.findAll();}

    @Override
    public void update(Recipes recipes) {
        rR.save(recipes);
    }

    @Override
    public void delete(int idRecipes) {
        rR.deleteById(idRecipes);
    }

    @Override
    public Recipes listId(int idRecipes) {
        return rR.findById(idRecipes).orElse(new Recipes());
    }




}
