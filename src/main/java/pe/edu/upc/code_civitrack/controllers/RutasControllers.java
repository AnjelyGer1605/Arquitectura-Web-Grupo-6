package pe.edu.upc.demotrabajocivitrak.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demotrabajocivitrak.Dtos.RutasDtos;
import pe.edu.upc.demotrabajocivitrak.Dtos.UsuarioDtos;
import pe.edu.upc.demotrabajocivitrak.Entities.Rutas;
import pe.edu.upc.demotrabajocivitrak.Entities.Usuario;
import pe.edu.upc.demotrabajocivitrak.Servicesinterfaces.IRutasservice;
import pe.edu.upc.demotrabajocivitrak.Servicesinterfaces.IUsuarioservice;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Rutas")
public class RutasControllers {
    @Autowired
    private IRutasservice rS;

    @GetMapping
    public List<RutasDtos> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RutasDtos.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody RutasDtos dto){
        ModelMapper m = new ModelMapper();
        Rutas a = m.map(dto, Rutas.class);
        rS.insert(a);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Rutas rutas = rS.listId(id);
        if (rutas == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Rutas rutas= rS.listId(id);
        if (rutas == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RutasDtos dto = m.map(rutas, RutasDtos.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RutasDtos dto) {
        ModelMapper m = new ModelMapper();
        Rutas ar = m.map(dto, Rutas.class);

        Rutas existente = rS.listId(ar.getIdruta());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + ar.getIdruta());
        }
        rS.update(ar);
        return ResponseEntity.ok("Registro con ID " + ar.getIdruta() + " modificado correctamente.");
    }


}
