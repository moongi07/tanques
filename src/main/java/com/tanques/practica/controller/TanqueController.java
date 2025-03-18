package com.tanques.practica.controller;

import com.tanques.practica.model.Producto;
import com.tanques.practica.model.Surtidor;
import com.tanques.practica.model.Tanque;
import com.tanques.practica.service.ISurtidorService;
import com.tanques.practica.service.ITanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
public class TanqueController {

    @Autowired
    private ITanqueService tanqueService;

    @GetMapping("/tanque/traer")
    public List<Tanque> getTanque() {

        return tanqueService.getTanque();
    }

    @PostMapping("/tanque/crear")
    public String saveTanque (@RequestBody Tanque tanque) {
        tanqueService.saveTanque(tanque);

        return "El tanque fue creado correctamente";
    }

    @DeleteMapping("/tanque/borrar/{id}")
    public String deleteTanque(@PathVariable int id) {
        tanqueService.deleteTanque(id);
        return "El tanque fue eliminado correctamente";
    }

    @PutMapping("/tanque/editar/{id_original}")
    public ResponseEntity<Tanque> editTanque(
            @PathVariable int id_original,
            @RequestParam(required = false, name = "id_tanque") Integer id_nuevo,
            @RequestParam(required = false, name = "id_producto") Producto producto_nuevo,
            @RequestParam(required = false, name = "codigo") String codigo_nuevo,
            @RequestParam(required = false, name = "capacidad_maxima") Integer capacidad_maxima_nueva,
            @RequestParam(required = false, name = "nivel_actual") Integer nivel_actual_nuevo) {

        // Obtener el tanque original
        Tanque tanqueOriginal = tanqueService.findTanque(id_original);
        if (tanqueOriginal == null) {
            return ResponseEntity.notFound().build(); // Si no existe, devolver 404
        }

        // Si los valores son nulos, usamos los originales
        int idFinal = (id_nuevo != null) ? id_nuevo : tanqueOriginal.getId_tanque();
        Producto productoFinal = (producto_nuevo != null) ? producto_nuevo : tanqueOriginal.getProducto();
        String codigoFinal = (codigo_nuevo != null) ? codigo_nuevo : tanqueOriginal.getCodigo();
        int capacidadMaximaFinal = (capacidad_maxima_nueva != null) ? capacidad_maxima_nueva : tanqueOriginal.getCapacidad_maxima();
        int nivelActualFinal = (nivel_actual_nuevo != null) ? nivel_actual_nuevo : tanqueOriginal.getNivel_actual();

        // Llamar al servicio de edición
        tanqueService.editTanque(id_original, idFinal, productoFinal, codigoFinal, capacidadMaximaFinal, nivelActualFinal);

        // Recuperar el objeto actualizado para retornarlo
        Tanque tanqueEditado = tanqueService.findTanque(idFinal);

        return ResponseEntity.ok(tanqueEditado);
    }

}
