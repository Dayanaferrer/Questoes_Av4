package com.cadastroPartidos.api.entites;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cadastroPartidos.api.controller.dto.AssociadoComPartidoDto;
import com.cadastroPartidos.api.entites.enums.CargoPolitico;
import com.cadastroPartidos.api.entites.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Associado {
	
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;	
	
	 private String nome;
	 	 
	 private CargoPolitico cargoPolitico;
	 
	 @JsonFormat(pattern = "dd/MM/yyyy")
	 private LocalDate dataDeNascimento;
	 
	 private Sexo sexo;

	 public Associado() {}
	  
	
	public Associado(Long id, String nome, CargoPolitico cargoPolitico, LocalDate dataDeNascimento, Sexo sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargoPolitico = cargoPolitico;
		this.dataDeNascimento = dataDeNascimento;
		this.sexo = sexo;
	}


	public Associado(Object object, String string, String string2, LocalDateTime parse, String string3) {
		// TODO Auto-generated constructor stub
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

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	 
	public AssociadoComPartidoDto converter(Associado associado, Partido partido) {
		return new AssociadoComPartidoDto(associado, partido);
	}
	 
	 
	 


}
