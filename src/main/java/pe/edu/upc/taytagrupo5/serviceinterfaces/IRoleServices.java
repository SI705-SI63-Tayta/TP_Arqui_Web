package pe.edu.upc.taytagrupo5.serviceinterfaces;

import pe.edu.upc.taytagrupo5.entities.Role;

import java.util.List;

public interface IRoleServices {

    public void insert(Role role);

    public List<Role> list();

    public void delete(int id);

    public void update(Role idRole);

    public Role lisById(int idRole);

    public List<String[]> quantityUserPerRol();




}
