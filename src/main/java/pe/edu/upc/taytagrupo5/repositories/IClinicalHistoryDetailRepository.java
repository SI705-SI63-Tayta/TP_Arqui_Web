package pe.edu.upc.taytagrupo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.taytagrupo5.entities.ClinicalHistoryDetail;

import java.util.List;

@Repository
public interface IClinicalHistoryDetailRepository extends JpaRepository<ClinicalHistoryDetail, Integer> {

    @Query(value =" SELECT \n" +
            "    u.full_name AS NombrePaciente,\n" +
            "    u.email AS Correo,\n" +
            "    hc.date_medical_record AS FechaHistoria,\n" +
            "    dhc.Diagnostico AS Diagnostico,\n" +
            "    dhc.id_recipes AS RecetaID \n" +
            " FROM users u\n" +
            " JOIN medical_record hc ON u.id_user = hc.id_user\n" +
            " JOIN clinical_history_detail dhc ON hc.id_medical_record = dhc.id_detalle_historia\n" +
            " WHERE u.DNI = '12345678';" ,nativeQuery = true)
    public List<ClinicalHistoryDetail> findByDNI(String DNI);





}
