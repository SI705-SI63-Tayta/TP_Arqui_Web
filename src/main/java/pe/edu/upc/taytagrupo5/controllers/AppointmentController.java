package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

//actualizando emerson
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

    @GetMapping("/cantidadCitas")
    public List<AppointmentCountDTO> AppointmentCountDTO(@RequestParam LocalDate date1, @RequestParam LocalDate date2){
        List<String[]> filaLista = aS.cantidadCitasPeriodo(date1,date2);
        List<AppointmentCountDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            AppointmentCountDTO dto = new AppointmentCountDTO();
            dto.setIdUser(Integer.parseInt(columna[0]));
            dto.setFullName(columna[1]);
            dto.setCantidad(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
