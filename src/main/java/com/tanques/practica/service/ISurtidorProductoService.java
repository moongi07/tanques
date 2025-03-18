package com.tanques.practica.service;

import com.tanques.practica.model.Producto;
import com.tanques.practica.model.Suministro;
import com.tanques.practica.model.Surtidor;
import com.tanques.practica.model.SurtidorProducto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ISurtidorProductoService {
    //lectura
    public List<SurtidorProducto> getSurtidorProducto();
    //alta
    public void saveSurtidorProducto(SurtidorProducto surtproducto);
    //baja
    public void deleteSurtidorProducto(int id);
    //lectura de solo uno
    public SurtidorProducto findSurtidorProducto(int id);
    //edicion/modificacion
    public void editSurtidorProducto(int id_original, int id_nuevo, Surtidor surtidor_nuevo, Producto producto_nuevo, BigDecimal stockDisponible_nuevo);

    /*
            this.id = id;
        this.surtidor = surtidor;
        this.producto = producto;
        this.stock_disponible = stock_disponible;
     */
}
