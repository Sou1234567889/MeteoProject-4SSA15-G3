package tn.esprit.localisation.dto;

public record VilleResponse(Long id, String nom, Long regionId, String regionNom,
                            double latitude, double longitude) {}