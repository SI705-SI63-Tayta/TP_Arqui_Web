package pe.edu.upc.taytagrupo5.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.Clinical_History_DetailDTO;
import pe.edu.upc.taytagrupo5.entities.Clinical_History_Detail;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IClinical_History_DetailService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Detalle_historiaclinica")
public class Clinical_History_DetailController {

    @Autowired
    private IClinical_History_DetailService hDS;

    @PostMapping
    public void registrar(@RequestBody Clinical_History_DetailDTO dto) {
        ModelMapper m = new ModelMapper();
        Clinical_History_Detail d = m.map(dto, Clinical_History_Detail.class);
        hDS.insert(d);
    }

    @GetMapping
    public List<Clinical_History_DetailDTO> listar() {
        return hDS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,Clinical_History_DetailDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        hDS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody Clinical_History_DetailDTO dto) {
        ModelMapper m = new ModelMapper();
        Clinical_History_Detail d = m.map(dto, Clinical_History_Detail.class);
        hDS.update(d);
    }





















}
