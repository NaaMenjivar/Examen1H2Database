package examen.examen1.service;

import examen.examen1.model.Medicamento;
import examen.examen1.model.Usuario;
import examen.examen1.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public List<Medicamento> listarTodos() {
        return medicamentoRepository.findAll();
    }

    public Medicamento buscarPorId(String id) {
        return medicamentoRepository.findById(id).orElse(null);
    }
}
