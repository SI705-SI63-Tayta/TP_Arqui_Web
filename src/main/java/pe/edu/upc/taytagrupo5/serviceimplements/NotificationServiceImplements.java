package pe.edu.upc.taytagrupo5.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.taytagrupo5.entities.Notification;
import pe.edu.upc.taytagrupo5.repositories.INotificationRepository;
import pe.edu.upc.taytagrupo5.serviceinterfaces.INotificationService;

import java.util.List;

@Service
public class NotificationServiceImplements implements INotificationService {
    @Autowired
    private INotificationRepository nR;

    @Override
    public void insert(Notification n) {
        nR.save(n);
    }

    @Override
    public Notification listById(int id) {
        return nR.findById(id).orElse(new Notification());
    }

    @Override
    public List<Notification> list() {
        return nR.findAll();
    }

    @Override
    public void update(Notification n) {
        nR.save(n);
    }

    @Override
    public void delete(int id) {
        nR.deleteById(id);
    }

}
