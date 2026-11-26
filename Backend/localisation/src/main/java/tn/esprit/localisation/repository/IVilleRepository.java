package tn.esprit.localisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.localisation.entity.Ville;

import java.util.List;

public interface IVilleRepository extends JpaRepository<Ville, Long> {
    List<Ville> findByRegionId(Long regionId);
    List<Ville> findByNomContainingIgnoreCase(String nom);
    boolean existsByRegionId(Long regionId);
    boolean existsByNomIgnoreCaseAndRegionId(String nom, Long regionId);
    boolean existsByNomIgnoreCaseAndRegionIdAndIdNot(String nom, Long regionId, Long id);
}