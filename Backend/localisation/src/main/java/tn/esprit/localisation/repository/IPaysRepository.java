package tn.esprit.localisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.localisation.entity.Continent;
import tn.esprit.localisation.entity.Pays;

import java.util.List;

public interface IPaysRepository extends JpaRepository<Pays, Long> {
    boolean existsByCodeIgnoreCase(String code);
    boolean existsByCodeIgnoreCaseAndIdNot(String code, Long id);
    List<Pays> findByContinent(Continent continent);
}
