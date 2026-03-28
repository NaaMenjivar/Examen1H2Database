package examen.examen1.repository;

import examen.examen1.model.Paciente;
import examen.examen1.model.PacienteMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PacienteMedicamentoRepository extends JpaRepository<PacienteMedicamento, Integer> {
    List<PacienteMedicamento> findByPaciente(Paciente paciente);
}
