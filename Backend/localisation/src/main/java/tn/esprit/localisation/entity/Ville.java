package tn.esprit.localisation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ville")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_region", nullable = false)
    private Region region;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;
}