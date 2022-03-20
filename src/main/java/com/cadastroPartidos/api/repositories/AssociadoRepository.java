package com.cadastroPartidos.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastroPartidos.api.entites.Associado;
import com.cadastroPartidos.api.entites.enums.CargoPolitico;

public interface AssociadoRepository extends JpaRepository<Associado, Long>{
	List<Associado> findByCargoPolitico(CargoPolitico cargo);
}