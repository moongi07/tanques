package com.tanques.practica.service;
import com.tanques.practica.model.Producto;
import com.tanques.practica.model.Tanque;
import java.util.List;

public interface ITanqueService {
    //lectura
    public List<Tanque> getTanque();
    //alta
    public void saveTanque(Tanque tanque);
    //baja
    public void deleteTanque(int id);
    //lectura de solo uno
    public Tanque findTanque(int id);
    //edicion/modificacion
    public void editTanque(int id_original, int id_nuevo, Producto producto, String codigo_nuevo, int capacidad_maxima_nueva, int nivel_actual_nuevo);

}
