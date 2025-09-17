package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Tipodocumento;
import pe.edu.upc.code_civitrack.repositories.ITipoDocumentoRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.ITipoDocumentoService;

import java.util.List;

@Service
public class TipoDocumentoServiceImplement implements ITipoDocumentoService {
    @Autowired
    private ITipoDocumentoRepository tdR;

    @Override
    public List<Tipodocumento> list() {
        return tdR.findAll();
    }

    @Override
    public void insert(Tipodocumento tipoDocumento) {

    }

    @Override
    public void insert(Tipodocumento tipoDocumento) {
        tdR.save(tipoDocumento);
    }

    @Override
    public void delete(int id) {
        tdR.deleteById(id);
    }

    @Override
    public Tipodocumento listId(int id) {
        return tdR.findById(id).orElse(null);
    }

    @Override
    public void update(Tipodocumento tipoDocumento) {

    }

    @Override
    public void update(Tipodocumento tipoDocumento) {
        tdR.save(tipoDocumento);
    }
}
