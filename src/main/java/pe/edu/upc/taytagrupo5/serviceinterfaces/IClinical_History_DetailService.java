package pe.edu.upc.taytagrupo5.serviceinterfaces;

import pe.edu.upc.taytagrupo5.entities.Clinical_History_Detail;

import java.util.List;

public interface IClinical_History_DetailService {

    public void insert(Clinical_History_Detail clinical_History_Detail);

    public void update(Clinical_History_Detail clinical_History_Detail);

    public void delete(int id_detalle_historia);

    public List<Clinical_History_Detail> list();
}
