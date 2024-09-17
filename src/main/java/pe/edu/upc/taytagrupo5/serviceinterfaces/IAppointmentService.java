package pe.edu.upc.taytagrupo5.serviceinterfaces;
import pe.edu.upc.taytagrupo5.entities.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface IAppointmentService {
    public List<Appointment> list();
    public void insert(Appointment a);
    public Appointment listById(int id);
    public void update(Appointment a);
    public void deleteById(int id);
    public List<String[]> cantidadModalidadesCitas();
    public List<String[]> cantidadCitasPeriodo(LocalDate date1, LocalDate date2);
    public List<String[]> listarPacientesPorPersonal(String personal);
    public List<String[]> listarPacientesPorFecha(String fecha);
}
