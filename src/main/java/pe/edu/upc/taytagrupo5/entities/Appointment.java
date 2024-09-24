package pe.edu.upc.taytagrupo5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAppointment;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "reason", nullable = false, length = 30)
    private String reason;

    @Column(name = "mode", nullable = false, length = 30)
    private String mode;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private User userCliente;

    @ManyToOne
    @JoinColumn(name = "idPersonal")
    private User userPersonal;

    public Appointment() {
    }

    public Appointment(int idAppointment, LocalDate date, String reason, String mode, String description, User userCliente, User userPersonal) {
        this.idAppointment = idAppointment;
        this.date = date;
        this.reason = reason;
        this.mode = mode;
        this.description = description;
        this.userCliente = userCliente;
        this.userPersonal = userPersonal;
    }

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
