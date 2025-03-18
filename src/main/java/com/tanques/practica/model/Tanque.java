package com.tanques.practica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Tanque {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_tanque;
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable=false)
    private Producto producto;
    private String codigo;
    private int capacidad_maxima;
    private int nivel_actual;

    public Tanque() {
    }

    public Tanque(int id_tanque, Producto producto, String codigo, int capacidad_maxima, int nivel_actual) {
        this.id_tanque = id_tanque;
        this.producto = producto;
        this.codigo = codigo;
        this.capacidad_maxima = capacidad_maxima;
        this.nivel_actual = nivel_actual;
    }

    public int getId_tanque() {
        return id_tanque;
    }

    public void setId_tanque(int id_tanque) {
        this.id_tanque = id_tanque;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidad_maxima() {
        return capacidad_maxima;
    }

    public void setCapacidad_maxima(int capacidad_maxima) {
        this.capacidad_maxima = capacidad_maxima;
    }

    public int getNivel_actual() {
        return nivel_actual;
    }

    public void setNivel_actual(int nivel_actual) {
        this.nivel_actual = nivel_actual;
    }
}
