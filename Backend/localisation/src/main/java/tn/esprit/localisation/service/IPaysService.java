package tn.esprit.localisation.service;

import tn.esprit.localisation.dto.PaysRequest;
import tn.esprit.localisation.dto.PaysResponse;
import tn.esprit.localisation.entity.Continent;

import java.util.List;

public interface IPaysService {
    List<PaysResponse> findAll(Continent continent);
    PaysResponse findById(Long id);
    PaysResponse create(PaysRequest request);
    PaysResponse update(Long id, PaysRequest request);
    void delete(Long id);
}