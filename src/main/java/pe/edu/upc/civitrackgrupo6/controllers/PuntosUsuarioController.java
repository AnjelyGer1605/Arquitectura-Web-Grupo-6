package pe.edu.upc.civitrackgrupo6.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.civitrackgrupo6.dtos.PuntosUsuarioDTO;
import pe.edu.upc.civitrackgrupo6.entities.PuntosUsuario;
import pe.edu.upc.civitrackgrupo6.servicesInterfaces.IPuntosUsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/puntosusuario")

public class PuntosUsuarioController {
    @Autowired
    private IPuntosUsuarioService pS;

    @GetMapping
    public List<PuntosUsuarioDTO> listar() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PuntosUsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody PuntosUsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        PuntosUsuario p = m.map(dto, PuntosUsuario.class);
        pS.insert(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        PuntosUsuario puntos = pS.listId(id);
        if (puntos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe registro de puntos con el ID: " + id);
        }
        pS.delete(id);
        return ResponseEntity.ok("Puntos de usuario eliminados correctamente.");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        PuntosUsuario puntos = pS.listId(id);
        if (puntos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe registro de puntos con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        PuntosUsuarioDTO dto = m.map(puntos, PuntosUsuarioDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody PuntosUsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        PuntosUsuario p = m.map(dto, PuntosUsuario.class);

        PuntosUsuario existente = pS.listId(p.getIdPuntos());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe registro de puntos con el ID: " + p.getIdPuntos());
        }
        pS.update(p);
        return ResponseEntity.ok("Puntos de usuario modificados correctamente.");
    }
    @GetMapping("/total/{idUsuario}")
    public ResponseEntity<?> totalPuntosPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
        Integer total = pS.totalPuntosPorUsuario(idUsuario);
        if (total == null || total == 0) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("El usuario con ID " + idUsuario + " no tiene puntos registrados.");
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("idUsuario", idUsuario);
        respuesta.put("totalPuntos", total);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/ranking")
    public ResponseEntity<?> rankingUsuarios() {
        List<Object[]> datos = pS.rankingUsuarios();

        List<Map<String, Object>> respuesta = datos.stream().map(obj -> {
            Map<String, Object> map = new HashMap<>();
            map.put("nombreUsuario", obj[0]);
            map.put("totalPuntos", obj[1]);
            return map;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(respuesta);
    }
}
