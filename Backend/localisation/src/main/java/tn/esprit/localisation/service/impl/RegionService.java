package tn.esprit.localisation.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.localisation.dto.RegionRequest;
import tn.esprit.localisation.dto.RegionResponse;
import tn.esprit.localisation.entity.Pays;
import tn.esprit.localisation.entity.Region;
import tn.esprit.localisation.exception.ConflictException;
import tn.esprit.localisation.exception.ResourceNotFoundException;
import tn.esprit.localisation.repository.*;
import tn.esprit.localisation.service.IRegionService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionService implements IRegionService {

    private final IRegionRepository regionRepository;
    private final IPaysRepository paysRepository;
    private final IVilleRepository villeRepository;

    @Override
    public List<RegionResponse> findAll(Long paysId) {
        List<Region> list = (paysId == null)
                ? regionRepository.findAll()
                : regionRepository.findByPaysId(paysId);
        return list.stream().map(this::toResponse).toList();
    }

    @Override
    public RegionResponse findById(Long id) {
        return toResponse(getOrThrow(id));
    }

    @Override
    @Transactional
    public RegionResponse create(RegionRequest request) {
        Pays pays = paysRepository.findById(request.paysId())
                .orElseThrow(() -> new ResourceNotFoundException("Pays", request.paysId()));
        if (regionRepository.existsByNomIgnoreCaseAndPaysId(request.nom(), pays.getId())) {
            throw new ConflictException("Cette région existe déjà dans le pays " + pays.getNom());
        }
        Region region = Region.builder().nom(request.nom().trim()).pays(pays).build();
        return toResponse(regionRepository.save(region));
    }

    @Override
    @Transactional
    public RegionResponse update(Long id, RegionRequest request) {
        Region region = getOrThrow(id);
        Pays pays = paysRepository.findById(request.paysId())
                .orElseThrow(() -> new ResourceNotFoundException("Pays", request.paysId()));
        if (regionRepository.existsByNomIgnoreCaseAndPaysIdAndIdNot(request.nom(), pays.getId(), id)) {
            throw new ConflictException("Cette région existe déjà dans le pays " + pays.getNom());
        }
        region.setNom(request.nom().trim());
        region.setPays(pays);
        return toResponse(regionRepository.save(region));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Region region = getOrThrow(id);
        if (villeRepository.existsByRegionId(id)) {
            throw new ConflictException("Impossible de supprimer la région : des villes y sont rattachées");
        }
        regionRepository.delete(region);
    }

    private Region getOrThrow(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region", id));
    }

    private RegionResponse toResponse(Region r) {
        return new RegionResponse(r.getId(), r.getNom(), r.getPays().getId(), r.getPays().getNom());
    }
}