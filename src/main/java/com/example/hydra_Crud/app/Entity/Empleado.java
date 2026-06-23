package com.example.hydra_Crud.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @Column(name = "run", length = 1000)
    private String run;

    @Column(name = "nombre", length = 1000)
    private String nombre;

    @Column(name = "apellido_materno", length = 1000)
    private String apellidoMaterno;

    @Column(name = "apellido_paterno", length = 1000)
    private String apellidoPaterno;

    @Column(name = "correo", unique = true, length = 1000)
    private String correo;

    @Column(name = "password", length = 1000)
    private String password; 

    // Mapeo simple de las llaves foráneas para evitar errores si no existen las otras clases
    @Column(name = "rol_id_rol")
    private Integer rolIdRol;

    @Column(name = "sucursal_id_sucursal")
    private Integer sucursalIdSucursal;


    // ───── Getters y Setters ─────

    public String getRun() { return run; }
    public void setRun(String run) {
        this.run = run != null ? run.toLowerCase().trim() : null;
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

    public Integer getRolIdRol() { return rolIdRol; }
    public void setRolIdRol(Integer rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    public Integer getSucursalIdSucursal() { return sucursalIdSucursal; }
    public void setSucursalIdSucursal(Integer sucursalIdSucursal) {
        this.sucursalIdSucursal = sucursalIdSucursal;
    }
}