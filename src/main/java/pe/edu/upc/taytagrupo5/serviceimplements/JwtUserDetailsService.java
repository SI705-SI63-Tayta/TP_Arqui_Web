package pe.edu.upc.taytagrupo5.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.taytagrupo5.entities.Role;
import pe.edu.upc.taytagrupo5.entities.User;
import pe.edu.upc.taytagrupo5.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository uR;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=uR.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        List<GrantedAuthority> roles=new ArrayList<>();

        Role role=user.getRole();
        roles.add(new SimpleGrantedAuthority(role.getTipoRol()));

        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, roles);
        return ud;
    }

    public User getUserByUsername(String username) {
        return uR.findByUsername(username);
    }

}
