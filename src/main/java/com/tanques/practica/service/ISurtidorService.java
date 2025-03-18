package com.tanques.practica.service;
import com.tanques.practica.model.Surtidor;
import java.util.Date;
import java.util.List;

public interface ISurtidorService {
    //lectura
    public List<Surtidor> getSurtidores();
    //alta
    public void saveSurtidor(Surtidor surtidor);
    //baja
    public void deleteSurtidor(int id);
    //lectura de solo uno
    public Surtidor findSurtidor(int id);
    //edicion/modificacion
    public void editSurtidor(int id_original, int id_nuevo, String codigo_nuevo, Date fecha_instalacion_nueva, boolean activo_nuevo);
}
