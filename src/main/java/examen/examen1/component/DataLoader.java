package examen.examen1.component;

import examen.examen1.model.Usuario;
import examen.examen1.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() == 0) {
            Usuario u1 = new Usuario();
            u1.setId("JPerez");
            u1.setClave(passwordEncoder.encode("111"));
            u1.setRol("CLI");
            usuarioRepository.save(u1);

            Usuario u2 = new Usuario();
            u2.setId("MMata");
            u2.setClave(passwordEncoder.encode("222"));
            u2.setRol("CLI");
            usuarioRepository.save(u2);

            System.out.println("Usuarios de prueba creados.");
        }
    }
}
