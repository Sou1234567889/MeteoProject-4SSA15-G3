package tn.esprit.localisation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pays")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false, unique = true, length = 3)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Continent continent;
}