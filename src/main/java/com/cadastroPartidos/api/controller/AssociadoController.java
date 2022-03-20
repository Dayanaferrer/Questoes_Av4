package com.cadastroPartidos.api.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cadastroPartidos.api.entites.Associado;
import com.cadastroPartidos.api.entites.enums.CargoPolitico;
import com.cadastroPartidos.api.services.AssociadoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping (value= "/associados")
@Api(value = "API Cadastro de partidos politicos e seus associados")
@CrossOrigin(origins="*")
public class AssociadoController {
	
	@Autowired
	private AssociadoService associadoService;
	
	
	@GetMapping
	@ApiOperation (value ="Retorna uma lista de associados" )
	public ResponseEntity<List<Associado>> findAllByCargoPolitico(CargoPolitico cargo){
		if (cargo != null) {
			return ResponseEntity.ok(associadoService.findByCargoPolitico(cargo));
		}		
		return ResponseEntity.ok(associadoService.findAll());
	}
	
	
	@GetMapping(value = "/{id}")
	@ApiOperation (value ="Retorna um unico associado" )
	public ResponseEntity<Associado> findById(@PathVariable Long id){
		return ResponseEntity.ok(associadoService.findById(id));
	}
	
	@PostMapping
	@Transactional
	@ApiOperation (value ="Salva um associado" )
	public ResponseEntity<Associado> save(@RequestBody Associado associado, UriComponentsBuilder uriBuilder){
		URI uri = uriBuilder.path("/associados/{id}").buildAndExpand(associado.getId()).toUri();
		return ResponseEntity.created(uri).body(associadoService.save(associado));
	}
	
	@PutMapping("/{id}")
	@Transactional
	@ApiOperation (value ="Atualiza associado" )
	public ResponseEntity<Associado> updateById(@PathVariable Long id, @RequestBody Associado associado){
		return ResponseEntity.ok(associadoService.updateById(id, associado));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@ApiOperation (value ="Deleta um unico associado" )
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		associadoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	

}
