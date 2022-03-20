package com.cadastroPartidos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastroPartidos.api.entites.Partido;
import com.cadastroPartidos.api.services.PartidoService;

@RestController
@RequestMapping (value= "/partidos")
public class PartidoController {
	
	@Autowired
	private PartidoService associadoService;
	
	@GetMapping
	public ResponseEntity<List<Partido>> findAll(){
		List <Partido> list = associadoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Partido> findById(@PathVariable Long id){
		Partido obj = associadoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
