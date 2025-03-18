package com.tanques.practica.repository;

import com.tanques.practica.model.Precio;
import com.tanques.practica.model.Tanque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITanqueRepository extends JpaRepository<Tanque, Integer> {
}
