package pe.edu.upc.taytagrupo5.controllers;
import jakarta.validation.constraints.Max;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.QuantityUserPerRolDTO;
import pe.edu.upc.taytagrupo5.dtos.RolDTO;
import pe.edu.upc.taytagrupo5.entities.Rol;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IRolServices;

import java.util.ArrayList;
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

    @GetMapping("/cantidadUsuariosPorRol")
    public List<QuantityUserPerRolDTO> cantidadUsuariosPorRol(){
        List<String[]> filaLista = rs.quantityUserPerRol();
        List<QuantityUserPerRolDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            QuantityUserPerRolDTO dto = new QuantityUserPerRolDTO();
            dto.setNameR(columna[0]);
            dto.setQuantity(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }



}
