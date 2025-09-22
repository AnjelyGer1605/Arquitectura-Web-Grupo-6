package pe.edu.upc.code_civitrack.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.code_civitrack.dtos.TipodocumentoDTO;
import pe.edu.upc.code_civitrack.entities.Tipodocumento;
import pe.edu.upc.code_civitrack.servicesInterfaces.ITipoDocumentoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipodocumentos")
public class TipodocumentoController {
    @Autowired
    private ITipoDocumentoService tdS;

    @GetMapping
    public List<TipodocumentoDTO> listar() {
        return tdS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TipodocumentoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody TipodocumentoDTO dto) {
        ModelMapper m = new ModelMapper();
        Tipodocumento td = m.map(dto, Tipodocumento.class);
        tdS.insert(td);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Tipodocumento tipoDocumento = tdS.listId(id);
        if (tipoDocumento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe tipo de documento con el ID: " + id);
        }
        tdS.delete(id);
        return ResponseEntity.ok("Tipo de documento eliminado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Tipodocumento tipoDocumento = tdS.listId(id);
        if (tipoDocumento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe tipo de documento con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        TipodocumentoDTO dto = m.map(tipoDocumento, TipodocumentoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody TipodocumentoDTO dto) {
        ModelMapper m = new ModelMapper();
        Tipodocumento td = m.map(dto, Tipodocumento.class);

        Tipodocumento existente = tdS.listId(td.getDocumentoId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe tipo de documento con el ID: " + td.getDocumentoId());
        }
        tdS.update(td);
        return ResponseEntity.ok("Tipo de documento modificado correctamente.");
    }
}
