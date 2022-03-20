package com.cadastroPartidos.api.entites;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.cadastroPartidos.api.controller.dto.AssociadoComPartidoDto;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Partido  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String sigla;
	private String ideologia;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeFundacao;
	
	
	public Partido() {}


	public Partido(Long id, String nome, String sigla, String ideologia, LocalDate dataDeFundacao) {
		super();
		this.id = id;
		this.nome = nome;
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


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
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
	
	public AssociadoComPartidoDto converter(Associado associado, Partido partido) {
		return new AssociadoComPartidoDto(associado, partido);
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(id, other.id);
	}

}


