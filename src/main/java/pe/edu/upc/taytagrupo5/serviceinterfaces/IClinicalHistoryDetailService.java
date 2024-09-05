package pe.edu.upc.taytagrupo5.serviceinterfaces;

import pe.edu.upc.taytagrupo5.entities.ClinicalHistoryDetail;

import java.util.List;

public interface IClinicalHistoryDetailService {

    public void insert(ClinicalHistoryDetail clinical_History_Detail);

    public void update(ClinicalHistoryDetail clinical_History_Detail);

    public void delete(int id_detalle_historia);

    public List<ClinicalHistoryDetail> list();
}
