package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.MedicalRecord;

@Repository
public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {
  /*  @Query(value ="\n" +
            "SELECT m.id_user, u.full_name AS fullName \n" +
            "FROM medical_record m \n" +
            "JOIN users u ON m.id_user = u.id_user \n" +
            "WHERE m.date_medical_record BETWEEN '2024-01-01' AND '2024-12-31' \n" +
            "GROUP BY m.id_user, u.full_name;" ,nativeQuery = true)
    public List<String[]>*/
}
