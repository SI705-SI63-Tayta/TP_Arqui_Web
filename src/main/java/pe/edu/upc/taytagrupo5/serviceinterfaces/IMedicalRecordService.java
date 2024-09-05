package pe.edu.upc.taytagrupo5.serviceinterfaces;

import pe.edu.upc.taytagrupo5.entities.MedicalRecord;

import java.util.List;

public interface IMedicalRecordService {

    public void insert(MedicalRecord medicalRecord);
    public List<MedicalRecord> list();
    public void delete(int idMedicalRecord);
    public void update(MedicalRecord medicalRecord);
}
