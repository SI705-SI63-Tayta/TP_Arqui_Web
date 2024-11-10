package pe.edu.upc.taytagrupo5.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.NotificationDTO;
import pe.edu.upc.taytagrupo5.entities.Notification;
import pe.edu.upc.taytagrupo5.serviceinterfaces.INotificationService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
@CrossOrigin(origins = {"http://localhost:4200"})
public class NotificationController {
    @Autowired
    private INotificationService nS;


    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
    @PostMapping
    public void insert(@RequestBody NotificationDTO dto) {
        System.out.println(dto.getRecipes());
        ModelMapper m = new ModelMapper();
        Notification d = m.map(dto, Notification.class);
        System.out.println(d.getRecipes());
        nS.insert(d);
    }

    @GetMapping
    public List<NotificationDTO> listar(){
        return nS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, NotificationDTO.class);
        }).collect(Collectors.toList());
    }
    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
    @PutMapping
    public void update(@RequestBody NotificationDTO dto) {
        ModelMapper m = new ModelMapper();
        Notification d = m.map(dto, Notification.class);
        nS.update(d);
    }
    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        nS.delete(id);
    }
    @GetMapping("/{id}")
    public NotificationDTO getById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        NotificationDTO dto=m.map(nS.listById(id), NotificationDTO.class);
        return dto;
    }

}
