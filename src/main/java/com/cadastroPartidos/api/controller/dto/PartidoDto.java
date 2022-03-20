package com.cadastroPartidos.api.controller.dto;

import java.time.LocalDate;

import com.cadastroPartidos.api.entites.Partido;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PartidoDto {

	private Long id;
	
	private String nomeDoPartido;
		
	private String sigla;	
	
	private String ideologia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeFundacao;
	
	public PartidoDto() {}

	public PartidoDto(Long id, String nomeDoPartido, String sigla, String ideologia, LocalDate dataDeFundacao) {
		super();
		this.id = id;
		this.nomeDoPartido = nomeDoPartido;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataDeFundacao = dataDeFundacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoPartido() {
		return nomeDoPartido;
	}

	public void setNomeDoPartido(String nomeDoPartido) {
		this.nomeDoPartido = nomeDoPartido;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(String ideologia) {
		this.ideologia = ideologia;
	}

	public LocalDate getDataDeFundacao() {
		return dataDeFundacao;
	}

	public void setDataDeFundacao(LocalDate dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}

}

