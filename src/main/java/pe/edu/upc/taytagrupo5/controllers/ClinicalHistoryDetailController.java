package pe.edu.upc.taytagrupo5.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.ClinicalHistoryDetailDTO;
import pe.edu.upc.taytagrupo5.dtos.SearchByDniDTO;
import pe.edu.upc.taytagrupo5.entities.ClinicalHistoryDetail;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IClinicalHistoryDetailService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Detalle_historiaclinica")
@PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
public class ClinicalHistoryDetailController {

    @Autowired
    private IClinicalHistoryDetailService hDS;

    @PostMapping
    public void registrar(@RequestBody ClinicalHistoryDetailDTO dto) {
        ModelMapper m = new ModelMapper();
        ClinicalHistoryDetail d = m.map(dto, ClinicalHistoryDetail.class);
        hDS.insert(d);
    }

    @GetMapping("/{id}")
    public ClinicalHistoryDetailDTO getById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ClinicalHistoryDetailDTO dto=m.map(hDS.findById(id), ClinicalHistoryDetailDTO.class);
        return dto;
    }


    @GetMapping
    public List<ClinicalHistoryDetailDTO> listar() {
        return hDS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
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
    public List<SearchByDniDTO> buscar(@RequestParam String dni) {
        List<String[]> lista = hDS.findByDNI(dni);
        List<SearchByDniDTO>listadto=new ArrayList<>();

        for(String[] c:lista){
            SearchByDniDTO dto=new SearchByDniDTO();
            dto.setNombrepaciente(c[0]);
            dto.setCorreo(c[1]);
            dto.setFechahistoria(LocalDate.parse(c[2]));
            dto.setDiagnostico(c[3]);
            dto.setRecetaid(Integer.parseInt(c[4]));
            listadto.add(dto);
        }
        return listadto;
    }
}