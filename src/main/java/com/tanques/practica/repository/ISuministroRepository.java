package com.tanques.practica.repository;

import com.tanques.practica.model.Precio;
import com.tanques.practica.model.Suministro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISuministroRepository extends JpaRepository<Suministro, Integer> {
}
