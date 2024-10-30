package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.MedicalRecordDTO;
import pe.edu.upc.taytagrupo5.entities.MedicalRecord;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IMedicalRecordService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/HistoriaClinica")
@CrossOrigin(origins = {"http://localhost:4200"})
public class MedicalRecordController {

    @Autowired
    private IMedicalRecordService ms;

    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
    @PostMapping
    public void registrar(@RequestBody MedicalRecordDTO dto) {
        ModelMapper m = new ModelMapper();
        MedicalRecord d = m.map(dto, MedicalRecord.class);
        ms.insert(d);
    }


    @GetMapping("/{id}")
    public MedicalRecordDTO getById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        MedicalRecordDTO dto= m.map(ms.listById(id), MedicalRecordDTO.class);
        return dto;
    }
    @GetMapping
    public List<MedicalRecordDTO> listar(){
        return ms.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,MedicalRecordDTO.class);
        }).collect(Collectors.toList());
    }
@PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        ms.delete(id);
    }
    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
    @PutMapping
    public void modificar(@RequestBody MedicalRecordDTO dto) {
        ModelMapper m = new ModelMapper();
        MedicalRecord d = m.map(dto, MedicalRecord.class);
        ms.update(d);
    }

}
