package com.tanques.practica.service;
import com.tanques.practica.model.Producto;
import com.tanques.practica.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository productoRepository;
    @Override
    public List<Producto> getProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos;
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(int id) {
    productoRepository.deleteById(id);
    }

    @Override
    public Producto findProducto(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void editProducto(int id_original, int id_nuevo, String nombre_nuevo, String descripcion_nueva, String tipo_nuevo) {
        Producto pro = this.findProducto(id_original);
        pro.setId_producto(id_nuevo);
        pro.setNombre(nombre_nuevo);
        pro.setDescripcion(descripcion_nueva);
        pro.setTipo(tipo_nuevo);
        this.saveProducto(pro);
    }
}
