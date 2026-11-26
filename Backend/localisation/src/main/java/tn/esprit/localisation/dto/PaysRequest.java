package tn.esprit.localisation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import tn.esprit.localisation.entity.Continent;

public record PaysRequest(
        @NotBlank(message = "Le nom est obligatoire")
        @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères")
        String nom,

        @NotBlank(message = "Le code est obligatoire")
        @Pattern(regexp = "^[A-Za-z]{2,3}$", message = "Le code doit contenir 2 ou 3 lettres (ex: TN, TUN)")
        String code,

        @NotNull(message = "Le continent est obligatoire")
        Continent continent
) {}