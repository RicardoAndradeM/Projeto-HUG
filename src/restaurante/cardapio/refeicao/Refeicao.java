package restaurante.cardapio.refeicao;

import java.util.Arrays;

import restaurante.cardapio.Comestivel;
import restaurante.cardapio.prato.Prato;

/** Classe que representa um refeicao
 * @author Ricardo Andrade
 * @since 18/09/16
 */
public class Refeicao implements Comestivel {
	private String nome;
	private String descricao;
	private Prato[] pratos;
	
	/** Cria uma nova refeicao
	 * @param nome Nome da Refeicao
	 * @param descricao Desricao da Refeicao
	 * @param pratos Pratos que copoem a refeicao
	 */
	public Refeicao(String nome, String descricao, Prato[] pratos) {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.pratos = pratos;
	}

	@Override
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome Novo nome da Refeicao 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getDescricao() {
		StringBuilder pratosASerServdos = new StringBuilder();
		for (int i = 0; i < pratos.length; i++) {
			pratosASerServdos.append(String.format(" (%d) ", i +1));
			pratosASerServdos.append(this.pratos[i].getNome());
			pratosASerServdos.append(",");
		}
		return String.format("%s Serao servidos:%s.", this.descricao, pratosASerServdos.toString().substring(0, pratosASerServdos.length() -1));
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
	public void atualizaPrato(int indice, Prato prato){
		this.pratos[indice] = prato;
	}

	@Override
	public double getPreco() {
		double total = 0;
		for (Prato prato : pratos) {
			total += prato.getPreco();
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
		return String.format("%s(R$%.2f) - %s",this.nome, this.getPreco(), this.getDescricao());
	}
}
