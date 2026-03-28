package examen.examen1.service;

import examen.examen1.model.Usuario;
import examen.examen1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario buscarPorId(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}