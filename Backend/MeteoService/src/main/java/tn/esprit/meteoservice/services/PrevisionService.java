package tn.esprit.meteoservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.meteoservice.entities.Prevision;
import tn.esprit.meteoservice.repositories.IPrevisionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrevisionService implements IPrevisionService {

    private final IPrevisionRepository repository;

    @Override
    public Prevision addPrevision(Prevision prevision) {
        return repository.save(prevision);
    }

    @Override
    public List<Prevision> getAllPrevisions() {
        return repository.findAll();
    }

    @Override
    public Prevision getPrevisionById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Prevision> getPrevisionsByVille(String idVille) {
        return repository.findByIdVille(idVille);
    }

    @Override
    public Prevision updatePrevision(String id, Prevision prevision) {
        if (repository.existsById(id)) {
            prevision.setId(id);
            return repository.save(prevision);
        }
        return null;
    }

    @Override
    public void deletePrevision(String id) {
        repository.deleteById(id);
    }
}