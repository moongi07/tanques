package com.tanques.practica.controller;

import com.tanques.practica.model.Producto;
import com.tanques.practica.model.Surtidor;
import com.tanques.practica.model.SurtidorProducto;
import com.tanques.practica.repository.ISurtidorProductoRepository;
import com.tanques.practica.service.ISurtidorProductoService;
import com.tanques.practica.service.ITanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
public class SurtidorProductoController {

    @Autowired
    private ISurtidorProductoService surtidorProductoService;

    @GetMapping("/surtidorproducto/traer")
    public List<SurtidorProducto> getSurtidorProducto() {

        return surtidorProductoService.getSurtidorProducto();
    }

    @PostMapping("/surtidorproducto/crear")
    public String saveSurtidorProducto (@RequestBody SurtidorProducto surtproducto) {
        surtidorProductoService.saveSurtidorProducto(surtproducto);

        return "El surtidorProducto fue creado correctamente";
    }

    @DeleteMapping("/surtidorproducto/borrar/{id}")
    public String deleteSurtidorProducto(@PathVariable int id) {
        surtidorProductoService.deleteSurtidorProducto(id);
        return "El surtidorProducto fue eliminado correctamente";
    }

    @PutMapping("/surtidorproducto/editar/{id_original}")
    public ResponseEntity<SurtidorProducto> editSurtidorProducto(
            @PathVariable int id_original,
            @RequestParam(required = false, name = "id") Integer id_nuevo,
            @RequestParam(required = false, name = "surtidor") Surtidor surtidor_nuevo,
            @RequestParam(required = false, name = "producto") Producto producto_nuevo,
            @RequestParam(required = false, name = "stock_disponible") BigDecimal stockDecimal_nuevo) {

        // Obtener el registro original
        SurtidorProducto surtidorProductoOriginal = surtidorProductoService.findSurtidorProducto(id_original);
        if (surtidorProductoOriginal == null) {
            return ResponseEntity.notFound().build(); // Si no existe, devolver 404
        }

        // Si los valores son nulos, usamos los originales
        int idFinal = (id_nuevo != null) ? id_nuevo : surtidorProductoOriginal.getId();
        Surtidor surtidorFinal = (surtidor_nuevo != null) ? surtidor_nuevo : surtidorProductoOriginal.getSurtidor();
        Producto productoFinal = (producto_nuevo != null) ? producto_nuevo : surtidorProductoOriginal.getProducto();
        BigDecimal stockFinal = (stockDecimal_nuevo != null) ? stockDecimal_nuevo : surtidorProductoOriginal.getStock_disponible();

        // Llamar al método de edición
        surtidorProductoService.editSurtidorProducto(id_original, idFinal, surtidorFinal, productoFinal, stockFinal);

        // Recuperar el objeto actualizado para retornarlo
        SurtidorProducto surtidorProductoEditado = surtidorProductoService.findSurtidorProducto(idFinal);

        return ResponseEntity.ok(surtidorProductoEditado);
    }



}
