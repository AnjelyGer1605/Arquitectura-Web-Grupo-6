package pe.edu.upc.code_civitrack.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.code_civitrack.entities.HistorialRuta;
import pe.edu.upc.code_civitrack.repositories.IHistorialRutaRepository;
import pe.edu.upc.code_civitrack.servicesInterfaces.IHistorialRutaService;

import java.time.LocalDate;
import java.util.List;

@Service
public class HistorialRutaServiceImplement implements IHistorialRutaService {
    @Autowired
    private IHistorialRutaRepository hrR;

    @Override
    public List<HistorialRuta> list() {
        return hrR.findAll();
    }

    @Override
    public void insert(HistorialRuta historialRuta) {
        hrR.save(historialRuta);
    }

    @Override
    public void delete(int id) {
        hrR.deleteById(id);
    }

    @Override
    public HistorialRuta listId(int id) {
        return hrR.findById(id).orElse(null);
    }

    @Override
    public void update(HistorialRuta historialRuta) {
        hrR.save(historialRuta);
    }

    @Override
    public List<HistorialRuta> buscarService(LocalDate fecha) {
        return hrR.buscarPorFecha(fecha);
    }
}