package com.cadastroPartidos.api.controller.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cadastroPartidos.api.entites.Associado;
import com.cadastroPartidos.api.entites.Partido;
import com.cadastroPartidos.api.entites.enums.CargoPolitico;

public class AssociadoComPartidoDto {

	private Long id;
		
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private CargoPolitico cargoPolitico;
	
	private String nomePartido;
	
	public AssociadoComPartidoDto() {}

	public AssociadoComPartidoDto(Associado associado, Partido partido) {
		this.setId(associado.getId());
		this.setNome(associado.getNome());
		this.setCargoPolitico(associado.getCargoPolitico());
		this.setNomePartido(partido.getNomeDoPartido());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CargoPolitico getCargoPolitico() {
		return cargoPolitico;
	}

	public void setCargoPolitico(CargoPolitico cargoPolitico) {
		this.cargoPolitico = cargoPolitico;
	}

	public String getNomePartido() {
		return nomePartido;
	}

	public void setNomePartido(String nomePartido) {
		this.nomePartido = nomePartido;
	}


	

}
