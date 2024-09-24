package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.ReviewDTO;
import pe.edu.upc.taytagrupo5.dtos.ReviewListDTO;
import pe.edu.upc.taytagrupo5.dtos.Top5PersonalDTO;
import pe.edu.upc.taytagrupo5.entities.Review;
import pe.edu.upc.taytagrupo5.entities.User;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IReviewService;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IUserService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resenas")
public class ReviewController {
    @Autowired
    private IReviewService rS;

    @Autowired
    private IUserService uS;
    @GetMapping
    public List<ReviewDTO> listar() {
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ReviewDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody ReviewDTO dto) {
        ModelMapper m = new ModelMapper();
        Review r = m.map(dto, Review.class);
        rS.insert(r);
    }
    @GetMapping("/{id}")
    public ReviewDTO getById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ReviewDTO dto = m.map(rS.listById(id), ReviewDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        rS.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody ReviewDTO dto) {
        ModelMapper m = new ModelMapper();
        Review r = m.map(dto, Review.class);
        rS.update(r);
    }
    @PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR')")
    @GetMapping("/calificacionmayor3")
    public List<ReviewListDTO> listarcalificacionmayor3(){
        List<String[]>lista=rS.listarcalificacionmayor3();
        List<ReviewListDTO>listaDTO=new ArrayList<>();

        for (String[] c:lista) {
            ReviewListDTO dto=new ReviewListDTO();
            dto.setIdReview(Integer.parseInt(c[0]));
            dto.setComment(c[1]);
            dto.setScore(Integer.parseInt(c[2]));
            dto.setIdCliente(Integer.parseInt(c[3]));
            dto.setIdPersonal(Integer.parseInt(c[4]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
@PreAuthorize("hasAnyAuthority('ENFERMERO','DOCTOR','ADMIN')")
    @GetMapping("/top5Personal")
    public List<Top5PersonalDTO>top5CalificacionPersonal(){
        List<String[]>lista=rS.top5CalificacionPersonal();
        List<Top5PersonalDTO> listaDTO=new ArrayList<>();

        for(String[] c:lista) {
            Top5PersonalDTO dto=new Top5PersonalDTO();
            dto.setFull_name(c[0]);
            dto.setAverage((double) Math.round(Double.parseDouble(c[1])),2);
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
