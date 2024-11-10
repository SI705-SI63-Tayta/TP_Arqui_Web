package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.QuantityRecipesFinishedPerClientDTO;
import pe.edu.upc.taytagrupo5.dtos.RecipeDTO;
import pe.edu.upc.taytagrupo5.entities.Recipe;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IRecipeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RecipeController {
    @Autowired
    private IRecipeService rs;


    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
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

    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
    @PutMapping
    public void modificar(@RequestBody RecipeDTO dto) {
        ModelMapper m = new ModelMapper();
        Recipe d = m.map(dto, Recipe.class);
        rs.update(d);
    }

    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rs.delete(id);
    }

    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
    @GetMapping("/{id}")
    public RecipeDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        RecipeDTO dto=m.map(rs.listId(id), RecipeDTO.class);
        return dto;
    }
    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
    @GetMapping("/recetasFinalizadas")
    public List<QuantityRecipesFinishedPerClientDTO>recipesFinishedPerClient(){
        List<String[]>lista= rs.recipesFinishedPerClient();
        List<QuantityRecipesFinishedPerClientDTO> listadto=new ArrayList<>();
        for (String[] c:lista){
            QuantityRecipesFinishedPerClientDTO dto= new QuantityRecipesFinishedPerClientDTO();
            dto.setFull_name(c[0]);
            dto.setQuantity(Integer.parseInt(c[1]));
            listadto.add(dto);
        }
        return listadto;
    }

}
