package examen.examen1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pacientemedicamento")
@Getter @Setter @NoArgsConstructor
public class PacienteMedicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medicamento", nullable = false)
    private Medicamento medicamento;

    @Column(name = "dosisafavor")
    private Integer dosisafavor;
}
