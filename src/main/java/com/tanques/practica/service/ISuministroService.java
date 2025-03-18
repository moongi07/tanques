package com.tanques.practica.service;
import com.tanques.practica.model.Producto;
import com.tanques.practica.model.Suministro;
import com.tanques.practica.model.Surtidor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ISuministroService {
    //lectura
    public List<Suministro> getSuministros();
    //alta
    public void saveSuministro(Suministro suministro);
    //baja
    public void deleteSuministro(int id);
    //lectura de solo uno
    public Suministro findSuministro(int id);
    //edicion/modificacion
    public void editSuministro(int id_original, int id_nuevo, Surtidor surtidor_nuevo, Producto producto_nuevo, Date fecha_hora_nueva, BigDecimal volumen_litros_nuevo, BigDecimal importe_euros_nuevo);


}
