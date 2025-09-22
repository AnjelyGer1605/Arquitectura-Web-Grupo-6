package pe.edu.upc.code_civitrack.servicesInterfaces;

import pe.edu.upc.code_civitrack.entities.Tipodocumento;

import java.util.List;

public interface ITipoDocumentoService {
    List<Tipodocumento> list();
    void insert(Tipodocumento tipoDocumento);
    void delete(int id);
    Tipodocumento listId(int id);
    void update(Tipodocumento tipoDocumento);
}
