package pe.edu.upc.taytagrupo5.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.taytagrupo5.entities.User;
import pe.edu.upc.taytagrupo5.repositories.IUserRepository;
import pe.edu.upc.taytagrupo5.servicesinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public void insert(User user){
        uR.save(user);}
    @Override
    public List<User> list(){
        return uR.findAll();}

    @Override
    public void delete(int id) {
        uR.deleteById(id);

    }

    @Override
    public User listId(int id) {
        return uR.findById(id).orElse(new User());
    }

    @Override
    public User findByUserName(String username) {
        return uR.findByUserName(username);
    }
}
