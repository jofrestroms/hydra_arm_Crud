package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "empleados")
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
}
