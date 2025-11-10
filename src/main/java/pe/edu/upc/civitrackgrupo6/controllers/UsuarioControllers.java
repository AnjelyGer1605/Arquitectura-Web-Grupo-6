package pe.edu.upc.civitrackgrupo6.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.civitrackgrupo6.dtos.UsuarioDtos;
import pe.edu.upc.civitrackgrupo6.entities.Usuario;
import pe.edu.upc.civitrackgrupo6.servicesInterfaces.IUsuarioservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/usuarios")
public class UsuarioControllers {

    @Autowired
    private IUsuarioservice uS;

    // Solo ADMIN puede listar
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UsuarioDtos> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDtos.class);
        }).collect(Collectors.toList());
    }

    // Cualquiera puede registrar (normalmente lo usa el registro público)
    @PostMapping
    public void insertar(@RequestBody UsuarioDtos dto) {
        ModelMapper m = new ModelMapper();
        Usuario a = m.map(dto, Usuario.class);
        uS.insert(a);
    }

    // Solo ADMIN puede eliminar
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Usuario usuario = uS.listId(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        uS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    // Solo ADMIN puede consultar por ID
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Usuario usuario = uS.listId(id);
        if (usuario == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDtos dto = m.map(usuario, UsuarioDtos.class);
        return ResponseEntity.ok(dto);
    }

    // ADMIN o USER pueden modificar su información
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody UsuarioDtos dto) {
        ModelMapper m = new ModelMapper();
        Usuario ar = m.map(dto, Usuario.class);

        Usuario existente = uS.listId(ar.getIdUsuario());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + ar.getIdUsuario());
        }
        uS.update(ar);
        return ResponseEntity.ok("Registro con ID " + ar.getIdUsuario() + " modificado correctamente.");
    }

    // Búsqueda por correo (sin restricción, útil para login o validación)
    @GetMapping("/correo")
    public ResponseEntity<?> buscarPorCorreo(@RequestParam("correo") String correo) {
        Usuario usuario = uS.findByCorreo(correo);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con el correo: " + correo);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDtos dto = m.map(usuario, UsuarioDtos.class);
        return ResponseEntity.ok(dto);
    }

    // Validación de correo (para registro)
    @GetMapping("/validar-correo")
    public ResponseEntity<?> validarCorreo(@RequestParam("correo") String correo) {
        boolean existe = uS.existsByCorreo(correo);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("correo", correo);
        respuesta.put("duplicado", existe);
        return ResponseEntity.ok(respuesta);
    }
}