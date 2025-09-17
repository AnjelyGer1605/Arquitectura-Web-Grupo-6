package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.Reporte;
import pe.edu.upc.code_civitrack.repositories.IReporteRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.IReporteService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReporteServiceImplement implements IReporteService {

    @Autowired
    private IReporteRepository sR;

    @Override
    public void insert(Reporte reporte) {
        sR.save(reporte);
    }

    @Override
    public Reporte listId(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Reporte re) {

    }

    @Override
    public List<Reporte> buscarService(LocalDate f) {
        return List.of();
    }

    @Override
    public List<Reporte> list() {
        return sR.findAll();
    }

}
