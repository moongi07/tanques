package com.tanques.practica.controller;

import com.tanques.practica.model.Suministro;
import com.tanques.practica.model.Surtidor;
import com.tanques.practica.service.ISuministroService;
import com.tanques.practica.service.ISurtidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
public class SurtidorController {

    @Autowired
    private ISurtidorService surtidorService;

    @GetMapping("/surtidor/traer")
    public List<Surtidor> getSurtidor() {

        return surtidorService.getSurtidores();
    }

    @PostMapping("/surtidor/crear")
    public String saveSurtidor (@RequestBody Surtidor surtidor) {
        surtidorService.saveSurtidor(surtidor);

        return "El surtidor fue creado correctamente";
    }

    @DeleteMapping("/surtidor/borrar/{id}")
    public String deleteSurtidor(@PathVariable int id) {
        surtidorService.deleteSurtidor(id);
        return "El surtidor fue eliminado correctamente";
    }

    @PutMapping("/surtidor/editar/{id_original}")
    public ResponseEntity<Surtidor> editSurtidor(
            @PathVariable int id_original,
            @RequestParam(required = false, name = "id_surtidor") Integer id_nuevo,
            @RequestParam(required = false, name = "codigo") String codigo_nuevo,
            @RequestParam(required = false, name = "fecha_registro") Date fecha_registro_nueva,
            @RequestParam(required = false, name = "activo") Boolean activo_nuevo) {

        // Obtener el surtidor original
        Surtidor surtidorOriginal = surtidorService.findSurtidor(id_original);
        if (surtidorOriginal == null) {
            return ResponseEntity.notFound().build(); // Si no existe, devolver 404
        }

        // Si los valores son nulos, usamos los originales
        int idFinal = (id_nuevo != null) ? id_nuevo : surtidorOriginal.getId_surtidor();
        String codigoFinal = (codigo_nuevo != null) ? codigo_nuevo : surtidorOriginal.getCodigo();
        Date fechaRegistroFinal = (fecha_registro_nueva != null) ? fecha_registro_nueva : surtidorOriginal.getFecha_registro();
        boolean activoFinal = (activo_nuevo != null) ? activo_nuevo : surtidorOriginal.isActivo();

        // Llamar al método de edición
        surtidorService.editSurtidor(id_original, idFinal, codigoFinal, fechaRegistroFinal, activoFinal);

        // Recuperar el objeto actualizado para retornarlo
        Surtidor surtidorEditado = surtidorService.findSurtidor(idFinal);

        return ResponseEntity.ok(surtidorEditado);
    }


}
