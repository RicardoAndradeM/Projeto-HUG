package restaurante.comida.prato;

/** Classe que representa um prato do restaurante
 * @since 19/09/16
 * @author Ricardo Andrade
 */
public class Prato {
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
	
	/**
	 * @return Nome do prato
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * @param nome Novo nome do prato
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return Preco do prato
	 */
	public double getPreco() {
		return preco;
	}
	
	/**
	 * @param Preco do prato
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * @return Descricao do prato
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * @param Descricao do prato
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
		return String.format("%s(R$%.2f) - %s", this.nome, this.preco, this.descricao);
	}
}
