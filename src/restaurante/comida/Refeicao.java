package restaurante.comida;


/** Classe que representa um refeicao
 * @author Ricardo Andrade
 * @since 18/09/16
 */
public class Refeicao {
	private String nome;
	private String descricao;
	private String[] pratos;
	
	/** Cria uma nova refeicao
	 * @param nome Nome da Refeicao
	 * @param descricao Desricao da Refeicao
	 * @param pratos Pratos que copoem a refeicao
	 */
	public Refeicao(String nome, String descricao, String[] pratos) {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.pratos = pratos;
	}

	/**
	 * @return retorna o nome da Refeicao
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome Novo nome da Refeicao 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return Retorna a descricao do refeicao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao Nova descricao do prato
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/** Metodo que atualiza um prato da refeicao
	 * @param indice Indice a ser trocado
	 * @param prato Novo prato
	 */
	public void atualizaPrato(int indice, String prato){
		this.pratos[indice] = prato;
	}
}
