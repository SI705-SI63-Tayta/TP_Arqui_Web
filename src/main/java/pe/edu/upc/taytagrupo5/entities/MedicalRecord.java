package pe.edu.upc.taytagrupo5.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="MedicalRecord")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedicalRecord;
    @Column(name = "dateMedicalRecord", nullable = false)
    private LocalDate dateMedicalRecord;
    @OneToOne
    @JoinColumn(name="idUser")
    private User u;
    public MedicalRecord() {

    }

    public MedicalRecord(int idMedicalRecord, LocalDate dateMedicalRecord, User u) {
        this.idMedicalRecord = idMedicalRecord;
        this.dateMedicalRecord = dateMedicalRecord;
        this.u = u;
    }

    public int getIdMedicalRecord() {
        return idMedicalRecord;
    }

    public void setIdMedicalRecord(int idMedicalRecord) {
        this.idMedicalRecord = idMedicalRecord;
    }

    public LocalDate getDateMedicalRecord() {
        return dateMedicalRecord;
    }

    public void setDateMedicalRecord(LocalDate dateMedicalRecord) {
        this.dateMedicalRecord = dateMedicalRecord;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
}
