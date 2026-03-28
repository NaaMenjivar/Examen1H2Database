package examen.examen1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "farmacia")
@Getter @Setter @NoArgsConstructor
public class Farmacia {

    @Id
    @Column(name = "id", length = 20)
    private String id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario usuario;
}
