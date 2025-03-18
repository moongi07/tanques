package com.tanques.practica.controller;
import com.tanques.practica.model.Precio;
import com.tanques.practica.model.Producto;
import com.tanques.practica.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/producto/traer")
    public List<Producto> getProducto() {

        return productoService.getProductos();
    }

    @PostMapping("/producto/crear")
    public String saveProducto (@RequestBody Producto producto) {
        productoService.saveProducto(producto);

        return "El producto fue creado correctamente";
    }

    @DeleteMapping("/producto/borrar/{id}")
    public String deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
        return "El producto fue eliminado correctamente";
    }

    @PutMapping("/producto/editar/{id_original}")
    public ResponseEntity<Producto> editProducto(
            @PathVariable int id_original,
            @RequestParam(required = false, name = "id_producto") Integer nuevaId,
            @RequestParam(required = false, name = "nombre") String nombreNuevo,
            @RequestParam(required = false, name = "descripcion") String descripcionNueva,
            @RequestParam(required = false, name = "tipo") String tipoNuevo) {

        // Obtener el producto original
        Producto productoOriginal = productoService.findProducto(id_original);
        if (productoOriginal == null) {
            return ResponseEntity.notFound().build(); // Si no existe, devolver 404
        }

        // Si los valores son nulos, usamos los originales
        int idFinal = (nuevaId != null) ? nuevaId : productoOriginal.getId_producto();
        String nombreFinal = (nombreNuevo != null) ? nombreNuevo : productoOriginal.getNombre();
        String descripcionFinal = (descripcionNueva != null) ? descripcionNueva : productoOriginal.getDescripcion();
        String tipoFinal = (tipoNuevo != null) ? tipoNuevo : productoOriginal.getTipo();

        // Llamar al método para actualizar (sin retorno porque es `void`)
        productoService.editProducto(id_original, idFinal, nombreFinal, descripcionFinal, tipoFinal);

        // Recuperar el objeto actualizado para retornarlo
        Producto productoEditado = productoService.findProducto(idFinal);

        return ResponseEntity.ok(productoEditado);
    }

}
