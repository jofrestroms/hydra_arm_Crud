package com.example.hydra_Crud.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hydra_Crud.app.Entity.Empleado;
import com.example.hydra_Crud.app.Repository.EmpleadoRepository;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin("*") 
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // ✅ GET ALL (Obtener todos los empleados)
    @GetMapping
    public List<Empleado> obtenerEmpleados() {
        return empleadoRepository.findAll();
    }

    // ✅ GET BY ID (Obtener un empleado por su RUN)
    @GetMapping("/{run}")
    public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable String run) {
        return empleadoRepository.findById(run)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ POST (CREAR un nuevo empleado)
    @PostMapping
    public ResponseEntity<Empleado> guardar(@RequestBody Empleado empleado) {
        Empleado nuevo = empleadoRepository.save(empleado);
        return ResponseEntity.ok(nuevo);
    }

    // ✅ PUT (ACTUALIZAR un empleado)
    @PutMapping("/{run}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable String run, @RequestBody Empleado empleado) {
        return empleadoRepository.findById(run)
                .map(e -> {
                    empleado.setRun(run);
                    return ResponseEntity.ok(empleadoRepository.save(empleado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ DELETE (ELIMINAR un empleado)
    @DeleteMapping("/{run}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable String run) {
        if (!empleadoRepository.existsById(run)) {
            return ResponseEntity.notFound().build();
        }
        empleadoRepository.deleteById(run);
        return ResponseEntity.noContent().build();
    }
}