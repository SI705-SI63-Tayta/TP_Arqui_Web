package pe.edu.upc.taytagrupo5.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.taytagrupo5.entities.ClinicalHistoryDetail;
import pe.edu.upc.taytagrupo5.repositories.IClinicalHistoryDetailRepository;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IClinicalHistoryDetailService;

import java.util.List;

@Service
public class ClinicalHistoryDetailServiceImplement implements IClinicalHistoryDetailService {
    @Autowired
    private IClinicalHistoryDetailRepository cHD;

    @Override
    public void insert(ClinicalHistoryDetail clinical_History_Detail) {
        cHD.save(clinical_History_Detail);
    }

    @Override
    public void update(ClinicalHistoryDetail clinical_History_Detail) {
        cHD.save(clinical_History_Detail);
    }

    @Override
    public void delete(int id_detalle_historia) {
        cHD.deleteById(id_detalle_historia);
    }

    @Override
    public List<ClinicalHistoryDetail> list() {
        return cHD.findAll();
    }

    @Override
    public List<ClinicalHistoryDetail> findByDNI(String dni) {
        return cHD.findByDNI(dni);
    }
}
