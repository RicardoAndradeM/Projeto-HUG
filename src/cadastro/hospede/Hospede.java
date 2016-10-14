package cadastro.hospede;

import java.util.ArrayList;
import java.util.HashMap;

import cadastro.exception.QuartoNaoEncontradoException;
import cadastro.exception.QuartoOcupadoException;
import cadastro.hospede.cartaofidelidade.CartaoFidelidade;

/** Classe que representa um hospede
 * @author Ricardo Andrade
 * @since 30/09/2016
 */
public class Hospede {
	private String nome;
	private String email;
	private String dataNascimento;
	private HashMap<String, Double> chavesDoQuarto;
	private CartaoFidelidade cartao;
	
	public int getPontos() {
		return cartao.getPontos();
	}

	public void adicionaPontos(double valor) {
		cartao.adicionaPontos(valor);
	}

	public double aplicaDesconto(double valor) {
		return cartao.aplicaDesconto(valor);
	}

	public double convertePontos(double valor) {
		return cartao.convertePontos(valor);
	}

	/** 
	 * @param nome Nome do Hospede
	 * @param email Email do Hospede
	 * @param dataNascimento Data de Nascimento do Hospede
	 */
	public Hospede(String nome, String email, String dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.chavesDoQuarto = new HashMap<String, Double>();
		this.cartao = new CartaoFidelidade();
	}
	
	/** Quando o cliente faz o checkin no hostel ele recebe a chave do quarto,
	 * que serve para mapear o quarto na recepcao
	 * @param nome numero do quarto a ser ocupado pelo hospede
	 * @param preco preco total da estadia
	 * @throws QuartoOcupadoException Exception lancada quando hospede ja esta ocupando o quarto
	 */
	public void recebeChave(String nome, double preco) throws QuartoOcupadoException{
		if(this.chavesDoQuarto.containsKey(nome)){
			throw new QuartoOcupadoException("Erro ao Fazer checkin, hospede ja esta ocupando este quarto");
		}
		this.chavesDoQuarto.put(nome, preco);
	}
	
	/** Quando o cliente faz checkout do hotel ele entrega a chave
	 * @param nome numero do Quarto a ser desocupado
	 * @throws QuartoNaoEncontradoException Exception lancada quando o quarto nao for encontrado 
	 */
	public void removeChave(String nome) throws QuartoNaoEncontradoException{
		if(this.chavesDoQuarto.remove(nome) == null){
			throw new QuartoNaoEncontradoException("Erro ao Fazer checkout, quarto nao encontrado");
		}
	}
	
	/** Seve para ajudar a identificar em quais quartos o cliente esta hospedado
	 * @return Retorna as chaves que o hospede possui para mapear em quais quartos ele esta hospedados
	 */
	public ArrayList<String> getChaves(){
		return new ArrayList<String>(this.chavesDoQuarto.keySet());
	}
	
	/** Retorna a quantidade de dinheiro gato pelo hospede no hotel em hospedagem
	 * @return retorna o dinheiro gasto
	 */
	public double getDebito(){
		ArrayList<String> keys = new ArrayList<String>(this.chavesDoQuarto.keySet());
		double total = 0;
		for (String chave : keys) {
			total += this.chavesDoQuarto.get(chave);
		}
		return total;
	}

	/**
	 * @return retorna o nome do hospede
	 */
	public String getNome() {
		return nome;
	}

	/** 
	 * @param nome novo nome para o hospede
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return retorna o email do hospede
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email novo email para o hospede
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return retorna a data de nascimento do hospede
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento nova data de nascimento para o hospede	 */
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Hospede other = (Hospede) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.nome + " : " + this.email;
	}
}