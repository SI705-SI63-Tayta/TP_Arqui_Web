package pe.edu.upc.taytagrupo5.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idRol;

    @Column(name = "tipoRol", nullable = false, length = 15)
    private String tipoRol;

    public Role() {
    }

    public Role(int idRol, String tipoRol) {
        this.idRol = idRol;
        this.tipoRol = tipoRol;
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
}
