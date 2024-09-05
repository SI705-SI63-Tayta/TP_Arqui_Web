package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.ClinicalHistoryDetail;

@Repository
public interface IClinicalHistoryDetailRepository extends JpaRepository<ClinicalHistoryDetail, Integer> {





}
