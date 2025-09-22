package pe.edu.upc.code_civitrack.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.code_civitrack.dtos.ValidacionDTO;
import pe.edu.upc.code_civitrack.entities.Validacion;
import pe.edu.upc.code_civitrack.servicesInterfaces.IValidacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/validaciones")
public class ValidacionController {

    @Autowired
    private IValidacionService vS;

    @GetMapping
    public List<ValidacionDTO> listar() {
        return vS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ValidacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ValidacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Validacion v = m.map(dto, Validacion.class);
        vS.insert(v);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Validacion validacion = vS.listId(id);
        if (validacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe validación con el ID: " + id);
        }
        vS.delete(id);
        return ResponseEntity.ok("Validación eliminada correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Validacion validacion = vS.listId(id);
        if (validacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe validación con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ValidacionDTO dto = m.map(validacion, ValidacionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ValidacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Validacion v = m.map(dto, Validacion.class);

        Validacion existente = vS.listId(v.getIdValidacion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe validación con el ID: " + v.getIdValidacion());
        }
        vS.update(v);
        return ResponseEntity.ok("Validación modificada correctamente.");
    }
}

