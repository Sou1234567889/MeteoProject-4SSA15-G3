package tn.esprit.meteoservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import tn.esprit.meteoservice.entities.DonneesMeteo;
import tn.esprit.meteoservice.services.IDonneesMeteoService;

import java.util.List;

@RestController
@RequestMapping("/api/meteo")
@RequiredArgsConstructor
public class DonneesMeteoController {

    private final IDonneesMeteoService service;

    @PostMapping
    public DonneesMeteo add(@RequestBody DonneesMeteo donnees) {
        return service.addDonneesMeteo(donnees);
    }

    @GetMapping
    public List<DonneesMeteo> getAll() {
        return service.getAllDonneesMeteo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonneesMeteo> getById(@PathVariable String id) {
        return ResponseEntity.ofNullable(
                service.getDonneesMeteoById(id));
    }

    @GetMapping("/ville/{idVille}")
    public List<DonneesMeteo> getByVille(@PathVariable String idVille) {
        return service.getDonneesMeteoByVille(idVille);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonneesMeteo> update(
            @PathVariable String id,
            @RequestBody DonneesMeteo donnees) {
        return ResponseEntity.ofNullable(
                service.updateDonneesMeteo(id, donnees));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteDonneesMeteo(id);
    }
}