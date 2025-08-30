package projeto.lab.toDoLab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.lab.toDoLab.dto.CategoriaDto;
import projeto.lab.toDoLab.model.entity.Categories;
import projeto.lab.toDoLab.repository.CategoriaRepository;
import projeto.lab.toDoLab.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    CategoriaRepository categoriaRepository;




    @PostMapping("/salvar")
    public ResponseEntity<CategoriaDto> salvar(@RequestBody CategoriaDto categoria){
            categoriaService.salvarCatetegoria(categoria);
            return ResponseEntity.ok(categoria);
    }


    @GetMapping("/todas")
    public List<Categories> returnAll(){
        return categoriaRepository.findAll();
    }
}
