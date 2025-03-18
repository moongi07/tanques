package com.tanques.practica.repository;

import com.tanques.practica.model.Precio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrecioRepository extends JpaRepository<Precio, Integer> {
}
