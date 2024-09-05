package pe.edu.upc.taytagrupo5.dtos;

import pe.edu.upc.taytagrupo5.entities.User;

import java.time.LocalDate;

public class AppointmentDTO {

    private int idAppointment;

    private LocalDate date;

    private String reason;

    private String mode;

    private String description;

    private User userCliente;

    private User userPersonal;

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUserCliente() {
        return userCliente;
    }

    public void setUserCliente(User userCliente) {
        this.userCliente = userCliente;
    }

    public User getUserPersonal() {
        return userPersonal;
    }

    public void setUserPersonal(User userPersonal) {
        this.userPersonal = userPersonal;
    }
}
