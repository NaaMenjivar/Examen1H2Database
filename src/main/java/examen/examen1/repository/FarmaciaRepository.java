package examen.examen1.repository;

import examen.examen1.model.Farmacia;
import examen.examen1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FarmaciaRepository extends JpaRepository<Farmacia, String> {
    Optional<Farmacia> findByUsuario(Usuario usuario);
}
