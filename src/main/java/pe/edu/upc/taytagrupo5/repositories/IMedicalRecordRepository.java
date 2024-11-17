package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.MedicalRecord;

import java.util.List;

@Repository
public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {
    @Query(value ="SELECT u.dni, ch.diagnostico \n" +
            "FROM medical_record m \n" +
            "INNER JOIN clinical_history_detail ch ON ch.id_medical_record = m.id_medical_record\n" +
            "INNER JOIN users u ON m.id_user = u.id_user\n" +
            "WHERE m.date_medical_record BETWEEN TO_DATE(:startDate, 'DD-MM-YYYY') \n" +
            "                                 AND TO_DATE(:endDate, 'DD-MM-YYYY');\n", nativeQuery = true)
    public List<String[]> findUserRecordsWithinDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);

}