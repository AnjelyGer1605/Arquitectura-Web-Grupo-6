package pe.edu.upc.code_civitrack.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.code_civitrack.dtos.CategoriaDTO;
import pe.edu.upc.code_civitrack.entities.Categoria;
import pe.edu.upc.code_civitrack.servicesInterfaces.ICategoriaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService cS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<CategoriaDTO> lista = cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CategoriaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen categorias registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody CategoriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Categoria c = m.map(dto, Categoria.class);
        cS.insert(c);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Categoria registrado correctamente.");
    }


}