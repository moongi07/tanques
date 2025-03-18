package com.tanques.practica.service;
import com.tanques.practica.model.Producto;
import com.tanques.practica.model.Tanque;
import com.tanques.practica.repository.ITanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TanqueService implements  ITanqueService{
    @Autowired
    private ITanqueRepository tanqueRepository;
    @Override
    public List<Tanque> getTanque() {
        List <Tanque> tanques = tanqueRepository.findAll();
        return tanques;
    }

    @Override
    public void saveTanque(Tanque tanque) {
    tanqueRepository.save(tanque);
    }

    @Override
    public void deleteTanque(int id) {
    tanqueRepository.deleteById(id);
    }

    @Override
    public Tanque findTanque(int id) {
        return tanqueRepository.findById(id).orElse(null);
    }

    @Override
    public void editTanque(int id_original, int id_nuevo, Producto producto_nuevo, String codigo_nuevo, int capacidad_maxima_nueva, int nivel_actual_nuevo) {
    Tanque tanque = this.findTanque(id_original);
    if (tanque != null) {
    tanque.setId_tanque(id_nuevo);
    tanque.setProducto(producto_nuevo);
    tanque.setCodigo(codigo_nuevo);
    tanque.setCapacidad_maxima(capacidad_maxima_nueva);
    tanque.setNivel_actual(nivel_actual_nuevo);
    this.saveTanque(tanque);
    }
    }
}
