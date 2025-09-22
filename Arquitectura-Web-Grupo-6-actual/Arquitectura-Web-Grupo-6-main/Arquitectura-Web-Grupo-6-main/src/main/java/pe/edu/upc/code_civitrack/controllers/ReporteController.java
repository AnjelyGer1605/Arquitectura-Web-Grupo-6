package pe.edu.upc.code_civitrack.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.code_civitrack.dtos.ReporteDTO;
import pe.edu.upc.code_civitrack.entities.Reporte;
import pe.edu.upc.code_civitrack.servicesInterfaces.IReporteService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reportes")

public class ReporteController {

    @Autowired
    private IReporteService rS;

    @GetMapping
    public List<ReporteDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ReporteDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ReporteDTO dto){
        ModelMapper m = new ModelMapper();
        Reporte reporte = m.map(dto, Reporte.class);
        rS.insert(reporte);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Reporte reporte = rS.listId(id);
        if (reporte == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un reporte con el ID: " + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("Reporte con ID " + id + " eliminado correctamente.");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Reporte reporte = rS.listId(id);
        if (reporte == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un reporte con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ReporteDTO dto = m.map(reporte, ReporteDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ReporteDTO dto) {
        ModelMapper m = new ModelMapper();
        Reporte re = m.map(dto, Reporte.class);

        Reporte existente = rS.listId(re.getIdReporte());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un reporte con el ID: " + re.getIdReporte());
        }
        rS.update(re);
        return ResponseEntity.ok("Reporte con ID " + re.getIdReporte() + " modificado correctamente.");
    }


    @GetMapping("/busquedafecha")
    public ResponseEntity<?> buscar(@RequestParam LocalDate f) {
        List<Reporte> areas = rS.buscarService(f);

        if (areas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron reportes con la fecha de creación: " + f);
        }

        List<ReporteDTO> listaDTO = areas.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ReporteDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }
}