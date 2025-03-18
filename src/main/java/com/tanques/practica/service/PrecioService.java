package com.tanques.practica.service;

import com.tanques.practica.model.Precio;
import com.tanques.practica.model.Producto;
import com.tanques.practica.repository.IPrecioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class PrecioService implements  IPrecioService{
    @Autowired
    private IPrecioRepository precioRespository;

    @Override
    public List<Precio> getPrecio() {
    List<Precio> precios = precioRespository.findAll();
    return precios;
    }

    @Override
    public void savePrecio(Precio precio) {
    precioRespository.save(precio);
    }

    @Override
    public void deletePrecio(int id) {
    precioRespository.deleteById(id);
    }

    @Override
    public Precio findPrecioById(int id) {
    Precio pre = precioRespository.findById(id).orElse(null);
    return pre;
    }

    @Override
    public void editPrecio(int id_original, int id_nuevo, Producto producto, Date fecha_inicio_nueva, Date fecha_fin_nueva, BigDecimal precio_por_filtro_nuevo) {
    Precio pre = this.findPrecioById(id_original);
    pre.setId_precio(id_nuevo);
    pre.setProducto(producto);
    pre.setFecha_inicio(fecha_inicio_nueva);
    pre.setFecha_fin(fecha_fin_nueva);
    pre.setPrecio_por_filtro(precio_por_filtro_nuevo);
    this.savePrecio(pre);
    }
}
