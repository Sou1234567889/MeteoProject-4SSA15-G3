package tn.esprit.meteoservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import tn.esprit.meteoservice.entities.Prevision;
import tn.esprit.meteoservice.services.IPrevisionService;

import java.util.List;

@RestController
@RequestMapping("/api/previsions")
@RequiredArgsConstructor
public class PrevisionController {

    private final IPrevisionService service;

    @PostMapping
    public Prevision add(@RequestBody Prevision prevision) {
        return service.addPrevision(prevision);
    }

    @GetMapping
    public List<Prevision> getAll() {
        return service.getAllPrevisions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prevision> getById(@PathVariable String id) {
        return ResponseEntity.ofNullable(
                service.getPrevisionById(id));
    }

    @GetMapping("/ville/{idVille}")
    public List<Prevision> getByVille(@PathVariable String idVille) {
        return service.getPrevisionsByVille(idVille);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prevision> update(
            @PathVariable String id,
            @RequestBody Prevision prevision) {
        return ResponseEntity.ofNullable(
                service.updatePrevision(id, prevision));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deletePrevision(id);
    }
}