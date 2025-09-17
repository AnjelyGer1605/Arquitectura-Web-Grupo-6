package pe.edu.upc.code_civitrack.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.code_civitrack.dtos.UbicacionDTO;
import pe.edu.upc.code_civitrack.entities.Ubicacion;
import pe.edu.upc.code_civitrack.servicesInterfaces.IUbicacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Ubicaciones")
public class UbicacionController {

    @Autowired
    private IUbicacionService uS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<UbicacionDTO> lista = uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x,UbicacionDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen ubicaciones registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody UbicacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Ubicacion u = m.map(dto, Ubicacion.class);
        uS.insert(u);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ubicacion registrado correctamente.");
    }

}
