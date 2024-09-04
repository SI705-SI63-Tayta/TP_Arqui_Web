package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.AppointmentDTO;
import pe.edu.upc.taytagrupo5.entities.Appointment;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IAppointmentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citas")
public class AppointmentController {

    @Autowired
    private IAppointmentService aS;

    @GetMapping
    public List<AppointmentDTO> listar() {
        return aS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,AppointmentDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody AppointmentDTO dto){
        ModelMapper m = new ModelMapper();
        Appointment a = m.map(dto, Appointment.class);
        aS.insert(a);
    }

    @GetMapping("/{id}")
    public AppointmentDTO getById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        AppointmentDTO dto = m.map(aS.listById(id), AppointmentDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        aS.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody AppointmentDTO dto) {
        ModelMapper m = new ModelMapper();
        Appointment a= m.map(dto,Appointment.class);
        aS.update(a);
    }

}
