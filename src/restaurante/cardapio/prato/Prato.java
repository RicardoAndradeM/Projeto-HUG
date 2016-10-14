package restaurante.cardapio.prato;

import restaurante.cardapio.Comestivel;

/** Classe que representa um prato do restaurante
 * @since 19/09/16
 * @author Ricardo Andrade
 */
public class Prato implements Comestivel {
	private String nome;
	private double preco;
	private String descricao;
	
	/**
	 * 
	 * @param nome Nome do prato
	 * @param preco Preco do prato
	 * @param descricao Descricao do prato
	 */
	public Prato(String nome, double preco,	String descricao){
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * @param nome Novo nome do prato
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public double getPreco() {
		return this.preco;
	}
	
	/**
	 * @param preco Preco do prato
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * @param descricao Descricao do prato
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("\nNome: %s Preco: R$%.2f\nDescricao: %s", this.nome, this.preco, this.descricao);
	}
}
