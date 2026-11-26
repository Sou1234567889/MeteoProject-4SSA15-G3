package tn.esprit.localisation.service;

import tn.esprit.localisation.dto.RegionRequest;
import tn.esprit.localisation.dto.RegionResponse;

import java.util.List;

public interface IRegionService {
    List<RegionResponse> findAll(Long paysId);
    RegionResponse findById(Long id);
    RegionResponse create(RegionRequest request);
    RegionResponse update(Long id, RegionRequest request);
    void delete(Long id);
}