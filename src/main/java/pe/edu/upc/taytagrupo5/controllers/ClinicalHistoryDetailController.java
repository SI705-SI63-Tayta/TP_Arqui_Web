package pe.edu.upc.taytagrupo5.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.ClinicalHistoryDetailDTO;
import pe.edu.upc.taytagrupo5.dtos.SearchBydniDTO;
import pe.edu.upc.taytagrupo5.entities.ClinicalHistoryDetail;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IClinicalHistoryDetailService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Detalle_historiaclinica")
public class ClinicalHistoryDetailController {

    @Autowired
    private IClinicalHistoryDetailService hDS;

    @PostMapping
    public void registrar(@RequestBody ClinicalHistoryDetailDTO dto) {
        ModelMapper m = new ModelMapper();
        ClinicalHistoryDetail d = m.map(dto, ClinicalHistoryDetail.class);
        hDS.insert(d);
    }

    @GetMapping
    public List<ClinicalHistoryDetailDTO> listar() {
        return hDS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, ClinicalHistoryDetailDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        hDS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody ClinicalHistoryDetailDTO dto) {
        ModelMapper m = new ModelMapper();
        ClinicalHistoryDetail d = m.map(dto, ClinicalHistoryDetail.class);
        hDS.update(d);
    }


    @GetMapping("/buscar")
    public List<SearchBydniDTO> buscar(@RequestParam String dni) {
        return hDS.findByDNI(dni).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,SearchBydniDTO.class);
        }).collect(Collectors.toList());
    }


















}
