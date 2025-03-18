package com.tanques.practica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


@Entity
public class Precio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_precio; // Se recomienda usar Long en lugar de int para claves primarias

    @ManyToOne
    @JoinColumn(name = "id_producto") // Nombre de la clave foránea en la BD
    private Producto producto; // Referencia a la entidad Producto

    private Date fecha_inicio;

    private Date fecha_fin;

    @Column(precision = 10, scale = 2) // Para definir un decimal con 2 decimales
    private BigDecimal precio_por_filtro;

    public Precio() {
    }

    public Precio(int id_precio, Producto producto, Date fecha_inicio, Date fecha_fin, BigDecimal precio_por_filtro) {
        this.id_precio = id_precio;
        this.producto = producto;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.precio_por_filtro = precio_por_filtro;
    }

    public int getId_precio() {
        return id_precio;
    }

    public void setId_precio(int id_precio) {
        this.id_precio = id_precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public BigDecimal getPrecio_por_filtro() {
        return precio_por_filtro;
    }

    public void setPrecio_por_filtro(BigDecimal precio_por_filtro) {
        this.precio_por_filtro = precio_por_filtro;
    }
}
