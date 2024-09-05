package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.RecipeDTO;
import pe.edu.upc.taytagrupo5.entities.Recipe;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IRecipeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    private IRecipeService rs;

    @PostMapping
    public void registrar(@RequestBody RecipeDTO dto) {
        ModelMapper m = new ModelMapper();
        Recipe d = m.map(dto, Recipe.class);
        rs.insert(d);
    }

    @GetMapping
    public List<RecipeDTO> listar(){
        return rs.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RecipeDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void modificar(@RequestBody RecipeDTO dto) {
        ModelMapper m = new ModelMapper();
        Recipe d = m.map(dto, Recipe.class);
        rs.update(d);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rs.delete(id);
    }
    @GetMapping("/{id}")
    public RecipeDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        RecipeDTO dto=m.map(rs.listId(id), RecipeDTO.class);
        return dto;
    }

}
