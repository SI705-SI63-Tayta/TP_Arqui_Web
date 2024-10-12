package pe.edu.upc.taytagrupo5.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.QuantityUserPerRolDTO;
import pe.edu.upc.taytagrupo5.dtos.RoleDTO;
import pe.edu.upc.taytagrupo5.entities.Role;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IRoleServices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Roles")
public class RoleController {

   @Autowired
   private IRoleServices rs;

   @PostMapping
    public void registrar(@RequestBody RoleDTO dto){

       ModelMapper m = new ModelMapper();
       Role d = m.map(dto, Role.class);
       rs.insert(d);

   }

   @GetMapping
    public List<RoleDTO> listar(){
       return rs.list().stream().map(x->{ModelMapper m=new ModelMapper();
       return  m.map(x, RoleDTO.class);
       }).collect(Collectors.toList());

   }

   @GetMapping("/{id}")
   public RoleDTO getById(@PathVariable("id") int id){
       ModelMapper m = new ModelMapper();
       RoleDTO dto=m.map(rs.lisById(id), RoleDTO.class);
       return dto;
   }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rs.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role d = m.map(dto, Role.class);
        rs.update(d);
    }

    @GetMapping("/CantidadUsuariosPorRol")
    public List<QuantityUserPerRolDTO> quantityUserPerRol(){
       List<String[]> lista= rs.quantityUserPerRol();
       List<QuantityUserPerRolDTO> listadto = new ArrayList<>();
       for(String[] c:lista){
           QuantityUserPerRolDTO dto=new QuantityUserPerRolDTO();
           dto.setNombreRol(c[0]);
           dto.setCantidad(Integer.parseInt(c[1]));
           listadto.add(dto);
       }
       return listadto;
    }

}
