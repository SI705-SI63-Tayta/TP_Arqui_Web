package pe.edu.upc.taytagrupo5.dtos;

import pe.edu.upc.taytagrupo5.entities.Recipe;

import java.time.LocalDate;

public class SearchBydniDTO {

    private String nombrepaciente;

    private String correo;

    private LocalDate fechahistoria;

    private String diagnostico;

    private Recipe recetaid;

    public String getNombrepaciente() {
        return nombrepaciente;
    }

    public void setNombrepaciente(String nombrepaciente) {
        this.nombrepaciente = nombrepaciente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechahistoria() {
        return fechahistoria;
    }

    public void setFechahistoria(LocalDate fechahistoria) {
        this.fechahistoria = fechahistoria;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Recipe getRecetaid() {
        return recetaid;
    }

    public void setRecetaid(Recipe recetaid) {
        this.recetaid = recetaid;
    }
}
