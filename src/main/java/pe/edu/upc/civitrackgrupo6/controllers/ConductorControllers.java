package pe.edu.upc.civitrackgrupo6.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.civitrackgrupo6.dtos.ConductorDtos;
import pe.edu.upc.civitrackgrupo6.entities.Conductor;
import pe.edu.upc.civitrackgrupo6.servicesInterfaces.IConductorservice;

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
                    .body("No se puede modificar. No existe un conductor con el ID: " + ar.getIdConductor());
        }
        cS.update(ar);
        return ResponseEntity.ok("Conductor con ID " + ar.getIdConductor() + " modificado correctamente.");
    }
    @GetMapping("/top")
    public ResponseEntity<?> listarTopConductores() {
        List<ConductorDtos> lista = cS.findTopConductores().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConductorDtos.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }
}
