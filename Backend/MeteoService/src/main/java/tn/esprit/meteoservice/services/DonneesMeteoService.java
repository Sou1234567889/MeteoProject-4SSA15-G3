package tn.esprit.meteoservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.meteoservice.entities.DonneesMeteo;
import tn.esprit.meteoservice.repositories.IDonneesMeteoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonneesMeteoService implements IDonneesMeteoService {

    private final IDonneesMeteoRepository repository;

    @Override
    public DonneesMeteo addDonneesMeteo(DonneesMeteo donnees) {
        return repository.save(donnees);
    }

    @Override
    public List<DonneesMeteo> getAllDonneesMeteo() {
        return repository.findAll();
    }

    @Override
    public DonneesMeteo getDonneesMeteoById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DonneesMeteo> getDonneesMeteoByVille(String idVille) {
        return repository.findByIdVille(idVille);
    }

    @Override
    public DonneesMeteo updateDonneesMeteo(String id, DonneesMeteo donnees) {
        if (repository.existsById(id)) {
            donnees.setId(id);
            return repository.save(donnees);
        }
        return null;
    }

    @Override
    public void deleteDonneesMeteo(String id) {
        repository.deleteById(id);
    }
}