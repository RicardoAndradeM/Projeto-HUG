package restaurante;

import java.util.ArrayList;

import exceptions.valordeatributoinvalido.NomeDeAtributoInvalidoException;
import exceptions.valordeatributoinvalido.ValorDeAtributoInvalidoException;

public class Refeicao {
	private String nome;
	private String descricao;
	private ArrayList<Prato> pratos;
	
	
	/**
	 * 
	 * @param nome da refeicao
	 * @param descricao da refeicao
	 * @param primeiroPrato
	 * @param segundoPrato
	 * @param terceiroPrato
	 * @throws ValorDeAtributoInvalidoException 
	 */
	public Refeicao(String nome, String descricao, Prato primeiroPrato, Prato segundoPrato, Prato terceiroPrato) throws ValorDeAtributoInvalidoException {
		
		this.nome = nome;
		this.descricao = descricao;
		pratos = new ArrayList<Prato>();
		
		verificaNome(nome);
		verificaDescricao(descricao);
		
		verificaPrato(primeiroPrato);
		verificaPrato(segundoPrato);
		verificaPrato(terceiroPrato);
		
		pratos.add(primeiroPrato);
		pratos.add(segundoPrato);
		pratos.add(terceiroPrato);
	}

	private void verificaPrato(Prato primeiroPrato) throws ValorDeAtributoInvalidoException {
		if (primeiroPrato==null || !(primeiroPrato instanceof Prato)){
			throw new ValorDeAtributoInvalidoException("O prato indicado nao eh um prato valido");
		}
	}

	private void verificaDescricao(String descricao) throws NomeDeAtributoInvalidoException {
		if( descricao == null || descricao.equals("")){
			throw new NomeDeAtributoInvalidoException("Descricao invalida");
		}
	}

	private void verificaNome(String nome) throws NomeDeAtributoInvalidoException {
		if(nome == null|| nome.equals("")){
			throw new NomeDeAtributoInvalidoException("Nome invalido");
		}
	}
	
	/**
	 * 
	 * @param nome  da refeicao
	 * @param descricao da refeicao
	 * @param primeiroPrato
	 * @param segundoPrato
	 * @param terceiroPrato
	 * @param quartoPrato
	 * @throws NomeDeAtributoInvalidoException
	 */
	public Refeicao(String nome, String descricao, Prato primeiroPrato, Prato segundoPrato, Prato terceiroPrato, Prato quartoPrato) throws NomeDeAtributoInvalidoException {
		
		this.nome = nome;
		this.descricao = descricao;
		pratos = new ArrayList<Prato>();
		
		verificaNome(nome);
		verificaDescricao(descricao);
		pratos.add(primeiroPrato);
		pratos.add(segundoPrato);
		pratos.add(terceiroPrato);
		pratos.add(quartoPrato);
		this.nome = nome;
		this.descricao = descricao;
	}
	
	/**
	 * 
	 * @return valor do prato 
	 */
	public double getValor(){
		double valor = 0;
		for (Prato prato : pratos) {
			valor += prato.getPreco();
		}
		return valor - (valor*0.1);
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
	 * @return descricao do prato
	 */
	public String getDescricao() {
		return this.descricao;
	}
	
	/**
	 * 
	 * @param nome a ser atualizado
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * 
	 * @param descricao a ser atualizado
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	/**
	 * 
	 * @param posicaoPrato aonde quer ser inserido novo prato
	 * @param prato novo prato
	 */
	public void autualizaPrato(int posicaoPrato, Prato prato){
		pratos.add(posicaoPrato, prato);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pratos == null) ? 0 : pratos.hashCode());
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
		Refeicao other = (Refeicao) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pratos == null) {
			if (other.pratos != null)
				return false;
		} else if (!pratos.equals(other.pratos))
			return false;
		return true;
	}

}
