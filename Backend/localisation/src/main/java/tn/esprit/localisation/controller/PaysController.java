package tn.esprit.localisation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.localisation.dto.PaysRequest;
import tn.esprit.localisation.dto.PaysResponse;
import tn.esprit.localisation.entity.Continent;
import tn.esprit.localisation.service.IPaysService;

import java.util.List;

@RestController
@RequestMapping("/api/pays")
@RequiredArgsConstructor
@Tag(name = "Pays", description = "Gestion des pays")
public class PaysController {

    private final IPaysService paysService;

    @GetMapping
    @Operation(summary = "Lister les pays (filtre optionnel par continent)")
    public List<PaysResponse> getAll(@RequestParam(required = false) Continent continent) {
        return paysService.findAll(continent);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un pays par son id")
    public PaysResponse getById(@PathVariable Long id) {
        return paysService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Créer un pays")
    public ResponseEntity<PaysResponse> create(@Valid @RequestBody PaysRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paysService.create(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un pays")
    public PaysResponse update(@PathVariable Long id, @Valid @RequestBody PaysRequest request) {
        return paysService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer un pays")
    public void delete(@PathVariable Long id) {
        paysService.delete(id);
    }
}