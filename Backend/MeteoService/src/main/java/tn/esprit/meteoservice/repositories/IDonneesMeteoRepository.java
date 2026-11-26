package tn.esprit.meteoservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.meteoservice.entities.DonneesMeteo;
import java.util.List;

public interface IDonneesMeteoRepository
        extends MongoRepository<DonneesMeteo, String> {

    List<DonneesMeteo> findByIdVille(String idVille);
}