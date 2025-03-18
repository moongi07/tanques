package com.tanques.practica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@Entity
public class Surtidor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_surtidor;
    private String codigo;
    private Date fecha_registro;
    private boolean activo;

    public Surtidor() {
    }

    public Surtidor(int id_surtidor, String codigo, Date fecha_registro, boolean activo) {
        this.id_surtidor = id_surtidor;
        this.codigo = codigo;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public int getId_surtidor() {
        return id_surtidor;
    }

    public void setId_surtidor(int id_surtidor) {
        this.id_surtidor = id_surtidor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
