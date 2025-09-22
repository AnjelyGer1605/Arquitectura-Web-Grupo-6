package pe.edu.upc.demotrabajocivitrak.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demotrabajocivitrak.Dtos.UsuarioDtos;
import pe.edu.upc.demotrabajocivitrak.Entities.Usuario;
import pe.edu.upc.demotrabajocivitrak.Servicesinterfaces.IUsuarioservice;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllers {

    @Autowired
    private IUsuarioservice uS;

    @GetMapping
    public List<UsuarioDtos> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDtos.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsuarioDtos dto){
        ModelMapper m = new ModelMapper();
        Usuario a = m.map(dto, Usuario.class);
        uS.insert(a);
    }

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

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Usuario usuario= uS.listId(id);
        if (usuario == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDtos dto = m.map(usuario, UsuarioDtos.class);
        return ResponseEntity.ok(dto);
    }

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


}
