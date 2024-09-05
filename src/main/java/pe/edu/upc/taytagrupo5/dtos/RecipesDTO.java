package pe.edu.upc.taytagrupo5.dtos;

import pe.edu.upc.taytagrupo5.entities.Appointment;

import java.time.LocalDate;

public class RecipesDTO {
    private int idRecipes;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String state;
    private Appointment ap;

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
