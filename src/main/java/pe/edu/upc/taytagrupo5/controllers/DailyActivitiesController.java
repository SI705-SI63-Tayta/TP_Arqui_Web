package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.DailyActivitiesDTO;
import pe.edu.upc.taytagrupo5.entities.DailyActivities;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IDailyActivitiesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividades_diarias")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DailyActivitiesController {
    @Autowired
    private IDailyActivitiesService dS;


    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','CLIENTE')")
    @PostMapping
    public void insert(@RequestBody DailyActivitiesDTO dto){
        ModelMapper m = new ModelMapper();
        DailyActivities d = m.map(dto, DailyActivities.class);
        dS.insert(d);
    }

    @GetMapping
    public List<DailyActivitiesDTO> listar(){
        return dS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, DailyActivitiesDTO.class);
        }).collect(Collectors.toList());
    }
@PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
    @PutMapping
    public void update(@RequestBody DailyActivitiesDTO dto) {
        ModelMapper m = new ModelMapper();
        DailyActivities d = m.map(dto, DailyActivities.class);
        dS.update(d);
    }
@PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        dS.delete(id);
    }
    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
    @GetMapping("/{id}")
    public DailyActivitiesDTO getById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        DailyActivitiesDTO dto=m.map(dS.listById(id), DailyActivitiesDTO.class);
        return dto;
    }

}
