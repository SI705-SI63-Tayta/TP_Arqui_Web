package pe.edu.upc.taytagrupo5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name="Recipes")
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecipes;
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
    private Appointment ap;
    public Recipes() {
    }

    public Recipes(int idRecipes, String description, LocalDate startDate, LocalDate endDate, String state, Appointment ap) {
        this.idRecipes = idRecipes;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
        this.ap = ap;
    }

    public int getIdRecipes() {
        return idRecipes;
    }

    public void setIdRecipes(int idRecipes) {
        this.idRecipes = idRecipes;
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

    public Appointment getAp() {
        return ap;
    }

    public void setAp(Appointment ap) {
        this.ap = ap;
    }
}
