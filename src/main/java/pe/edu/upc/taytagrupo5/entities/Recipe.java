package pe.edu.upc.taytagrupo5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name="Recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecipe;

    @Column(name = "description", nullable = false,length = 100)
    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name="end_date", nullable = false)
    private LocalDate endDate;

    @Column(name="state", nullable = false,length = 20)
    private String state;

    @OneToOne
    @JoinColumn(name="idAppointment")
    private Appointment appointment;

    public Recipe() {
    }

    public Recipe(int idRecipe, String description, LocalDate startDate, LocalDate endDate, String state, Appointment appointment) {
        this.idRecipe = idRecipe;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.appointment = appointment;
    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
