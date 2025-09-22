package pe.edu.upc.demotrabajocivitrak.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demotrabajocivitrak.Dtos.ConductorDtos;
import pe.edu.upc.demotrabajocivitrak.Dtos.RutasDtos;
import pe.edu.upc.demotrabajocivitrak.Entities.Conductor;
import pe.edu.upc.demotrabajocivitrak.Entities.Rutas;
import pe.edu.upc.demotrabajocivitrak.Servicesinterfaces.IConductorservice;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Conductores")
public class ConductorControllers {
    @Autowired
    private IConductorservice cS;

    @GetMapping
    public List<ConductorDtos> listar(){
        return cS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ConductorDtos.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ConductorDtos dto){
        ModelMapper m = new ModelMapper();
        Conductor a = m.map(dto, Conductor.class);
        cS.insert(a);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Long id) {
        Conductor conductor = cS.listId(id);
        if (conductor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        cS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Long id) {
        Conductor conductor= cS.listId(id);
        if (conductor == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ConductorDtos dto = m.map(conductor, ConductorDtos.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ConductorDtos dto) {
        ModelMapper m = new ModelMapper();
        Conductor ar = m.map(dto, Conductor.class);

        Conductor existente = cS.listId(Long.valueOf(5));
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + ar.getId());
        }
        cS.update(ar);
        return ResponseEntity.ok("Registro con ID " + ar.getId() + " modificado correctamente.");
    }

}
