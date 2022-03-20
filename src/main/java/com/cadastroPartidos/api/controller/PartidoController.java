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

import com.cadastroPartidos.api.controller.dto.AssociadoComPartidoDto;
import com.cadastroPartidos.api.controller.dto.PartidoDto;
import com.cadastroPartidos.api.entites.enums.Ideologia;
import com.cadastroPartidos.api.services.PartidoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping (value= "/partidos")
@Api
@CrossOrigin(origins="*")
public class PartidoController {
	
	@Autowired
	private PartidoService partidoService;
	
	@GetMapping
	public ResponseEntity<List<PartidoDto>> findAllOrByIdeologia(Ideologia ideologia) {
		if(ideologia != null) {
			return ResponseEntity.ok(partidoService.findByIdeologia(ideologia));
		}
		return ResponseEntity.ok(partidoService.findAll());
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<PartidoDto> findById(@PathVariable Long id){
		return ResponseEntity.ok(partidoService.findById(id));
	}
	
	@GetMapping(value= "/{id}/associados")
	public ResponseEntity<List<AssociadoComPartidoDto>> findByPartidoAssociados(@PathVariable Long id){
		return ResponseEntity.ok(partidoService.findByPartidoAssociados(id));
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PartidoDto> save (@RequestBody PartidoDto partidoDto, UriComponentsBuilder uriBuilder){
		URI uri = uriBuilder.path("/partidos/{id}").buildAndExpand(partidoDto.getId()).toUri();
		return ResponseEntity.created(uri).body(partidoService.save(partidoDto));
	}
	
	@PutMapping(value="/{id}")
	@Transactional
	public ResponseEntity<PartidoDto> updateById(@PathVariable Long id, @RequestBody PartidoDto partidoDto){
		return ResponseEntity.ok(partidoService.updateById(id, partidoDto));
	}
	
	@DeleteMapping(value= "/{id}")
	@Transactional
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		partidoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}


	


