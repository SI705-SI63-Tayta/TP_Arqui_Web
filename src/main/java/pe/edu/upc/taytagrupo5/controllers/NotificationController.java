package pe.edu.upc.taytagrupo5.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.NotificationsDTO;
import pe.edu.upc.taytagrupo5.entities.Notifications;
import pe.edu.upc.taytagrupo5.serviceinterfaces.INotificationsService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificationController {
    @Autowired
    private INotificationsService nS;

    @PostMapping
    public void insert(@RequestBody NotificationsDTO dto) {
        ModelMapper m = new ModelMapper();
        Notifications d = m.map(dto, Notifications.class);
        nS.insert(d);
    }

    @GetMapping
    public List<NotificationsDTO> listar(){
        return nS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,NotificationsDTO.class);
        }).collect(Collectors.toList());
    }

    @PutMapping
    public void update(@RequestBody NotificationsDTO dto) {
        ModelMapper m = new ModelMapper();
        Notifications d = m.map(dto, Notifications.class);
        nS.update(d);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        nS.delete(id);
    }
    @GetMapping("/{id}")
    public NotificationsDTO getById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        NotificationsDTO dto=m.map(nS.listById(id), NotificationsDTO.class);
        return dto;
    }

}
