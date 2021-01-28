package com.devolution.xmenformulario.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import javax.persistence.CascadeType;

@Entity
@Table(name = "tb_poder") 
public class Poder 
{
	@Id 
	private String nomePoder;
	
	@NotNull
	private String categoria;
	
	@OneToMany (mappedBy = "superpoder", cascade = CascadeType.ALL) 
	@JsonIgnoreProperties("superpoder")
	private List<xmenformulario> infomutantes; 
	
	public String getNomePoder() {
		return nomePoder;
	}

	public void setNomePoder(String nomePoder) {
		this.nomePoder = nomePoder;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public List<xmenformulario> getInfomutantes() {
		return infomutantes;
	}

	public void setInfomutantes(List<xmenformulario> infomutantes) {
		this.infomutantes = infomutantes;
	}
		
}
