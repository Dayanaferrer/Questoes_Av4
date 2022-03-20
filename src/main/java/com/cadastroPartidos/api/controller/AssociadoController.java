package com.cadastroPartidos.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cadastroPartidos.api.entites.Associado;
import com.cadastroPartidos.api.entites.enums.CargoPolitico;
import com.cadastroPartidos.api.services.AssociadoService;

@RestController
@RequestMapping (value= "/associados")
public class AssociadoController {
	
	@Autowired
	private AssociadoService associadoService;
	
	@GetMapping
	public ResponseEntity<List<Associado>> findAllByCargoPolitico(CargoPolitico cargo){
		if (cargo != null) {
			return ResponseEntity.ok(associadoService.findByCargoPolitico(cargo));
		}
		
		return ResponseEntity.ok(associadoService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Associado> save(@RequestBody @Valid Associado associado, UriComponentsBuilder uriBuilder){
		URI uri = uriBuilder.path("/associados/{id}").buildAndExpand(associado.getId()).toUri();
		return ResponseEntity.created(uri).body(associadoService.save(associado));
	}
	

}
