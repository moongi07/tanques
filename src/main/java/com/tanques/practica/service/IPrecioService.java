package com.tanques.practica.service;

import com.tanques.practica.model.Precio;
import com.tanques.practica.model.Producto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IPrecioService {

    //lectura
    public List<Precio> getPrecio();
    //alta
    public void savePrecio(Precio precio);
    //baja
    public void deletePrecio(int id);
    //lectura de solo uno
    public Precio findPrecioById(int id);
    //edicion/modificacion
    public void editPrecio(int id_original, int id_nuevo, Producto producto, Date fecha_inicio_nueva, Date fecha_fin_nueva, BigDecimal precio_por_filtro_nuevo);

}
