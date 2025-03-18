package com.tanques.practica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "surtidor_producto") // Definir el nombre de la tabla en BD
public class SurtidorProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_surtidor", nullable = false)
    private Surtidor surtidor;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private BigDecimal stock_disponible;

    public SurtidorProducto() {
    }

    public SurtidorProducto(int id, Surtidor surtidor, Producto producto, BigDecimal stock_disponible) {
        this.id = id;
        this.surtidor = surtidor;
        this.producto = producto;
        this.stock_disponible = stock_disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Surtidor getSurtidor() {
        return surtidor;
    }

    public void setSurtidor(Surtidor surtidor) {
        this.surtidor = surtidor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public BigDecimal getStock_disponible() {
        return stock_disponible;
    }

    public void setStock_disponible(BigDecimal stock_disponible) {
        this.stock_disponible = stock_disponible;
    }
}
