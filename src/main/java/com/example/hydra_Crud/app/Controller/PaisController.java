package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Pais;
import com.example.hydra_Crud.app.Repository.PaisRepository;

@RestController
@RequestMapping("/api/pais")
@CrossOrigin("*")
public class PaisController {
    @Autowired
    private PaisRepository paisRepository;

    // GET ALL
    @GetMapping
    public List<Pais> obtenerPaises() {
        return paisRepository.findAll();
    }

    // GET POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Pais> obtenerPais(@PathVariable Integer id) {
        // Cambiado .findBy por .findById
        return paisRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pais> guardar(@RequestBody Pais pais) {
        Pais nuevo = paisRepository.save(pais);
        // Tip: Para un POST, lo ideal es devolver un status 201 (Created)
        return ResponseEntity.status(201).body(nuevo);
    }

    // PUT (actualizar)
    @PutMapping("/{id}")
    public ResponseEntity<Pais> actualizarPais(@PathVariable Integer id, @RequestBody Pais pais) {
        return paisRepository.findById(id)
                .map(p -> {
                    pais.setId_Pais(id);
                    Pais actualizado = paisRepository.save(pais); // 'pais' en minúscula
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") // ¡Importante agregar el /{id} aquí!
    public ResponseEntity<Void> eliminarPais(@PathVariable Integer id) { // Void con V mayúscula
        if (!paisRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        paisRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
