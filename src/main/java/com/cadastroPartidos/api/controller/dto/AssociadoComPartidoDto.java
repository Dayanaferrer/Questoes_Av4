package com.cadastroPartidos.api.controller.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cadastroPartidos.api.entites.enums.CargoPolitico;

public class AssociadoComPartidoDto {

private Integer id;
	
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private CargoPolitico cargoPolitico;
	
	private String nomePartido;
	
	public AssociadoComPartidoDto() {}

	public AssociadoComPartidoDto(Integer id, String nome, CargoPolitico cargoPolitico, String nomePartido) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargoPolitico = cargoPolitico;
		this.nomePartido = nomePartido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
