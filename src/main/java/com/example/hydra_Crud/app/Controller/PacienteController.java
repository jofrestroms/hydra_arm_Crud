package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Paciente;
import com.example.hydra_Crud.app.Repository.PacienteRepository;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin("*") // puedes quitarlo si usas SecurityConfig con CORS
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    // ✅ GET ALL
    @GetMapping
    public List<Paciente> obtenerPacientes() {
        return pacienteRepository.findAll();
    }

    // ✅ GET BY ID
    @GetMapping("/{run}")
    public ResponseEntity<Paciente> obtenerPaciente(@PathVariable String run) {
        return pacienteRepository.findById(run)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ POST (CREAR)
    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        Paciente nuevo = pacienteRepository.save(paciente);
        return ResponseEntity.ok(nuevo);
    }

    // ✅ PUT (ACTUALIZAR)
    @PutMapping("/{run}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable String run, @RequestBody Paciente paciente) {

        return pacienteRepository.findById(run)
                .map(p -> {
                    paciente.setRunP(run);
                    return ResponseEntity.ok(pacienteRepository.save(paciente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ DELETE
    @DeleteMapping("/{run}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable String run) {

        if (!pacienteRepository.existsById(run)) {
            return ResponseEntity.notFound().build();
        }

        pacienteRepository.deleteById(run);
        return ResponseEntity.noContent().build();
    }
}