package org.generation.farmacia.model;
	

	
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.validation.constraints.NotNull;
	import javax.validation.constraints.Size;
	
	
	//inserir anotações

	@Entity
	@Table (name="Produto")

public class Produto {
	
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long codigo;
		
		@NotNull
		@Size(min=5,max=100)
		private String produto;
		
		@NotNull
		@Size(min=1,max=500)
		private String descricao;
		
		@NotNull
		private int valor;

		public long getCodigo() {
			return codigo;
		}

		public void setCodigo(long codigo) {
			this.codigo = codigo;
		}

		public String getProduto() {
			return produto;
		}

		public void setProduto(String produto) {
			this.produto = produto;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public int getValor() {
			return valor;
		}

		public void setValor(int valor) {
			this.valor = valor;
		}
		
	
		
	}

