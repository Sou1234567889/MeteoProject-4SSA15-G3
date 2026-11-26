package tn.esprit.localisation.dto;

import tn.esprit.localisation.entity.Continent;

public record PaysResponse(Long id, String nom, String code, Continent continent) {}