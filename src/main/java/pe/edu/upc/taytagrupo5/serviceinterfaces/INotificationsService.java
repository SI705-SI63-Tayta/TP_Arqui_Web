package pe.edu.upc.taytagrupo5.serviceinterfaces;


import pe.edu.upc.taytagrupo5.entities.Notifications;


import java.util.List;

public interface INotificationsService {
    public List<Notifications> list();
    public void insert(Notifications n);
    public Notifications listById(int id);
    public void update(Notifications n);
    void delete(Integer id);

}
