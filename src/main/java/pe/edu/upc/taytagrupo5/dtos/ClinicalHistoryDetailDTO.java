package pe.edu.upc.taytagrupo5.dtos;

import pe.edu.upc.taytagrupo5.entities.Appointment;
import pe.edu.upc.taytagrupo5.entities.Recipes;

public class ClinicalHistoryDetailDTO {

    private int id_detalle_historia;

    private Recipes recetas_receta_id;

    private Appointment cita_cita_id;

    private String diagnostico;


    public int getId_detalle_historia() {
        return id_detalle_historia;
    }

    public void setId_detalle_historia(int id_detalle_historia) {
        this.id_detalle_historia = id_detalle_historia;
    }

    public Recipes getRecetas_receta_id() {
        return recetas_receta_id;
    }

    public void setRecetas_receta_id(Recipes recetas_receta_id) {
        this.recetas_receta_id = recetas_receta_id;
    }

    public Appointment getCita_cita_id() {
        return cita_cita_id;
    }

    public void setCita_cita_id(Appointment cita_cita_id) {
        this.cita_cita_id = cita_cita_id;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
