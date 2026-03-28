package examen.examen1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter @Setter @NoArgsConstructor
public class Usuario {

    @Id
    @Column(name = "id", length = 10)
    private String id;

    @Column(name = "clave", nullable = false, length = 100)
    private String clave;

    @Column(name = "rol", nullable = false, length = 10)
    private String rol;
}
