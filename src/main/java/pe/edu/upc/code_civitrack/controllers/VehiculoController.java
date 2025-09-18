package pe.edu.upc.code_civitrack.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.code_civitrack.dtos.UniversidadDTO;
import pe.edu.upc.code_civitrack.dtos.VehiculoDTO;

import pe.edu.upc.code_civitrack.entities.Vehiculo;

import pe.edu.upc.code_civitrack.servicesInterfaces.IVehiculoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehiculos")

public class VehiculoController {
    @Autowired
    private IVehiculoService vS;

    @GetMapping
    public List<VehiculoDTO> listar() {
        return vS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VehiculoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody VehiculoDTO dto) {
        ModelMapper m = new ModelMapper();
        Vehiculo r = m.map(dto, Vehiculo.class);
        vS.insert(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Vehiculo veh = vS.listId(id);
        if (veh == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un vehiculo con el ID: " + id);
        }
        vS.delete(id);
        return ResponseEntity.ok("Vehiculo eliminado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Vehiculo veh = vS.listId(id);
        if (veh == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un vehiculo con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        VehiculoDTO dto = m.map(veh, VehiculoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody UniversidadDTO dto) {
        ModelMapper m = new ModelMapper();
        Vehiculo r = m.map(dto, Vehiculo.class);

        Vehiculo existente = vS.listId(r.getIdVehiculo());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un vehiculo con el ID: " + r.getIdVehiculo());
        }
        vS.update(r);
        return ResponseEntity.ok("Vehiculo actualizado correctamente.");
    }

}
