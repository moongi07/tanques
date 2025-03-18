package com.tanques.practica.service;

import com.tanques.practica.model.Producto;
import com.tanques.practica.model.Suministro;
import com.tanques.practica.model.Surtidor;
import com.tanques.practica.repository.IProductoRepository;
import com.tanques.practica.repository.ISuministroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class SuministroService implements ISuministroService {

    @Autowired
    private ISuministroRepository SuministroRepository;
    @Override
    public List<Suministro> getSuministros() {
        List<Suministro> suministros = SuministroRepository.findAll();
        return suministros;
    }

    @Override
    public void saveSuministro(Suministro suministro) {
    SuministroRepository.save(suministro);
    }

    @Override
    public void deleteSuministro(int id) {
    SuministroRepository.deleteById(id);
    }

    @Override
    public Suministro findSuministro(int id) {
        return SuministroRepository.findById(id).orElse(null);
    }

    @Override
    public void editSuministro(int id_original, int id_nuevo, Surtidor surtidor_nuevo,Producto producto_nuevo, Date fecha_hora_nueva, BigDecimal volumen_litros_nuevo, BigDecimal importe_euros_nuevo) {
        Suministro su = this.findSuministro(id_original);
        su.setId_suministro(id_nuevo);
        su.setSurtidor(surtidor_nuevo);
        su.setProducto(producto_nuevo);
        su.setFecha_hora(fecha_hora_nueva);
        su.setVolumen_litros(volumen_litros_nuevo);
        su.setImporte_euros(importe_euros_nuevo);
        this.saveSuministro(su);
    }
}
