package pe.edu.upc.taytagrupo5.servicesinterfaces;

import pe.edu.upc.taytagrupo5.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role role);
    public List<Role> list();

    public void delete(int id);
    public Role listId(int id);
}
