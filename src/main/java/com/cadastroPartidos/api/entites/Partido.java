package com.cadastroPartidos.api.entites;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.cadastroPartidos.api.controller.dto.PartidoDto;
import com.cadastroPartidos.api.entites.enums.Ideologia;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Partido  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nomeDoPartido;
	
	private String sigla;
	
	@Enumerated(EnumType.STRING)
	private Ideologia ideologia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeFundacao;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "tb_idPartido")
	private List<Associado> associados = new ArrayList<Associado>();
	
	public Partido() {}

	public Partido(PartidoDto partidoDto) {
		this.id = partidoDto.getId();
		this.nomeDoPartido = partidoDto.getNomeDoPartido();
		this.sigla = partidoDto.getSigla();
		this.ideologia = partidoDto.getIdeologia();
		this.dataDeFundacao = partidoDto.getDataDeFundacao();
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

	public Ideologia getIdeologia() {
		return ideologia;
	}

	public void setIdeologia(Ideologia ideologia) {
		this.ideologia = ideologia;
	}

	public LocalDate getDataDeFundacao() {
		return dataDeFundacao;
	}

	public void setDataDeFundacao(LocalDate dataDeFundacao) {
		this.dataDeFundacao = dataDeFundacao;
	}

	public List<Associado> getAssociado() {
		return associados;
	}

	public void setAssociados(List<Associado> associados) {
		this.associados = associados;
	}
	public List<Associado> getAssociados() {
		return associados;
	}
	public void addAssociado(Associado associado) {
		associados.add(associado);
	}
	public void removeAssociado(Associado associado) {
		associados.remove(associado);
	}
	
	public boolean procurarAssociado(Associado associado) {
		return associados.contains(associado);
	}
	
	public PartidoDto converter(Partido partido) {
		return new PartidoDto(partido);
	}


}


