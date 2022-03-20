package com.cadastroPartidos.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastroPartidos.api.entites.Partido;
import com.cadastroPartidos.api.repositories.PartidoRepository;

@Service
public class PartidoService {
	
	@Autowired
	private PartidoRepository associadoRepository;
	
	public List<Partido> findAll (){
		return associadoRepository.findAll();
	}
	
	public Partido findById(Long id) {
		Optional<Partido> obg = associadoRepository.findById(id);
		return obg.get();
	}

}
