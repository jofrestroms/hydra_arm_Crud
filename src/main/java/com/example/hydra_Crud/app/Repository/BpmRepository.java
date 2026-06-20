package com.example.hydra_Crud.app.Repository;

import com.example.hydra_Crud.app.Entity.Bpm;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface BpmRepository extends JpaRepository<Bpm, Long> {
    List<Bpm> findByRunPAndFechaBetween(
            String runP,
            LocalDateTime inicio,
            LocalDateTime fin);
}
