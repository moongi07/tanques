package com.tanques.practica.service;
import com.tanques.practica.model.Producto;
import java.util.List;

public interface IProductoService {

    //lectura
    public List<Producto> getProductos();
    //alta
    public void saveProducto(Producto producto);
    //baja
    public void deleteProducto(int id);
    //lectura de solo uno
    public Producto findProducto(int id);
    //edicion/modificacion
    public void editProducto(int id_original, int id_nuevo, String nombre_nuevo, String descripcion_nueva, String tipo_nuevo);

}
