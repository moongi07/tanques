package com.tanques.practica.controller;

import com.tanques.practica.model.Precio;
import com.tanques.practica.model.Producto;
import com.tanques.practica.service.IPrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
public class PrecioController {
    @Autowired
    private IPrecioService precioService;

    @GetMapping("/precio/traer")
    public List<Precio> getPrecio() {

        return precioService.getPrecio();
    }

    @PostMapping("/precio/crear")
    public String savePrecio(@RequestBody Precio pre) {
        precioService.savePrecio(pre);

        return "El precio fue creado correctamente";
    }

    @DeleteMapping("/precio/borrar/{id}")
    public String deletePrecio(@PathVariable int id) {
        precioService.deletePrecio(id);
        return "El precio fue eliminado correctamente";
    }

    @PutMapping("/precio/editar/{id_original}")
    public ResponseEntity<Precio> editPrecio(
            @PathVariable int id_original,
            @RequestParam(required = false, name = "id_precio") Integer nuevaId,
            @RequestParam(required = false, name = "producto") Producto producto_nuevo,
            @RequestParam(required = false, name = "fecha_inicio") Date fecha_inicio_nueva,
            @RequestParam(required = false, name = "fecha_fin") Date fecha_fin_nueva,
            @RequestParam(required = false, name = "precio_por_filtro") BigDecimal precio_por_filtro_nuevo) {

        //obtenemos el precio original
        Precio precioOriginal = precioService.findPrecioById(id_original);
        if (precioOriginal == null) {
            return ResponseEntity.notFound().build(); //si no existe devolvemos 404
        }

        // Si los valores son nulos, usamos los originales
        int idFinal = (nuevaId != null) ? nuevaId : precioOriginal.getId_precio();
        Producto productoFinal = (producto_nuevo != null) ? producto_nuevo : precioOriginal.getProducto();
        Date fechaInicioFinal = (fecha_inicio_nueva != null) ? fecha_inicio_nueva : precioOriginal.getFecha_inicio();
        Date fechaFinFinal = (fecha_fin_nueva != null) ? fecha_fin_nueva : precioOriginal.getFecha_fin();
        BigDecimal precioFinal = (precio_por_filtro_nuevo != null) ? precio_por_filtro_nuevo : precioOriginal.getPrecio_por_filtro();


        precioService.editPrecio(id_original, idFinal, productoFinal, fechaInicioFinal, fechaFinFinal, precioFinal);


        Precio precioEditado = precioService.findPrecioById(idFinal);

        return ResponseEntity.ok(precioEditado);
    }
}
