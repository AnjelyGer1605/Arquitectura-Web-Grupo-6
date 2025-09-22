package pe.edu.upc.code_civitrack.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.code_civitrack.dtos.EstudianteDTO;

import pe.edu.upc.code_civitrack.entities.Estudiante;

import pe.edu.upc.code_civitrack.servicesInterfaces.IEstudianteService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private IEstudianteService eS;

    @GetMapping
    public List<EstudianteDTO> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EstudianteDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody EstudianteDTO dto) {
        ModelMapper m = new ModelMapper();
        Estudiante r = m.map(dto, Estudiante.class);
        eS.insert(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Estudiante est = eS.listId(id);
        if (est == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un estudiante con el ID: " + id);
        }
        eS.delete(id);
        return ResponseEntity.ok("Vehiculo eliminado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Estudiante est = eS.listId(id);
        if (est == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un vehiculo con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        EstudianteDTO dto = m.map(est, EstudianteDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody EstudianteDTO dto) {
        ModelMapper m = new ModelMapper();
        Estudiante r = m.map(dto, Estudiante.class);

        Estudiante existente = eS.listId(r.getIdEstudiante());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un vehiculo con el ID: " + r.getIdEstudiante());
        }
        eS.update(r);
        return ResponseEntity.ok("Vehiculo actualizado correctamente.");
    }
}
