package tn.esprit.localisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.localisation.entity.Region;

import java.util.List;

public interface IRegionRepository extends JpaRepository<Region, Long> {
    List<Region> findByPaysId(Long paysId);
    boolean existsByPaysId(Long paysId);
    boolean existsByNomIgnoreCaseAndPaysId(String nom, Long paysId);
    boolean existsByNomIgnoreCaseAndPaysIdAndIdNot(String nom, Long paysId, Long id);
}
