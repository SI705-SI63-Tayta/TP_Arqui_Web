package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.MedicalRecordDTO;
import pe.edu.upc.taytagrupo5.entities.MedicalRecord;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IMedicalRecordService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/HistoriaClinica")
public class MedicalRecordController {

    @Autowired
    private IMedicalRecordService ms;

    @PostMapping
    public void registrar(@RequestBody MedicalRecordDTO dto) {
        ModelMapper m = new ModelMapper();
        MedicalRecord d = m.map(dto, MedicalRecord.class);
        ms.insert(d);
    }


    @GetMapping
    public List<MedicalRecordDTO> listar(){
        return ms.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,MedicalRecordDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        ms.delete(id);
    }
    @PutMapping
    public void modificar(@RequestBody MedicalRecordDTO dto) {
        ModelMapper m = new ModelMapper();
        MedicalRecord d = m.map(dto, MedicalRecord.class);
        ms.update(d);
    }

}
