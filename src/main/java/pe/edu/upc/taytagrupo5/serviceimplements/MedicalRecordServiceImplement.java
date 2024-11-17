package pe.edu.upc.taytagrupo5.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.taytagrupo5.entities.MedicalRecord;
import pe.edu.upc.taytagrupo5.repositories.IMedicalRecordRepository;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IMedicalRecordService;

import java.util.List;

@Service
public class MedicalRecordServiceImplement implements IMedicalRecordService {

    @Autowired
    private IMedicalRecordRepository mR;

    @Override
    public void insert(MedicalRecord medicalRecord) {
        mR.save(medicalRecord);
    }

    @Override
    public List<MedicalRecord> list() {
        return mR.findAll();
    }

    @Override
    public void delete(int idMedicalRecord) {
        mR.deleteById(idMedicalRecord);
    }

    @Override
    public void update(MedicalRecord medicalRecord) {
        mR.save(medicalRecord);
    }

    @Override
    public MedicalRecord listById(int idMedicalRecord) {
        return mR.findById(idMedicalRecord).orElse(new MedicalRecord());
    }


    @Override
    public List<String[]> findUserRecordsWithinDateRange(String date1, String date2) {
        return mR.findUserRecordsWithinDateRange(date1,date2);
    }

}
