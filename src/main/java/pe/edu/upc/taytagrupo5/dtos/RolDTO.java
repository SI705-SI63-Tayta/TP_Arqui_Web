package pe.edu.upc.taytagrupo5.dtos;

import jakarta.persistence.*;
import pe.edu.upc.taytagrupo5.entities.User;

import java.util.List;

public class RolDTO {

    private  int idRol;

    private String tipoRol;

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
