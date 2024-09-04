package pe.edu.upc.taytagrupo5.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.taytagrupo5.entities.Rol;
import pe.edu.upc.taytagrupo5.repositories.IRolRepository;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IRolServices;

import java.util.List;


@Service
public class RolServiceImplement implements IRolServices {

    @Autowired
    private IRolRepository rR;


    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public void delete(int idRol) {
        rR.deleteById(idRol);
    }


    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }

    @Override
    public List<String[]> quantityUserPerRol() {
       return rR.quantityUserPerRol();
    }
}
