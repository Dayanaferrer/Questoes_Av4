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
public class Associado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	
	 private String nome;
	 
	 private String cargoPolitico;
	 
	 @JsonFormat(pattern = "dd/MM/yyyy")
	 private LocalDate dataDeNascimento;
	 
	 private String sexo;
	 
	 @Transient
	 private Set<Partido> partidos = new HashSet<>();
	 
	 
	 public Associado () {
		 
	 }
	 
	public Associado(Long id, String nome, String cargoPolitico, LocalDate dataDeNascimento, String sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargoPolitico = cargoPolitico;
		this.dataDeNascimento = dataDeNascimento;
		this.sexo = sexo;
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

	public String getCargoPolitico() {
		return cargoPolitico;
	}

	public void setCargoPolitico(String cargoPolitico) {
		this.cargoPolitico = cargoPolitico;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Set<Partido> getPartido(){
		return partidos;
	}
	 

	@Override
	public int hashCode() {
		return Objects.hash(cargoPolitico, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associado other = (Associado) obj;
		return Objects.equals(cargoPolitico, other.cargoPolitico) && Objects.equals(id, other.id);
	}

}
