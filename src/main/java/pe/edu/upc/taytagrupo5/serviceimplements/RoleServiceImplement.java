package pe.edu.upc.taytagrupo5.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.taytagrupo5.entities.Role;
import pe.edu.upc.taytagrupo5.entities.User;
import pe.edu.upc.taytagrupo5.repositories.IRoleRepository;
import pe.edu.upc.taytagrupo5.repositories.IUserRepository;
import pe.edu.upc.taytagrupo5.servicesinterfaces.IRoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImplement implements IRoleService {

    @Autowired
    private IRoleRepository rR;
    @Autowired
    private IUserRepository rRu;


    @Override
    public void insert(Role role) {
        rR.save(role);
    }

    @Override
    public List<Role> list() {
        return rR.findAll();
    }

    @Override
    public void delete(int id) {
        Optional<Role> roleOptional = rR.findById(id);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            User user = role.getUser();
            if (user != null) {
                user.getRoles().remove(role);
                rRu.save(user);
            }
            rR.delete(role);
        }

    }

    @Override
    public Role listId(int id) {
        return rR.findById(id).orElse(new Role());
    }
}
