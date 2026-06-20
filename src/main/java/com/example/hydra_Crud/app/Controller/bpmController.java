package com.example.hydra_Crud.app.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Bpm;
import com.example.hydra_Crud.app.Repository.BpmRepository;

@RestController
@RequestMapping("/api/bpm")
@CrossOrigin("*")
public class bpmController {

    @Autowired
    private BpmRepository bpmRepository;

    @GetMapping
    public List<Bpm> obtenerTodos() {
        return bpmRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bpm> obtenerPorId(@PathVariable Long id) {
        return bpmRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Bpm> buscarPorRunYFecha(
            @RequestParam String runP,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        return bpmRepository.findByRunPAndFechaBetween(runP, inicio, fin);
    }

    @PostMapping
    public ResponseEntity<Bpm> guardar(@RequestBody Bpm bpm) {
        Bpm nuevo = bpmRepository.save(bpm);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bpm> actualizar(@PathVariable Long id, @RequestBody Bpm bpm) {
        return bpmRepository.findById(id)
                .map(p -> {
                    bpm.setIdBpm(id);
                    return ResponseEntity.ok(bpmRepository.save(bpm));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!bpmRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bpmRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
