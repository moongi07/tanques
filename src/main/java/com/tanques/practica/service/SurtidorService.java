package com.tanques.practica.service;

import com.tanques.practica.model.Suministro;
import com.tanques.practica.model.Surtidor;
import com.tanques.practica.repository.ISuministroRepository;
import com.tanques.practica.repository.ISurtidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SurtidorService implements ISurtidorService {
    @Autowired
    private ISurtidorRepository surtidorRepository;
    @Override
    public List<Surtidor> getSurtidores() {
        List<Surtidor> surtidores = surtidorRepository.findAll();
        return surtidores;
    }

    @Override
    public void saveSurtidor(Surtidor surtidor) {
    surtidorRepository.save(surtidor);
    }

    @Override
    public void deleteSurtidor(int id) {
    surtidorRepository.deleteById(id);
    }

    @Override
    public Surtidor findSurtidor(int id) {
        return surtidorRepository.findById(id).orElse(null);
    }

    @Override
    public void editSurtidor(int id_original, int id_nuevo, String codigo_nuevo, Date fecha_instalacion_nueva, boolean activo_nuevo) {
        Surtidor sur = this.findSurtidor(id_original);
        sur.setId_surtidor(id_nuevo);
        sur.setCodigo(codigo_nuevo);
        sur.setFecha_registro(fecha_instalacion_nueva);
        sur.setActivo(activo_nuevo);
        this.saveSurtidor(sur);
    }
}
