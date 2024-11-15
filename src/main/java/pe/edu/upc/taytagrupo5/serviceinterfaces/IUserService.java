package pe.edu.upc.taytagrupo5.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.taytagrupo5.entities.User;

import java.time.LocalDate;
import java.util.List;

public interface IUserService {
    public void insert(User u);
    public List<User> list();
    public void delete(int idUser);
    public User listId(int idUser);
    public void update(User u);
    public List<String[]> listarfecha(LocalDate date1, LocalDate date2);
    public User findUsername(String username);
    public Boolean existsUser(String username);
    public Boolean existsDni(String dni);
}
