package pe.edu.upc.taytagrupo5.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.taytagrupo5.entities.User;
import pe.edu.upc.taytagrupo5.repositories.IUserRepository;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public void insert(User u) {
        uR.save(u);
    }

    @Override
    public List<User> list(){ return uR.findAll();}

    @Override
    public void delete(int idUser) {
        uR.deleteById(idUser);
    }

    @Override
    public User listId(int idUser) {
        return uR.findById(idUser).orElse(new User());
    }

    @Override
    public void update(User u) {
        uR.save(u);
    }

    @Override
    public List<String[]> listarfecha(String fecha) {
        return uR.listarfecha(fecha);
    }
}
