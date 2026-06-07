package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "pacientes")
public interface PacienteRepository extends JpaRepository<Paciente, String> {
}