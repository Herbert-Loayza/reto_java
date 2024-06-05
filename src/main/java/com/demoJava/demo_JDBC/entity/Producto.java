package com.demoJava.demo_JDBC.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    private Integer id;

    private String nombre;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
