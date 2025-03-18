package com.tanques.practica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter
@Entity
public class Suministro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_suministro;
    @ManyToOne
    @JoinColumn(name = "id_surtidor")
    private Surtidor surtidor;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    private Date fecha_hora;
    private BigDecimal volumen_litros;
    private BigDecimal importe_euros;

    public Suministro() {
    }

    public Suministro(int id_suministro, Surtidor surtidor, Producto producto, Date fecha_hora, BigDecimal volumen_litros, BigDecimal importe_euros) {
        this.id_suministro = id_suministro;
        this.surtidor = surtidor;
        this.producto = producto;
        this.fecha_hora = fecha_hora;
        this.volumen_litros = volumen_litros;
        this.importe_euros = importe_euros;
    }

    public int getId_suministro() {
        return id_suministro;
    }

    public void setId_suministro(int id_suministro) {
        this.id_suministro = id_suministro;
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

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public BigDecimal getVolumen_litros() {
        return volumen_litros;
    }

    public void setVolumen_litros(BigDecimal volumen_litros) {
        this.volumen_litros = volumen_litros;
    }

    public BigDecimal getImporte_euros() {
        return importe_euros;
    }

    public void setImporte_euros(BigDecimal importe_euros) {
        this.importe_euros = importe_euros;
    }
}
