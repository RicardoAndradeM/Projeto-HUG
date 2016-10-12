package restaurante.comida.refeicao;

import java.util.Arrays;
import java.util.HashMap;

import restaurante.comida.prato.Prato;

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
	
	/** Retorna o preco de uma refeicao
	 * @param pratosDoRestaurante Pratos do Restaurante atualizado para verificar o precos
	 * @return retonar o preco da refeicao
	 */
	public double getPreco(HashMap<String,Prato> pratosDoRestaurante) {
		double total = 0;
		for (String prato : this.pratos) {
			total += pratosDoRestaurante.get(prato).getPreco();
		}
		return total - total*(10/100.0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Arrays.hashCode(pratos);
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
		if (!Arrays.equals(pratos, other.pratos))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder pratosASerServdos = new StringBuilder();
		for (int i = 0; i < pratos.length; i++) {
			pratosASerServdos.append(String.format(" (%d) ", i +1));
			pratosASerServdos.append(this.pratos[i]);
			pratosASerServdos.append(",");
		}
		return String.format("%s Serao servidos:%s.", this.getDescricao(), pratosASerServdos.toString().substring(0, pratosASerServdos.length() -1));
	}
}
