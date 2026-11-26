package tn.esprit.localisation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.localisation.dto.RegionRequest;
import tn.esprit.localisation.dto.RegionResponse;
import tn.esprit.localisation.service.IRegionService;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
@RequiredArgsConstructor
@Tag(name = "Régions", description = "Gestion des régions")
public class RegionController {

    private final IRegionService regionService;

    @GetMapping
    @Operation(summary = "Lister les régions (filtre optionnel par pays)")
    public List<RegionResponse> getAll(@RequestParam(required = false) Long paysId) {
        return regionService.findAll(paysId);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une région par son id")
    public RegionResponse getById(@PathVariable Long id) {
        return regionService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Créer une région")
    public ResponseEntity<RegionResponse> create(@Valid @RequestBody RegionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(regionService.create(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une région")
    public RegionResponse update(@PathVariable Long id, @Valid @RequestBody RegionRequest request) {
        return regionService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer une région")
    public void delete(@PathVariable Long id) {
        regionService.delete(id);
    }
}