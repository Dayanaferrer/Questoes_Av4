package com.cadastroPartidos.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastroPartidos.api.entites.Associado;

@RestController
@RequestMapping (value= "/associados")
public class AssociadoController {
	
	@GetMapping
	public ResponseEntity<Associado> findAll(){
		Associado a = new Associado(1L, "Joana Dark", "Vereadora", null, "Feminino");
		return ResponseEntity.ok().body(a);
	}

}
