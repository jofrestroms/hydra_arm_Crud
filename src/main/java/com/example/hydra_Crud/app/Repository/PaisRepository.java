package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "Pais")
public interface PaisRepository extends JpaRepository<Pais, Integer>{
    
}
