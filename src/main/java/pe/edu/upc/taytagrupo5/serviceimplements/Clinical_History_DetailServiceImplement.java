package pe.edu.upc.taytagrupo5.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.taytagrupo5.entities.Clinical_History_Detail;
import pe.edu.upc.taytagrupo5.repositories.IClinical_History_DetailRepository;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IClinical_History_DetailService;

import java.util.List;

@Service
public class Clinical_History_DetailServiceImplement implements IClinical_History_DetailService {
    @Autowired
    private IClinical_History_DetailRepository cHD;

    @Override
    public void insert(Clinical_History_Detail clinical_History_Detail) {
        cHD.save(clinical_History_Detail);
    }

    @Override
    public void update(Clinical_History_Detail clinical_History_Detail) {
        cHD.save(clinical_History_Detail);
    }

    @Override
    public void delete(int id_detalle_historia) {
        cHD.deleteById(id_detalle_historia);
    }

    @Override
    public List<Clinical_History_Detail> list() {
        return cHD.findAll();
    }
}
