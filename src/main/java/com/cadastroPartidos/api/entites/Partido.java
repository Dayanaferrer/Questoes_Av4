package com.cadastroPartidos.api.entites;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

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
	
	@Transient
	private Set<Associado> associados = new HashSet<>();
	
	public Partido() {}


	public Partido(Long id, String nome, String sigla, String ideologia, LocalDate dataDeFundacao,
			Set<Associado> associados) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.ideologia = ideologia;
		this.dataDeFundacao = dataDeFundacao;
		this.associados = associados;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Associado> getAssociados() {
		return associados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(associados, id, ideologia, sigla);
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
		return Objects.equals(associados, other.associados) && Objects.equals(id, other.id)
				&& Objects.equals(ideologia, other.ideologia) && Objects.equals(sigla, other.sigla);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
