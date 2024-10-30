package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.ListUserDTO;
import pe.edu.upc.taytagrupo5.dtos.QuantityUsersPerDatesDTO;
import pe.edu.upc.taytagrupo5.dtos.UserDTO;
import pe.edu.upc.taytagrupo5.entities.User;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IUserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Users")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {
    @Autowired
    private IUserService uS;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping
    public void registrar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        User u = m.map(dto, User.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.insert(u);
    }

    @GetMapping
    public List<UserDTO> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        uS.delete(id);
    }

    @GetMapping("/{id}")
    public UserDTO listarId(@PathVariable("id") int id) {
        ModelMapper m=new ModelMapper();
        UserDTO dto=m.map(uS.listId(id),UserDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        User d = m.map(dto, User.class);
        uS.update(d);
    }

    @GetMapping("/Listafecha")
    public List<QuantityUsersPerDatesDTO> listDate(@RequestParam LocalDate date1, @RequestParam LocalDate date2){
        List<String[]> lista4=uS.listarfecha(date1,date2);
        List<QuantityUsersPerDatesDTO> listaDTO=new ArrayList<>();

        for(String[] c:lista4){
            QuantityUsersPerDatesDTO dto=new QuantityUsersPerDatesDTO();
            dto.setFullName(c[0]);
            dto.setDni(c[1]);
            dto.setQuantity(Integer.parseInt(c[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    //AGREGAR ESTO A EL ARCHIVO CON SECURITY

    @GetMapping("/nombreusuario")
    public UserDTO findUser(@RequestParam String username){
        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(uS.findUsername(username), UserDTO.class);
        return dto;
    }
}
