package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.*;
import pe.edu.upc.taytagrupo5.entities.Appointment;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IAppointmentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = {"http://localhost:4200"})
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

    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','CLIENTE')")
    @PostMapping
    public void insert(@RequestBody AppointmentDTO dto){
        ModelMapper m = new ModelMapper();
        Appointment a = m.map(dto, Appointment.class);
        aS.insert(a);
    }

    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','CLIENTE')")
    @GetMapping("/{id}")
    public AppointmentDTO getById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        AppointmentDTO dto = m.map(aS.listById(id), AppointmentDTO.class);
        return dto;
    }

    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','CLIENTE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        try {
            aS.deleteById(id); // Intentamos eliminar la cita
            return ResponseEntity.ok("Cita eliminada con éxito.");
        } catch (Exception e) {
            // Si ocurre algún error, respondemos con Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la cita.");
        }
    }

    @PutMapping
    public void update(@RequestBody AppointmentDTO dto) {
        ModelMapper m = new ModelMapper();
        Appointment a= m.map(dto,Appointment.class);
        aS.update(a);
    }

    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
    @GetMapping("/cantidadModoCitas")
    public List<AppointmentModeDTO> cantidadmodo() {
        List<String[]> lista=aS.cantidadModalidadesCitas();
        List<AppointmentModeDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            AppointmentModeDTO dto=new AppointmentModeDTO();
            dto.setMode(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
    @GetMapping("/ListarPacientesPorPersonal")
    public List<ListPatientsByStaffDTO> listPatientsByStaff(@RequestParam String personal){
        List<String[]> lista2=aS.listarPacientesPorPersonal(personal);
        List<ListPatientsByStaffDTO> listaDTO=new ArrayList<>();

        for(String[] c:lista2){
            ListPatientsByStaffDTO dto=new ListPatientsByStaffDTO();
            dto.setTipoRol(c[0]);
            dto.setStaffName(c[1]);
            dto.setPatientName(c[2]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
    @GetMapping("/ListarPacientesPorFecha")
    public List<ListPatientsByDateDTO> listPatientsByDate(@RequestParam String date){
        List<String[]> lista3=aS.listarPacientesPorFecha(date);
        List<ListPatientsByDateDTO> listaDTO=new ArrayList<>();

        for(String[] c:lista3){
            ListPatientsByDateDTO dto=new ListPatientsByDateDTO();
            dto.setNamePatient(c[0]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMINISTRADOR')")
    @GetMapping("/cantidadCitas")
    public List<AppointmentCountDTO> AppointmentCountDTO(@RequestParam String date1, @RequestParam String date2){
        List<String[]> filaLista = aS.cantidadCitasPeriodo(date1,date2);
        List<AppointmentCountDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            AppointmentCountDTO dto = new AppointmentCountDTO();
            dto.setDni(columna[0]);
            dto.setFullName(columna[1]);
            dto.setCantidad(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
