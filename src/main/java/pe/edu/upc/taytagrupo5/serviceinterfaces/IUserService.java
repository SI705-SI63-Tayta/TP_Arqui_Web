package pe.edu.upc.taytagrupo5.servicesinterfaces;

import pe.edu.upc.taytagrupo5.entities.User;

import java.util.List;

public interface IUserService {
    public void insert(User user);
    public List<User> list();
    public void delete(int id);
    public User listId(int id);
    public User findByUserName(String username);
}
