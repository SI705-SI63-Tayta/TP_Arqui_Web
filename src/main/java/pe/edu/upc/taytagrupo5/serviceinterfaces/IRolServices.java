package pe.edu.upc.taytagrupo5.serviceinterfaces;

import pe.edu.upc.taytagrupo5.entities.Rol;

import java.util.List;

public interface IRolServices {

    public void insert(Rol rol);

    public List<Rol> list();

    public void delete(int id);

    public void update(Rol idRol);

    public List<String[]> quantityUserPerRol();




}
