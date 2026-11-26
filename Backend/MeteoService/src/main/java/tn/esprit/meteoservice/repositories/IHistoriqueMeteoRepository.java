package tn.esprit.meteoservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.meteoservice.entities.HistoriqueMeteo;
import java.util.List;

public interface IHistoriqueMeteoRepository
        extends MongoRepository<HistoriqueMeteo, String> {

    List<HistoriqueMeteo> findByIdVille(String idVille);
}