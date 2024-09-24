package pe.edu.upc.taytagrupo5.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.NotificationDTO;
import pe.edu.upc.taytagrupo5.entities.Notification;
import pe.edu.upc.taytagrupo5.serviceinterfaces.INotificationService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificationController {
    @Autowired
    private INotificationService nS;

@PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
    @PostMapping
    public void insert(@RequestBody NotificationDTO dto) {
        ModelMapper m = new ModelMapper();
        Notification d = m.map(dto, Notification.class);
        nS.insert(d);
    }

    @GetMapping
    public List<NotificationDTO> listar(){
        return nS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, NotificationDTO.class);
        }).collect(Collectors.toList());
    }
@PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
    @PutMapping
    public void update(@RequestBody NotificationDTO dto) {
        ModelMapper m = new ModelMapper();
        Notification d = m.map(dto, Notification.class);
        nS.update(d);
    }
@PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
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
