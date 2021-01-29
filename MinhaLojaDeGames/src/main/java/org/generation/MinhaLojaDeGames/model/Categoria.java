package org.generation.MinhaLojaDeGames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table (name="Categoria")

public class Categoria {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigo;
	
	@NotNull
	@Size(min=2,max=100)
	private String nomeCategoria;
	
	@NotNull
	@Size(min=5,max=500)
	private String descricao;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;


	public long getId() {
		return codigo;
	}

	public void setId(long codigo) {
		this.codigo = codigo;
	}

	public String getnomeCategoria() {
		return nomeCategoria;
	}

	public void setnomeCategoria(String titulo) {
		this.nomeCategoria = titulo;
	}

	public String getdescricao() {
		return descricao;
	}

	public void setdescricao(String texto) {
		this.descricao = texto;
	}

		
}



