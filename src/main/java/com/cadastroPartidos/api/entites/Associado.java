package com.cadastroPartidos.api.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Associado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	 private String nome;
	 private String cargoPolitico;
	 private Date dataDeNascimento;
	 private String sexo;
	 
	 public Associado () {
		 
	 }

	public Associado(Long id, String nome, String cargoPolitico, Date dataDeNascimento, String sexo) {
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

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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
