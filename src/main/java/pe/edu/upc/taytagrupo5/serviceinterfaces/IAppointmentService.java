package pe.edu.upc.taytagrupo5.serviceinterfaces;
import pe.edu.upc.taytagrupo5.entities.Appointment;

import java.util.List;

public interface IAppointmentService {
    public List<Appointment> list();
    public void insert(Appointment a);
    public Appointment listById(int id);
    public void update(Appointment a);
    public void deleteById(int id);
}
