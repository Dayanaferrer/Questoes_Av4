package com.cadastroPartidos.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastroPartidos.api.entites.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Long>{

}