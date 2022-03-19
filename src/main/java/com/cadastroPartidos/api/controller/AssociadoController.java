package com.cadastroPartidos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastroPartidos.api.entites.Associado;
import com.cadastroPartidos.api.services.AssociadoService;

@RestController
@RequestMapping (value= "/associados")
public class AssociadoController {
	
	@Autowired
	private AssociadoService associadoService;
	
	@GetMapping
	public ResponseEntity<List<Associado>> findAll(){
		List <Associado> list = associadoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Associado> findById(@PathVariable Long id){
		Associado obj = associadoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
