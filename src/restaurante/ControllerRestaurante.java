package restaurante;

import java.util.ArrayList;
import java.util.HashMap;

import restaurante.comida.prato.Prato;
import restaurante.comida.prato.VerificadorDePrato;
import restaurante.comida.refeicao.Refeicao;
import restaurante.comida.refeicao.VerificadorDeRefeicao;
import restaurante.exception.DescricaoInvalidaException;
import restaurante.exception.NomeInvalidoException;
import restaurante.exception.PratosInvalidoException;
import restaurante.exception.PrecoInvalidoException;

/** Classe que controla o restalrante do hotel
 * @author Ricardo Andrade
 * @since 12/10/2016
 */
public class ControllerRestaurante {
	private HashMap<String, Prato> pratos;
	private HashMap<String, Refeicao> refeicoes;
	private VerificadorDePrato verificadorDePrato;
	private VerificadorDeRefeicao verificadorDeRefeicao;
	
	/**
	 * Cria um novo controler de Restaurante
	 */
	public ControllerRestaurante() {
		this.pratos = new HashMap<String, Prato>();
		this.refeicoes = new HashMap<String, Refeicao>();
		this.verificadorDePrato = new VerificadorDePrato();
		this.verificadorDeRefeicao = new VerificadorDeRefeicao();
	}
	
	/** Metodo que cadastra novos pratos no  sistema
	 * @param nome Nome do prato
	 * @param preco Preco do prato
	 * @param descricao Breve descricao do Prato
	 * @throws NomeInvalidoException Lanca exception caso nome seja invalido
	 * @throws PrecoInvalidoException Lanca exception caso preco seja invalido
	 * @throws DescricaoInvalidaException Lanca exception caso descricao seja invalido
	 */
	public void cadastraPrato(String nome, double preco, String descricao) throws NomeInvalidoException, PrecoInvalidoException, DescricaoInvalidaException{
		try {
			this.verificadorDePrato.verificaNome(nome);
		} catch (NomeInvalidoException e) {
			throw new NomeInvalidoException("Erro no cadastro do prato. " + e.getMessage());
		}
		try {
			this.verificadorDePrato.verificaPreco(preco);
		} catch (PrecoInvalidoException e) {
			throw new PrecoInvalidoException("Erro no cadastro do prato. " + e.getMessage());
		}
		try {
			this.verificadorDePrato.verificaDescricao(descricao);
		} catch (DescricaoInvalidaException e) {
			throw new DescricaoInvalidaException("Erro no cadastro do prato. " + e.getMessage());
		}
		
		this.pratos.put(nome, new Prato(nome, preco, descricao));
	}
	
	/** Metodo que cadastra refeicoes no sistema
	 * @param nome Nome do prato
	 * @param descricao Descricao da refeicao
	 * @param componentes Pratos que compoem a refeicao
	 * @throws NomeInvalidoException Lanca exception caso nome seja invalido
	 * @throws DescricaoInvalidaException Lanca exception caso descricao seja invalida
	 * @throws PratosInvalidoException Lanca exception caso pratos seja invalido
	 */
	public void cadastraRefeicao(String nome, String descricao, String componentes) throws NomeInvalidoException, DescricaoInvalidaException, PratosInvalidoException{
		try {
			this.verificadorDeRefeicao.verificaNome(nome);
		} catch (NomeInvalidoException e) {
			throw new NomeInvalidoException("Erro no cadastro de refeicao. " +  e.getMessage());
		}
		try {
			this.verificadorDeRefeicao.verificaDescricao(descricao);
		} catch (DescricaoInvalidaException e) {
			throw new DescricaoInvalidaException("Erro no cadastro de refeicao. " +  e.getMessage());
		}
		this.verificadorDeRefeicao.verificaPratos(componentes, new ArrayList<String>(pratos.keySet()));
		String[] pratosDeRefeicao = componentes.split(";");
		
		this.refeicoes.put(nome, new Refeicao(nome, descricao, pratosDeRefeicao));
	}
	
	/** metodo que consulta informacao de restaurante
	 * @param nome Nome do prato/refeicao
	 * @param atributo atributo desejado
	 * @return informacao solicitada
	 * @throws NomeInvalidoException Lanca exeception caso nome seja invalido
	 */
	public String consultaRestaurante(String nome, String atributo) throws NomeInvalidoException{
		try {
			this.verificadorDePrato.verificaNome(nome);
		} catch (NomeInvalidoException e) {
			throw new NomeInvalidoException("Erro na consulta do restaurante. " + e.getMessage());
		}
		switch (atributo) {
		case "Preco":
			if(this.pratos.containsKey(nome)){
				return String.format("R$%.2f",this.pratos.get(nome).getPreco());
			}
			return String.format("R$%.2f",this.refeicoes.get(nome).getPreco(pratos));
			
		case "Descricao":
			if(this.pratos.containsKey(nome)){
				return this.pratos.get(nome).getDescricao();
			}
			return this.refeicoes.get(nome).toString();
		}
		return null;
	}
}
