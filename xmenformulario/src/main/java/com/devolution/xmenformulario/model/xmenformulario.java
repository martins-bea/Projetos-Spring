package com.devolution.xmenformulario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


//@ = Anotação
@Entity //Define que a public class abaixo (no caso xmenformulario) é uma tabela (data base)
//@Table Permite alterar o nome da tabela. Ex.: xmenformulario para mutantes
public class xmenformulario 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@NotNull
	@Size (min = 3, max = 40, message = "Número de caracteres inválido.")
	private String nome;
	
	@NotNull
	@Size (min = 3, max = 40, message = "Número de caracteres inválido.")
	private String origem;
	
	@NotNull
	@Size  (min = 3, max = 40, message = "Número de caracteres inválido.")
	private String identidade;	
	
	@NotNull
	private boolean ameaca;
	
	@ManyToOne 
	@JsonIgnoreProperties("infomutantes")  
	private Poder superpoder;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getidentidade() {
		return identidade;
	}

	public void setidentidade(String identidade) {
		this.identidade = identidade;
	}

	public boolean isAmeaca() {
		return ameaca;
	}

	public void setAmeaca(boolean ameaca) {
		this.ameaca = ameaca;
	}

	public Poder getSuperpoder() {
		return superpoder;
	}

	public void setSuperpoder(Poder superpoder) {
		this.superpoder = superpoder;
	}

}
