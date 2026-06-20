package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
}