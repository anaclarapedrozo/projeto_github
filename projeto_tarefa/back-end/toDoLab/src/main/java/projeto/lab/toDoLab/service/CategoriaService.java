package projeto.lab.toDoLab.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.lab.toDoLab.dto.CategoriaDto;
import projeto.lab.toDoLab.model.entity.Categories;
import projeto.lab.toDoLab.repository.CategoriaRepository;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void salvarCatetegoria(CategoriaDto categoriaDto){

//        Optional<Categories> categoriaBuscada = categoriaRepository.findByName(categoriaDto.getName());

//        if(categoriaBuscada.isPresent()) throw new RuntimeException("Ja existe uma categoria com esse nome");

        var categoria = new Categories();
        categoria.setName(categoriaDto.getName());

        categoriaRepository.save(categoria);
    }






}
