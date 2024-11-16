package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.MedicalRecord;

import java.util.List;

@Repository
public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {
    @Query(value = """
    SELECT m.id_user AS idUser, u.full_name AS fullName
    FROM medical_record m
    JOIN users u ON m.id_user = u.id_user
    WHERE m.date_medical_record BETWEEN :startDate AND :endDate
    GROUP BY m.id_user, u.full_name
""", nativeQuery = true)
    public List<Object[]> findUserRecordsWithinDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
