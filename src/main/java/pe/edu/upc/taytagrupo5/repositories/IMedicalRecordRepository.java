package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.MedicalRecord;

@Repository
public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {

}
