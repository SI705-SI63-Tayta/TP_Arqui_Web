package pe.edu.upc.taytagrupo5.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.taytagrupo5.entities.Appointment;
import pe.edu.upc.taytagrupo5.repositories.IAppointmentRepository;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IAppointmentService;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServiceImplement implements IAppointmentService {

    @Autowired
    private IAppointmentRepository aR;


    @Override
    public List<Appointment> list() {
        return aR.findAll();
    }

    @Override
    public void insert(Appointment a) {
        aR.save(a);
    }

    @Override
    public Appointment listById(int id) {
        return aR.findById(id).orElse(new Appointment());
    }

    @Override
    public void update(Appointment a) {
        aR.save(a);
    }

    @Override
    public void deleteById(int id) {
        aR.deleteById(id);
    }

    @Override
    public List<String[]> cantidadModalidadesCitas() {
        return aR.cantidadModalidadesCitas();
    }

    @Override
    public List<String[]> cantidadCitasPeriodo(String date1, String date2) {
        return aR.cantidadCitasPeriodo(date1, date2);
    }

    @Override
    public List<String[]> listarPacientesPorPersonal(String personal) {
        return aR.listarPacientesPorPersonal(personal);
    }

    @Override
    public List<String[]> listarPacientesPorFecha(String fecha) {
        return aR.listarPacientesPorFecha(fecha);
    }

}
