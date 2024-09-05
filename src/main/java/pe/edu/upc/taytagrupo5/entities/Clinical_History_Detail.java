package pe.edu.upc.taytagrupo5.entities;


import jakarta.persistence.*;

@Entity
@Table(name="Clinical_History_Detail")
public class Clinical_History_Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detalle_historia;


   // private int historia_clinica_id_hist_clinc;

    @ManyToOne
    @JoinColumn(name = "idRecipes")
    private  Recipes recetas_receta_id;

    @ManyToOne
    @JoinColumn(name = "idAppointment")
    private Appointment cita_cita_id;


    @Column(name = "diagnostico", nullable = false, length = 500)
    private String diagnostico;

    public Clinical_History_Detail() {
    }

    public Clinical_History_Detail(int id_detalle_historia, Recipes recetas_receta_id, Appointment cita_cita_id, String diagnostico) {
        this.id_detalle_historia = id_detalle_historia;
        this.recetas_receta_id = recetas_receta_id;
        this.cita_cita_id = cita_cita_id;
        this.diagnostico = diagnostico;
    }


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
