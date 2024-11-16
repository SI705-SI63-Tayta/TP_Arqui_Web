package pe.edu.upc.taytagrupo5.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.taytagrupo5.dtos.SearchByDniDTO;
import pe.edu.upc.taytagrupo5.entities.ClinicalHistoryDetail;

import java.util.List;

public interface IClinicalHistoryDetailService {

    public void insert(ClinicalHistoryDetail clinical_History_Detail);

    public void update(ClinicalHistoryDetail clinical_History_Detail);

    public void delete(int id_detalle_historia);

    public ClinicalHistoryDetail findById(int idDetalleHistoria);

    public List<ClinicalHistoryDetail> list();

    public List<String[]> findByDNI(String dni);
}
