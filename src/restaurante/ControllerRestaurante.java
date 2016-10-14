package restaurante;

import java.util.ArrayList;
import java.util.HashMap;

import cadastro.exception.AtributoInvalidoException;
import cadastro.exception.HospedeNaoCadastradoException;
import recepcao.ControllerRecepcao;
import restaurante.cardapio.Comestivel;
import restaurante.cardapio.EstrategiaOrdenacaoCadapio;
import restaurante.cardapio.NomeCardapioComparator;
import restaurante.cardapio.prato.Prato;
import restaurante.cardapio.prato.VerificadorDePrato;
import restaurante.cardapio.refeicao.Refeicao;
import restaurante.cardapio.refeicao.VerificadorDeRefeicao;
import restaurante.exception.DescricaoInvalidaException;
import restaurante.exception.NomeInvalidoException;
import restaurante.exception.PratosInvalidoException;
import restaurante.exception.PrecoInvalidoException;

/** Classe que controla o restalrante do hotel
 * @author Ricardo Andrade
 * @since 12/10/2016
 */
public class ControllerRestaurante {
	private HashMap<String, Comestivel> cardapio;
	private VerificadorDePrato verificadorDePrato;
	private VerificadorDeRefeicao verificadorDeRefeicao;
	private EstrategiaOrdenacaoCadapio estrategiaOrdenacao;
	private ArrayList<Comestivel> itensDeCardapio;
	private ControllerRecepcao recepcao;
	
	/**
	 * Cria um novo controler de Restaurante
	 */
	public ControllerRestaurante(ControllerRecepcao recepcao) {
		this.cardapio = new HashMap<String, Comestivel>();
		this.verificadorDePrato = new VerificadorDePrato();
		this.verificadorDeRefeicao = new VerificadorDeRefeicao();
		this.itensDeCardapio = new ArrayList<Comestivel>();
		this.recepcao = recepcao;
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
		
		this.cardapio.put(nome, new Prato(nome, preco, descricao));
		this.itensDeCardapio.add(new Prato(nome, preco, descricao));
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
		this.verificadorDeRefeicao.verificaPratos(componentes, this.cardapio);
		Prato[] pratosDeRefeicao = new Prato[componentes.split(";").length];
		String[] nomeDosPratos = componentes.split(";");
		for (int i = 0; i < componentes.split(";").length; i++) {
			pratosDeRefeicao[i] = (Prato) this.cardapio.get(nomeDosPratos[i]);
		}
		this.cardapio.put(nome, new Refeicao(nome, descricao, pratosDeRefeicao));
		this.itensDeCardapio.add(new Refeicao(nome, descricao, pratosDeRefeicao));
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
			if(this.cardapio.containsKey(nome)){
				return String.format("R$%.2f",this.cardapio.get(nome).getPreco());
			}

		case "Descricao":
			if(this.cardapio.containsKey(nome)){
				return this.cardapio.get(nome).getDescricao();
			}
		}
		return null;
	}
	
	// documentar
	
	public void ordenaMenu(String tipoOrdenacao){
		if(tipoOrdenacao.equals("Nome")){
			this.estrategiaOrdenacao = new NomeCardapioComparator();
		}
		this.estrategiaOrdenacao = new NomeCardapioComparator();
	}
	
	public String consultaMenuRestaurante(){
		StringBuilder lista = new StringBuilder();
		if(estrategiaOrdenacao == null){
			for (Comestivel itemDoCardapio : itensDeCardapio){
				lista.append(itemDoCardapio.getNome());
				lista.append(";");
			}
		} else {
			itensDeCardapio.sort(estrategiaOrdenacao);
			for (Comestivel itemDoCardapio : itensDeCardapio){
				lista.append(itemDoCardapio.getNome());
				lista.append(";");
			}
		}
		return lista.toString().substring(0, lista.length() -1);
	}
	
	public String realizaPedido(String email, String nome) throws HospedeNaoCadastradoException, AtributoInvalidoException{
		Comestivel pedido = cardapio.get(nome);
		this.recepcao.registraTransacao(email, pedido.getNome(), pedido.getPreco());
		return String.format("R$%.2f", pedido.getPreco());
	}
}
