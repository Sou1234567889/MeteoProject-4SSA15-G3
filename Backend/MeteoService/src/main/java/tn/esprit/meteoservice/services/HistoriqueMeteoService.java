package tn.esprit.meteoservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.meteoservice.entities.HistoriqueMeteo;
import tn.esprit.meteoservice.repositories.IHistoriqueMeteoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoriqueMeteoService implements IHistoriqueMeteoService {

    private final IHistoriqueMeteoRepository repository;

    @Override
    public HistoriqueMeteo addHistorique(HistoriqueMeteo historique) {
        return repository.save(historique);
    }

    @Override
    public List<HistoriqueMeteo> getAllHistoriques() {
        return repository.findAll();
    }

    @Override
    public HistoriqueMeteo getHistoriqueById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<HistoriqueMeteo> getHistoriquesByVille(String idVille) {
        return repository.findByIdVille(idVille);
    }

    @Override
    public HistoriqueMeteo updateHistorique(String id, HistoriqueMeteo historique) {
        if (repository.existsById(id)) {
            historique.setId(id);
            return repository.save(historique);
        }
        return null;
    }

    @Override
    public void deleteHistorique(String id) {
        repository.deleteById(id);
    }
}