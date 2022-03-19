package com.cadastroPartidos.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastroPartidos.api.entites.Associado;
import com.cadastroPartidos.api.repositories.AssociadoRepository;

@Service
public class AssociadoService {
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	public List<Associado> findAll (){
		return associadoRepository.findAll();
	}
	
	public Associado findById(Long id) {
		Optional<Associado> obg = associadoRepository.findById(id);
		return obg.get();
	}

}
