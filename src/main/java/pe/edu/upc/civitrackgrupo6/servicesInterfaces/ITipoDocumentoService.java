package pe.edu.upc.civitrackgrupo6.servicesInterfaces;

import pe.edu.upc.civitrackgrupo6.entities.Tipodocumento;

import java.util.List;

public interface ITipoDocumentoService {
    List<Tipodocumento> list();
    void insert(Tipodocumento tipoDocumento);
    void delete(int id);
    Tipodocumento listId(int id);
    void update(Tipodocumento tipoDocumento);
    List<Tipodocumento> findTiposDocumentoActivos(); //
}
