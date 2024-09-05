package pe.edu.upc.taytagrupo5.serviceinterfaces;


import pe.edu.upc.taytagrupo5.entities.Notification;


import java.util.List;

public interface INotificationService {
    public List<Notification> list();
    public void insert(Notification n);
    public Notification listById(int id);
    public void update(Notification n);
    void delete(int id);

}
