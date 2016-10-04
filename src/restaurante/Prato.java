package restaurante;

import exceptions.valordeatributoinvalido.NomeInvalidoException;
import exceptions.valordeatributoinvalido.PrecoInvalidoException;
import exceptions.valordeatributoinvalido.ValorDeAtributoInvalidoException;

/**
 * representa um prato
 * @since 19/09/16
 *
 */
public class Prato {
	String nome;
	double preco;
	String descricao;
	
	/**
	 * 
	 * @param nome do prato
	 * @param preco do prato
	 * @param descricao do praequalsto
	 * @throws NomeInvalidoException  caso nome seja invalido
	 * @throws PrecoInvalidoException  caso preco seja invalido
	 * @throws ValorDeAtributoInvalidoException  caso valor do atributo seja invalido
	 */
	public Prato(String nome, double preco,	String descricao) throws NomeInvalidoException, PrecoInvalidoException, ValorDeAtributoInvalidoException {
		verificaNome(nome);
		verificaPreco(preco);
		verificaDescricao(descricao);
		
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}

	private void verificaDescricao(String descricao) throws ValorDeAtributoInvalidoException {
		if (descricao==null||descricao.trim().equals("")){
			throw new ValorDeAtributoInvalidoException("Descricao do prato esta vazia.");
		}
	}

	private void verificaPreco(double preco) throws PrecoInvalidoException {
		if (preco<= 0){
			throw new PrecoInvalidoException("Preco do prato eh invalido.");
		}
	}

	private void verificaNome(String nome) throws NomeInvalidoException {
		if (nome==null || nome.trim().equals("")){
			throw new NomeInvalidoException("Nome do prato esta vazio.");
		}
	}
	
	/**
	 * 
	 * @return nome do prato
	 */
	public String getNome() {
		return this.nome;
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
	 * @param preco do prato
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
	 * @param descricao do prato
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
