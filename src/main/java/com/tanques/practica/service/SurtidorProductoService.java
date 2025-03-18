package com.tanques.practica.service;

import com.tanques.practica.model.Producto;
import com.tanques.practica.model.Suministro;
import com.tanques.practica.model.Surtidor;
import com.tanques.practica.model.SurtidorProducto;
import com.tanques.practica.repository.ISuministroRepository;
import com.tanques.practica.repository.ISurtidorProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class SurtidorProductoService implements ISurtidorProductoService{

    @Autowired
    private ISurtidorProductoRepository surtidorProductoRepository;

    @Override
    public List<SurtidorProducto> getSurtidorProducto() {
        List<SurtidorProducto> elementos = surtidorProductoRepository.findAll();
        return elementos;
    }

    @Override
    public void saveSurtidorProducto(SurtidorProducto surtproducto) {
        surtidorProductoRepository.save(surtproducto);
    }

    @Override
    public void deleteSurtidorProducto(int id) {
        surtidorProductoRepository.deleteById(id);
    }

    @Override
    public SurtidorProducto findSurtidorProducto(int id) {
        return surtidorProductoRepository.findById(id).orElse(null);
    }

    @Override
    public void editSurtidorProducto(int id_original, int id_nuevo, Surtidor surtidor_nuevo, Producto producto_nuevo, BigDecimal stockDisponible_nuevo) {
        SurtidorProducto su = this.findSurtidorProducto(id_original);
        su.setId(id_nuevo);
        su.setProducto(producto_nuevo);
        su.setSurtidor(surtidor_nuevo);
        su.setStock_disponible(stockDisponible_nuevo);
        this.saveSurtidorProducto(su);
    }
}
