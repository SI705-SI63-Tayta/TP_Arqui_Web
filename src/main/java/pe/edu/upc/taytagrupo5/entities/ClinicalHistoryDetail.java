package pe.edu.upc.taytagrupo5.entities;


import jakarta.persistence.*;

@Entity
@Table(name="Clinical_History_Detail")
public class ClinicalHistoryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleHistoria;

    @ManyToOne
    @JoinColumn(name = "idMedicalRecord")
    private MedicalRecord medicalRecord;

    @ManyToOne
    @JoinColumn(name = "idRecipe")
    private  Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "idAppointment")
    private Appointment appointment;

    @Column(name = "diagnostico", nullable = false, length = 500)
    private String diagnostico;

    public ClinicalHistoryDetail() {
    }

    public ClinicalHistoryDetail(int idDetalleHistoria, MedicalRecord medicalRecord, Recipe recipe, Appointment appointment, String diagnostico) {
        this.idDetalleHistoria = idDetalleHistoria;
        this.medicalRecord = medicalRecord;
        this.recipe = recipe;
        this.appointment = appointment;
        this.diagnostico = diagnostico;
    }

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
