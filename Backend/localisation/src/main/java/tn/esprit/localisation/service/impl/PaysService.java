package tn.esprit.localisation.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.localisation.dto.PaysRequest;
import tn.esprit.localisation.dto.PaysResponse;
import tn.esprit.localisation.entity.Continent;
import tn.esprit.localisation.entity.Pays;
import tn.esprit.localisation.exception.ConflictException;
import tn.esprit.localisation.exception.ResourceNotFoundException;
import tn.esprit.localisation.repository.IPaysRepository;
import tn.esprit.localisation.repository.IRegionRepository;
import tn.esprit.localisation.service.IPaysService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaysService implements IPaysService {

    private final IPaysRepository paysRepository;
    private final IRegionRepository regionRepository;

    @Override
    public List<PaysResponse> findAll(Continent continent) {
        List<Pays> list = (continent == null)
                ? paysRepository.findAll()
                : paysRepository.findByContinent(continent);
        return list.stream().map(this::toResponse).toList();
    }

    @Override
    public PaysResponse findById(Long id) {
        return toResponse(getOrThrow(id));
    }

    @Override
    @Transactional
    public PaysResponse create(PaysRequest request) {
        if (paysRepository.existsByCodeIgnoreCase(request.code())) {
            throw new ConflictException("Un pays avec le code '" + request.code() + "' existe déjà");
        }
        Pays pays = Pays.builder()
                .nom(request.nom().trim())
                .code(request.code().toUpperCase())
                .continent(request.continent())
                .build();
        return toResponse(paysRepository.save(pays));
    }

    @Override
    @Transactional
    public PaysResponse update(Long id, PaysRequest request) {
        Pays pays = getOrThrow(id);
        if (paysRepository.existsByCodeIgnoreCaseAndIdNot(request.code(), id)) {
            throw new ConflictException("Un pays avec le code '" + request.code() + "' existe déjà");
        }
        pays.setNom(request.nom().trim());
        pays.setCode(request.code().toUpperCase());
        pays.setContinent(request.continent());
        return toResponse(paysRepository.save(pays));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Pays pays = getOrThrow(id);
        if (regionRepository.existsByPaysId(id)) {
            throw new ConflictException("Impossible de supprimer le pays : des régions y sont rattachées");
        }
        paysRepository.delete(pays);
    }

    private Pays getOrThrow(Long id) {
        return paysRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pays", id));
    }

    private PaysResponse toResponse(Pays p) {
        return new PaysResponse(p.getId(), p.getNom(), p.getCode(), p.getContinent());
    }
}