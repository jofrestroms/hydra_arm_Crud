package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @Column(name="id_pais", length = 1000)
    private Integer id_pais;

    @Column(name="nombre", length = 1000)
    private String nombre;
    //───────── Getters y Setters ─────────

    public Integer getId_Pais() { return id_pais; }
    public void setId_Pais(Integer id_pais){
        this.id_pais = id_pais;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre){
        this.nombre = nombre != null ? nombre.toLowerCase().trim() : null;
    }
    
}
