package pe.edu.upc.civitrackgrupo6.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.civitrackgrupo6.dtos.NotificacionDTO;
import pe.edu.upc.civitrackgrupo6.entities.Notificacion;
import pe.edu.upc.civitrackgrupo6.servicesInterfaces.INotificacionService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService nS;

    @PostMapping
    public void insertar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto, Notificacion.class);
        nS.insert(n);
    }

    @GetMapping
    public List<NotificacionDTO> listar() {
        return nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionDTO> listarPorId(@PathVariable("id") Integer id) {
        Notificacion n = nS.listId(id);
        if (n == null) return ResponseEntity.notFound().build();
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(n, NotificacionDTO.class));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        nS.delete(id);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto, Notificacion.class);
        Notificacion existente = nS.listId(n.getIdNotificacion());
        if (existente == null) {
            return ResponseEntity.badRequest().body("No existe la notificación con el ID: " + n.getIdNotificacion());
        }
        nS.update(n);
        return ResponseEntity.ok("Notificación modificada correctamente.");
    }


    @GetMapping("/usuario/{idUsuario}")
    public List<NotificacionDTO> listarPorUsuario(@PathVariable("idUsuario") int idUsuario) {
        return nS.findByUsuarioId(idUsuario).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/fecha/{fecha}")
    public List<NotificacionDTO> listarPorFecha(@PathVariable("fecha") String fecha) {
        LocalDateTime fechaConsulta = LocalDateTime.parse(fecha);
        return nS.findByFechaEnvio(fechaConsulta).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }
}


