package tn.esprit.meteoservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.meteoservice.entities.Prevision;
import java.util.List;

public interface IPrevisionRepository
        extends MongoRepository<Prevision, String> {

    List<Prevision> findByIdVille(String idVille);
}