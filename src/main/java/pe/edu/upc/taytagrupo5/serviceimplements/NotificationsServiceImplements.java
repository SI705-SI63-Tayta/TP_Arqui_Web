package pe.edu.upc.taytagrupo5.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.taytagrupo5.entities.Notifications;
import pe.edu.upc.taytagrupo5.serviceinterfaces.INotificationsService;

import java.util.List;

@Service
public class NotificationsServiceImplements implements INotificationsService {
    @Autowired
    private INotificationsService nR;

    @Override
    public void insert(Notifications n) {
        nR.insert(n);
    }

    @Override
    public Notifications listById(int id) {
        return nR.listById(id);
    }

    @Override
    public List<Notifications> list() {
        return nR.list();
    }

    @Override
    public void update(Notifications n) {
        nR.update(n);
    }

    @Override
    public void delete(Integer id) {
        nR.delete(id);
    }

}
