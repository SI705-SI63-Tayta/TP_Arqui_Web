package pe.edu.upc.taytagrupo5.entities;


import jakarta.persistence.*;

@Entity
@Table(name="Medical_record")
public class Medical_record{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_hist_clinc;

    @Column(name= "Usuario_id_usuario",nullable = false)
    private int Usuario_id_usuario;


    public Medical_record() {
    }

    public Medical_record(int id_hist_clinc, int usuario_id_usuario) {
        this.id_hist_clinc = id_hist_clinc;
        Usuario_id_usuario = usuario_id_usuario;
    }


    public int getId_hist_clinc() {
        return id_hist_clinc;
    }

    public void setId_hist_clinc(int id_hist_clinc) {
        this.id_hist_clinc = id_hist_clinc;
    }

    public int getUsuario_id_usuario() {
        return Usuario_id_usuario;
    }

    public void setUsuario_id_usuario(int usuario_id_usuario) {
        Usuario_id_usuario = usuario_id_usuario;
    }
}
