package pe.edu.upc.taytagrupo5.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id_Rol;


    @Column(name = "tipo_rol", nullable = false, length = 15)
    private String tipo_rol;


    public Rol() {
    }

    public Rol(int id_Rol, String tipo_rol) {
        this.id_Rol = id_Rol;
        this.tipo_rol = tipo_rol;
    }


    public int getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(int id_Rol) {
        this.id_Rol = id_Rol;
    }

    public String getTipo_rol() {
        return tipo_rol;
    }

    public void setTipo_rol(String tipo_rol) {
        this.tipo_rol = tipo_rol;
    }
}
