package tn.esprit.localisation.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VilleRequest(
        @NotBlank(message = "Le nom est obligatoire")
        @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères")
        String nom,

        @NotNull(message = "regionId est obligatoire")
        Long regionId,

        @NotNull(message = "La latitude est obligatoire")
        @DecimalMin(value = "-90.0", message = "Latitude minimale : -90")
        @DecimalMax(value = "90.0", message = "Latitude maximale : 90")
        Double latitude,

        @NotNull(message = "La longitude est obligatoire")
        @DecimalMin(value = "-180.0", message = "Longitude minimale : -180")
        @DecimalMax(value = "180.0", message = "Longitude maximale : 180")
        Double longitude
) {}