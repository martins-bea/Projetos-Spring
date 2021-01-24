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
@Table(name = "tb_poder") //Altera o nome da tabela. Nesse caso de "Poder" para "tb_poder".
public class Poder 
{
	@Id //Define que o atributo abaixo é a chave primaria na tabela.
	private String nomePoder;
	
	@NotNull
	private String categoria;
	
	@NotNull
	private boolean utilidade;
	
	@OneToMany (mappedBy = "superpoder", cascade = CascadeType.ALL) //Um poder para varios mutantes.
	@JsonIgnoreProperties("superpoder")
	private List<xmenformulario> infomutantes; //Atributo do tipo List que chamamos de infomutantes, e mostra todos os atributos de xmenformulario

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

	public boolean isUtilidade() {
		return utilidade;
	}

	public void setUtilidade(boolean utilidade) {
		this.utilidade = utilidade;
	}

	public List<xmenformulario> getInfomutantes() {
		return infomutantes;
	}

	public void setInfomutantes(List<xmenformulario> infomutantes) {
		this.infomutantes = infomutantes;
	}
		
}
