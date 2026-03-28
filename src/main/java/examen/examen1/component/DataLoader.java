package examen.examen1.component;

import examen.examen1.model.*;
import examen.examen1.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final FarmaciaRepository farmaciaRepository;
    private final MedicamentoRepository medicamentoRepository;
    private final PacienteRepository pacienteRepository;
    private final PacienteMedicamentoRepository pacienteMedicamentoRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UsuarioRepository usuarioRepository,
                      FarmaciaRepository farmaciaRepository,
                      MedicamentoRepository medicamentoRepository,
                      PacienteRepository pacienteRepository,
                      PacienteMedicamentoRepository pacienteMedicamentoRepository,
                      PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.farmaciaRepository = farmaciaRepository;
        this.medicamentoRepository = medicamentoRepository;
        this.pacienteRepository = pacienteRepository;
        this.pacienteMedicamentoRepository = pacienteMedicamentoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() == 0) {
            Usuario u1 = new Usuario();
            u1.setId("Farma10");
            u1.setClave(passwordEncoder.encode("111"));
            u1.setRol("FARM");
            usuarioRepository.save(u1);

            Usuario u2 = new Usuario();
            u2.setId("Bomba07");
            u2.setClave(passwordEncoder.encode("222"));
            u2.setRol("FARM");
            usuarioRepository.save(u2);

            Farmacia f1 = new Farmacia();
            f1.setId("Farma10");
            f1.setNombre("Farmacia La Económica");
            f1.setUsuario(u1);
            farmaciaRepository.save(f1);

            Farmacia f2 = new Farmacia();
            f2.setId("Bomba07");
            f2.setNombre("La Bomba San Pedro");
            f2.setUsuario(u2);
            farmaciaRepository.save(f2);

            Medicamento m1 = new Medicamento();
            m1.setId("TAL5");
            m1.setNombre("Taladaf 5mg");
            m1.setPlan(1);
            medicamentoRepository.save(m1);

            Medicamento m2 = new Medicamento();
            m2.setId("EZE10");
            m2.setNombre("Ezetemin 10mg");
            m2.setPlan(3);
            medicamentoRepository.save(m2);

            Medicamento m3 = new Medicamento();
            m3.setId("CAR25");
            m3.setNombre("Cardizem 25mg");
            m3.setPlan(2);
            medicamentoRepository.save(m3);


            Paciente p1 = new Paciente();
            p1.setId("111");
            p1.setNombre("Juan Perez");
            pacienteRepository.save(p1);

            Paciente p2 = new Paciente();
            p2.setId("222");
            p2.setNombre("Maria Gomez");
            pacienteRepository.save(p2);

            PacienteMedicamento pm1 = new PacienteMedicamento();
            pm1.setPaciente(p1);
            pm1.setMedicamento(m1);
            pm1.setDosisafavor(0);
            pacienteMedicamentoRepository.save(pm1);

            PacienteMedicamento pm2 = new PacienteMedicamento();
            pm2.setPaciente(p1);
            pm2.setMedicamento(m2);
            pm2.setDosisafavor(2);
            pacienteMedicamentoRepository.save(pm2);

            PacienteMedicamento pm3 = new PacienteMedicamento();
            pm3.setPaciente(p2);
            pm3.setMedicamento(m2);
            pm3.setDosisafavor(1);
            pacienteMedicamentoRepository.save(pm3);

            System.out.println("datos de prueba insertados");
        }
    }
}