package pe.edu.upc.taytagrupo5.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.RolDTO;
import pe.edu.upc.taytagrupo5.entities.Rol;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IRolServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Roles")
public class RolController {
   @Autowired
   private IRolServices rs;

   @PostMapping
    public void registrar(@RequestBody RolDTO dto){

       ModelMapper m = new ModelMapper();
       Rol d = m.map(dto,Rol.class);
       rs.insert(d);

   }

   @GetMapping
    public List<RolDTO> listar(){
       return rs.list().stream().map(x->{ModelMapper m=new ModelMapper();
       return  m.map(x,RolDTO.class);
       }).collect(Collectors.toList());

   }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rs.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol d = m.map(dto, Rol.class);
        rs.update(d);
    }

    @GetMapping("/usuarios-rol")
    public List<String[]> listarUsuariosRol(){
       return rs.quantityUserPerRol();
    }

}
