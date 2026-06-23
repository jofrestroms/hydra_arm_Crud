package com.example.hydra_Crud.app.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hydra_Crud.app.Entity.Rol;
import com.example.hydra_Crud.app.Repository.RolRepository;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin("*") 
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    // Obtener la lista de todos los roles (admin, medico, etc.)
    @GetMapping
    public List<Rol> obtenerRoles() {
        return rolRepository.findAll();
    }

    // Guardar un rol nuevo por si acaso a futuro
    @PostMapping
    public ResponseEntity<Rol> guardar(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolRepository.save(rol));
    }
}