package pe.edu.upc.taytagrupo5.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.taytagrupo5.dtos.ReviewDTO;
import pe.edu.upc.taytagrupo5.entities.Review;
import pe.edu.upc.taytagrupo5.serviceinterfaces.IReviewService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resenas")
public class ReviewController {
    @Autowired
    private IReviewService rS;

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

}
