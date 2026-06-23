package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @Column(name = "run_p", length = 1000) // 1. Aumentamos largo por encriptación
    private String runP;

    @Column(name = "nombre", length = 1000)
    private String nombre;

    @Column(name = "apellido_materno", length = 1000)
    private String apellidoMaterno;

    @Column(name = "apelllido_paterno", length = 1000)
    private String apellidoPaterno;

    @Column(name = "correo", unique = true, length = 1000)
    private String correo;

    @Column(name = "pasword", length = 1000) // El hash robusto es muy largo
    private String password; 

    @Column(name = "genero")
    private String genero;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "altura")
    private Integer altura;

    @Column(name = "peso")
    private Integer peso;

    @Column(name = "telefono", length = 1000) 
    private String telefono; 


    // ───── Getters y Setters ─────

    public String getRunP() { return runP; }
    public void setRunP(String runP) {
        this.runP = runP != null ? runP.toLowerCase().trim() : null;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim() : null;
    }

    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno != null ? apellidoMaterno.trim() : null;
    }

    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno != null ? apellidoPaterno.trim() : null;
    }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) {
        this.correo = correo != null ? correo.toLowerCase().trim() : null;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenero() { return genero; }
    public void setGenero(String genero) {
        this.genero = genero != null ? genero.toUpperCase().trim() : null;
    }

    public Integer getEdad() { return edad; }
    public void setEdad(Integer edad) {
        this.edad = (edad != null && edad > 0) ? edad : null; // ✅ ahora sí funciona
    }

    public Integer getAltura() { return altura; }
    public void setAltura(Integer altura) {
        this.altura = (altura != null && altura > 0) ? altura : null;
    }

    public Integer getPeso() { return peso; }
    public void setPeso(Integer peso) {
        this.peso = (peso != null && peso > 0) ? peso : null;
    }

    public String getTelefono() { return telefono; }
public void setTelefono(String telefono) { 
    this.telefono = telefono; 
}
    
}