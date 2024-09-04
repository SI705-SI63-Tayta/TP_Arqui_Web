package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.RecipesDTO;
import pe.edu.upc.taytagrupo5.entities.Recipes;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IRecipesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recipes")
public class RecipesController {
    @Autowired
    private IRecipesService rs;

    @PostMapping
    public void registrar(@RequestBody RecipesDTO dto) {
        ModelMapper m = new ModelMapper();
        Recipes d = m.map(dto, Recipes.class);
        rs.insert(d);
    }

    @GetMapping
    public List<RecipesDTO> listar(){
        return rs.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,RecipesDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void modificar(@RequestBody RecipesDTO dto) {
        ModelMapper m = new ModelMapper();
        Recipes d = m.map(dto, Recipes.class);
        rs.update(d);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rs.delete(id);
    }
    @GetMapping("/{id}")
    public RecipesDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        RecipesDTO dto=m.map(rs.listId(id), RecipesDTO.class);
        return dto;
    }

}
