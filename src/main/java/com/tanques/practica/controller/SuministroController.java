package com.tanques.practica.controller;
import com.tanques.practica.model.Producto;
import com.tanques.practica.model.Suministro;
import com.tanques.practica.model.Surtidor;
import com.tanques.practica.service.ISuministroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
public class SuministroController {
    @Autowired
    private ISuministroService suministroService;

    @GetMapping("/suministro/traer")
    public List<Suministro> getSuministro() {

        return suministroService.getSuministros();
    }

    @PostMapping("/suministro/crear")
    public String saveSuministro (@RequestBody Suministro suministro) {
        suministroService.saveSuministro(suministro);

        return "El suministro fue creado correctamente";
    }

    @DeleteMapping("/suministro/borrar/{id}")
    public String deleteSuministro(@PathVariable int id) {
        suministroService.deleteSuministro(id);
        return "El suministro fue eliminado correctamente";
    }

    @PutMapping("/suministro/editar/{id_original}")
    public ResponseEntity<Suministro> editSuministro(
            @PathVariable int id_original,
            @RequestParam(required = false, name = "id_suministro") Integer id_nuevo,
            @RequestParam(required = false, name = "id_surtidor") Surtidor surtidor_nuevo,
            @RequestParam(required = false, name = "id_producto") Producto producto_nuevo,
            @RequestParam(required = false, name = "fecha_hora") Date fecha_hora_nueva,
            @RequestParam(required = false, name = "volumen_litros") BigDecimal volumen_litros_nuevo,
            @RequestParam(required = false, name = "importe_euros") BigDecimal importe_euros_nuevo) {

        // Obtener el suministro original
        Suministro suministroOriginal = suministroService.findSuministro(id_original);
        if (suministroOriginal == null) {
            return ResponseEntity.notFound().build(); // Si no existe, devolver 404
        }

        // Si los valores son nulos, usamos los originales
        int idFinal = (id_nuevo != null) ? id_nuevo : suministroOriginal.getId_suministro();
        Surtidor surtidorFinal = (surtidor_nuevo != null) ? surtidor_nuevo : suministroOriginal.getSurtidor();
        Producto productoFinal = (producto_nuevo != null) ? producto_nuevo : suministroOriginal.getProducto();
        Date fechaHoraFinal = (fecha_hora_nueva != null) ? fecha_hora_nueva : suministroOriginal.getFecha_hora();
        BigDecimal volumenFinal = (volumen_litros_nuevo != null) ? volumen_litros_nuevo : suministroOriginal.getVolumen_litros();
        BigDecimal importeFinal = (importe_euros_nuevo != null) ? importe_euros_nuevo : suministroOriginal.getImporte_euros();

        // Llamar al método para actualizar (sin retorno porque es `void`)
        suministroService.editSuministro(id_original, idFinal, surtidorFinal, productoFinal, fechaHoraFinal, volumenFinal, importeFinal);

        // Recuperar el objeto actualizado para retornarlo
        Suministro suministroEditado = suministroService.findSuministro(idFinal);

        return ResponseEntity.ok(suministroEditado);
    }

}
