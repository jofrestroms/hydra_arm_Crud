package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "roles")
public interface RolRepository extends JpaRepository<Rol, Integer> {
}