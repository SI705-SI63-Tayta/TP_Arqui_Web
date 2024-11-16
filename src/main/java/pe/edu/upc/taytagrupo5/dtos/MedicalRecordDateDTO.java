package pe.edu.upc.taytagrupo5.dtos;

public class MedicalRecordDateDTO {
    private int idUser;
    private String fullName;
    private String dateMedicalRecord;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateMedicalRecord() {
        return dateMedicalRecord;
    }

    public void setDateMedicalRecord(String dateMedicalRecord) {
        this.dateMedicalRecord = dateMedicalRecord;
    }
}

