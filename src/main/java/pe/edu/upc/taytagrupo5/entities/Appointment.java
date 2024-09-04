package pe.edu.upc.taytagrupo5.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAppointment;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "reason", nullable = false, length = 30)
    private String reason;

    @Column(name = "mode", nullable = false, length = 10)
    private String mode;

    @Column(name = "description", nullable = false, length = 50)
    private String description;

    public Appointment() {
    }

    public Appointment(int idAppointment, Date date, String reason, String mode, String description) {
        this.idAppointment = idAppointment;
        this.date = date;
        this.reason = reason;
        this.mode = mode;
        this.description = description;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
