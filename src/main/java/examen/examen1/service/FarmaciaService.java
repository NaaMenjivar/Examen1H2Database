package examen.examen1.service;

import examen.examen1.model.Farmacia;
import examen.examen1.model.Usuario;
import examen.examen1.repository.FarmaciaRepository;
import org.springframework.stereotype.Service;

@Service
public class FarmaciaService {

    private final FarmaciaRepository farmaciaRepository;

    public FarmaciaService(FarmaciaRepository farmaciaRepository) {
        this.farmaciaRepository = farmaciaRepository;
    }

    public Farmacia buscarPorUsuario(Usuario usuario) {
        return farmaciaRepository.findByUsuario(usuario).orElse(null);
    }
}
