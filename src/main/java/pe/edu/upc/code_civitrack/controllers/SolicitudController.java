package pe.edu.upc.code_civitrack.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.code_civitrack.dtos.SolicitudDTO;
import pe.edu.upc.code_civitrack.entities.Solicitud;
import pe.edu.upc.code_civitrack.servicesInterfaces.ISolicitudService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {
    @Autowired
    private ISolicitudService sS;

    @GetMapping
    public List<SolicitudDTO> listar() {
        return sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SolicitudDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody SolicitudDTO dto) {
        ModelMapper m = new ModelMapper();
        Solicitud s = m.map(dto, Solicitud.class);
        sS.insert(s);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Solicitud solicitud = sS.listId(id);
        if (solicitud == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe solicitud con el ID: " + id);
        }
        sS.delete(id);
        return ResponseEntity.ok("Solicitud eliminada correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Solicitud solicitud = sS.listId(id);
        if (solicitud == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe solicitud con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        SolicitudDTO dto = m.map(solicitud, SolicitudDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody SolicitudDTO dto) {
        ModelMapper m = new ModelMapper();
        Solicitud s = m.map(dto, Solicitud.class);

        Solicitud existente = sS.listId(s.getIdSolicitud());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe solicitud con el ID: " + s.getIdSolicitud());
        }
        sS.update(s);
        return ResponseEntity.ok("Solicitud modificada correctamente.");
    }
}
