package com.tanques.practica.repository;

import com.tanques.practica.model.Precio;
import com.tanques.practica.model.Surtidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISurtidorRepository extends JpaRepository<Surtidor, Integer> {
}
