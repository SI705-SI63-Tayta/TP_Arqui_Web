package pe.edu.upc.taytagrupo5.dtos;

import pe.edu.upc.taytagrupo5.entities.User;

import java.time.LocalDate;

public class MedicalRecordDTO {
    private int idMedicalRecord;
    private LocalDate dateMedicalRecord;
    private User u;

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
