package pe.edu.upc.taytagrupo5.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idRol;

    @Column(name = "tipo_rol", nullable = false, length = 15)
    private String tipoRol;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idRol")
    private List<User> users;

    public Rol() {
    }

    public Rol(int idRol, String tipoRol, List<User> users) {
        this.idRol = idRol;
        this.tipoRol = tipoRol;
        this.users = users;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
