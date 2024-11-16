package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.AppointmentCountDTO;
import pe.edu.upc.taytagrupo5.dtos.MedicalRecordDTO;
import pe.edu.upc.taytagrupo5.dtos.MedicalRecordDateDTO;
import pe.edu.upc.taytagrupo5.entities.MedicalRecord;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IMedicalRecordService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/HistoriaClinica")
@CrossOrigin(origins = {"http://localhost:4200"})
public class MedicalRecordController {

    @Autowired
    private IMedicalRecordService ms;

    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
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
    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        ms.delete(id);
    }
    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
    @PutMapping
    public void modificar(@RequestBody MedicalRecordDTO dto) {
        ModelMapper m = new ModelMapper();
        MedicalRecord d = m.map(dto, MedicalRecord.class);
        ms.update(d);
    }
    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
    @GetMapping("/fechaCita")
    public List<MedicalRecordDateDTO> MedicalRecordDateDTO(@RequestParam String date1, @RequestParam String date2){
        List<Object[]> filaLista = ms.findUserRecordsWithinDateRange(date1,date2);
        List<MedicalRecordDateDTO> dtoLista = new ArrayList<>();
        for (Object[] columna : filaLista) {
            MedicalRecordDateDTO dto = new MedicalRecordDateDTO();
            dto.setIdMedicalRecord(Integer.parseInt((String) columna[0]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
