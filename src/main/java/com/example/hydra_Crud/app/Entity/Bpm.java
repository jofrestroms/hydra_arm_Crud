package com.example.hydra_Crud.app.Entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bpm")
public class Bpm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBpm;

    @Column(name = "run_p")
    private String runP;

    private Integer valorBpm;

    private LocalDateTime fecha;

    // Getters y Setters

    public String getRunP() { return runP; }
    public void setRunP(String runP) { this.runP = runP; }

    public Integer getValorBpm() { return valorBpm; }
    public void setValorBpm(Integer valorBpm) { this.valorBpm = valorBpm; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    
}