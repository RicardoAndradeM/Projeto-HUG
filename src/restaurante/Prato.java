package restaurante;

public class Prato {
	String nome;
	double preco;
	String descricao;
	
	/**
	 * 
	 * @param nome do prato
	 * @param preco do prato
	 * @param descricao do prato
	 */
	public Prato(String nome, double preco,	String descricao) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	/**
	 * 
	 * @return nome do prato
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * 
	 * @param nome novo nome do prato
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * 
	 * @return preco do prato
	 */
	public double getPreco() {
		return preco;
	}
	
	/**
	 * 
	 * @param novo preco do prato
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * 
	 * @return descricao do prato
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * 
	 * @param nova descricao do prato
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
