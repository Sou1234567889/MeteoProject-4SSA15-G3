package tn.esprit.meteoservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import tn.esprit.meteoservice.entities.HistoriqueMeteo;
import tn.esprit.meteoservice.services.IHistoriqueMeteoService;

import java.util.List;

@RestController
@RequestMapping("/api/historiques")
@RequiredArgsConstructor
public class HistoriqueMeteoController {

    private final IHistoriqueMeteoService service;

    @PostMapping
    public HistoriqueMeteo add(@RequestBody HistoriqueMeteo historique) {
        return service.addHistorique(historique);
    }

    @GetMapping
    public List<HistoriqueMeteo> getAll() {
        return service.getAllHistoriques();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriqueMeteo> getById(@PathVariable String id) {
        return ResponseEntity.ofNullable(
                service.getHistoriqueById(id));
    }

    @GetMapping("/ville/{idVille}")
    public List<HistoriqueMeteo> getByVille(@PathVariable String idVille) {
        return service.getHistoriquesByVille(idVille);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriqueMeteo> update(
            @PathVariable String id,
            @RequestBody HistoriqueMeteo historique) {
        return ResponseEntity.ofNullable(
                service.updateHistorique(id, historique));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteHistorique(id);
    }
}