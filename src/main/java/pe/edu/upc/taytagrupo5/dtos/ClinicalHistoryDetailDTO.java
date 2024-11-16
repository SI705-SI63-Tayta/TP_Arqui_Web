package pe.edu.upc.taytagrupo5.dtos;

import pe.edu.upc.taytagrupo5.entities.Appointment;
import pe.edu.upc.taytagrupo5.entities.MedicalRecord;
import pe.edu.upc.taytagrupo5.entities.Recipe;

public class    ClinicalHistoryDetailDTO {

    private int idDetalleHistoria;

    private MedicalRecord medicalRecord;

    private Recipe recipe;

    private Appointment appointment;

    private String diagnostico;

    public int getIdDetalleHistoria() {
        return idDetalleHistoria;
    }

    public void setIdDetalleHistoria(int idDetalleHistoria) {
        this.idDetalleHistoria = idDetalleHistoria;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
