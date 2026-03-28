package examen.examen1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medicamento")
@Getter @Setter @NoArgsConstructor
public class Medicamento {

    @Id
    @Column(name = "id", length = 20)
    private String id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    // Plan: cuántas dosis debe acumular el paciente para recibir 1 regalía
    @Column(name = "plan")
    private Integer plan;
}
