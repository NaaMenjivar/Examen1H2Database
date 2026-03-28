package examen.examen1.service;

import examen.examen1.model.Paciente;
import examen.examen1.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente buscarPorId(String id) {
        return pacienteRepository.findById(id).orElse(null);
    }
}
