package com.cadastroPartidos.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastroPartidos.api.controller.dto.PartidoDto;
import com.cadastroPartidos.api.entites.Partido;
import com.cadastroPartidos.api.entites.enums.Ideologia;

public interface PartidoRepository extends JpaRepository<Partido, Long>{
	List<PartidoDto> findByIdeologia(Ideologia ideologia);

}