package examen.examen1.service;

import examen.examen1.model.Paciente;
import examen.examen1.model.PacienteMedicamento;
import examen.examen1.repository.PacienteMedicamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteMedicamentoService {

    private PacienteMedicamentoRepository repo;

    public PacienteMedicamentoService(PacienteMedicamentoRepository repo) {
        this.repo = repo;
    }

    public List<PacienteMedicamento> buscarPorPaciente(Paciente paciente) {
        return repo.findByPaciente(paciente);
    }

    public PacienteMedicamento buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public PacienteMedicamento guardar(PacienteMedicamento pm) {
        return repo.save(pm);
    }
}
