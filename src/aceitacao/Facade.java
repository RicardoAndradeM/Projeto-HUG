package aceitacao;

import java.io.FileWriter;
import java.io.IOException;

import cadastro.ControllerCadastro;
import cadastro.exception.AtributoInvalidoException;
import cadastro.exception.DataNascimentoInvalidaException;
import cadastro.exception.EmailInvalidoException;
import cadastro.exception.HospedeNaoCadastradoException;
import cadastro.exception.NomeInvalidoException;
import cadastro.exception.QuartoNaoEncontradoException;
import recepcao.ControllerRecepcao;
import recepcao.exception.DiasInvalidoException;
import recepcao.exception.HospedeNaoHospedadoException;
import recepcao.exception.IndiceInvalidoException;
import recepcao.exception.NumeroQuartoInvalido;
import recepcao.exception.QuartoDesocupadoException;
import recepcao.exception.QuartoOcupadoException;
import recepcao.exception.TipoDeQuartoInvalido;
import restaurante.ControllerRestaurante;
import restaurante.exception.DescricaoInvalidaException;
import restaurante.exception.PratosInvalidoException;
import restaurante.exception.PrecoInvalidoException;

/** Classe responsavel por delegar metodos dos controlles
 * @author Ricardo Andrarde
 * @since 06/10/2016
 */
public class Facade {
	private ControllerCadastro cadastro;
	private ControllerRecepcao recepcao;
	private ControllerRestaurante restaurante;
	
	/**
	 * Construtor que inicializa os controles
	 */
	public Facade() {
		this.cadastro = new ControllerCadastro();
		this.recepcao = new ControllerRecepcao(cadastro);
		this.restaurante = new ControllerRestaurante(recepcao);
	}

	/**
	 *  Metodo que sera inplementado futuramente
	 */
	public void iniciaSistema(){
		
	}
	
	/** Metodo que cadastra um novo hospede no sistema.
	 * @param nome Nome do hospede
	 * @param email Email do hospede, que sera usado como ID/Identificador
	 * @param dataNascimento Data de nascimento do hospede no formato DD/MM/AAAA
	 * @return retorna o ID/Identificador do hospede, nesnte caso, o email
	 * @throws NomeInvalidoException Lanca exception caso o nome seja invalido
	 * @throws EmailInvalidoException Lanca exception caso o email seja invalido
	 * @throws DataNascimentoInvalidaException Lanca exception caso a data de nascimento seja invalida
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento)
			throws NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException {
		return cadastro.cadastraHospede(nome, email, dataNascimento);
	}

	/** Metodo que consulta uma informacao especifica do hospede
	 * @param id Email do hospede
	 * @param atributo Atributos que se deseja consultar
	 * @return Retorna o atributo desejado
	 * @throws HospedeNaoCadastradoException Lanca exception caso o hospede nao seja encontrado
	 * @throws AtributoInvalidoException Lanca exception caso atributo solicitado nao seja encontrado
	 */
	public String getInfoHospede(String id, String atributo)
			throws HospedeNaoCadastradoException, AtributoInvalidoException {
		return cadastro.getInfoHospede(id, atributo);
	}

	/** Metodo que atualiza uma informacao especifica do  hospede
	 * @param id Email do hospede
	 * @param atributo Atributo a ser alterado
	 * @param valor Novo valor do atributo selecionado
	 * @throws HospedeNaoCadastradoException Lanca exception caso o hospede nao seja encontrado
	 * @throws NomeInvalidoException Lanca exception caso o nome seja invalido
	 * @throws EmailInvalidoException Lanca exception caso o email seja invalido
	 * @throws DataNascimentoInvalidaException Lanca exception caso a data de nascimento seja invalida
	 * @throws AtributoInvalidoException Lanca exception caso atributo selecionado nao seja encontrado
	 */
	public void atualizaCadastro(String id, String atributo, String valor) throws HospedeNaoCadastradoException,
			NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException, AtributoInvalidoException {
		cadastro.atualizaCadastro(id, atributo, valor);
	}

	/** Meotodo que remove um hospde do sistema
	 * @param id Email do hospede a ser removido
	 * @throws EmailInvalidoException Exception lancada quando email passado eh invaldo
	 * @throws HospedeNaoCadastradoException Exception lancada quando se tenta remover um hospede que nao existe no sistema
	 */
	public void removeHospede(String id) throws EmailInvalidoException, HospedeNaoCadastradoException {
		cadastro.removeHospede(id);
	}
	

	/** Faz checin do hospede no sistema
	 * @param email Email do hospde
	 * @param dias Dias que fica hospedado
	 * @param quarto Numero do quarto
	 * @param tipoQuarto Tipo do quarto
	 * @throws DiasInvalidoException Lanca exception caso quantidade de dias seja invalido
	 * @throws NumeroQuartoInvalido Lanca exception caso numero do quarto seja invalido
	 * @throws TipoDeQuartoInvalido Lanca exception caso nome todo tipo de quart seja invalido
	 * @throws QuartoOcupadoException Lanca exception caso o quarto esteja ocupado
	 * @throws cadastro.exception.QuartoOcupadoException Lanca exception o quarto esteja ocupado
	 * @throws HospedeNaoCadastradoException Lanca exception caso email passado nao esteja cadastrado no sitema 
	 * @throws EmailInvalidoException Lanca exception caso email passado seja invalido
	 */
	public void realizaCheckin(String email, int dias, String quarto, String tipoQuarto)
			throws DiasInvalidoException, NumeroQuartoInvalido, TipoDeQuartoInvalido, QuartoOcupadoException,
			cadastro.exception.QuartoOcupadoException, HospedeNaoCadastradoException, EmailInvalidoException {
		recepcao.realizaCheckin(email, dias, quarto, tipoQuarto);
	}

	/** Metodo que realiza o checkou do hospede no sistema
	 * @param email Email do hospede
	 * @param quarto Quarto que deseja fazer checkout
	 * @return retorna o preco da estadia naquele quarto
	 * @throws QuartoNaoEncontradoException Lanca exception caso quarto passado nao seja encontrado
	 * @throws HospedeNaoCadastradoException Lanca exception caso caso hospede nao esteja cadastrado no sistema
	 * @throws EmailInvalidoException Lanca exception caso email passado seja invalido
	 * @throws QuartoDesocupadoException lanca exception caso quarto passado nao esteja sendo ocupado pelo hospede
	 * @throws NumeroQuartoInvalido Lanca exception caso nome de quarto seja invalido
	 */
	public String realizaCheckout(String email, String quarto) throws QuartoNaoEncontradoException,
			HospedeNaoCadastradoException, EmailInvalidoException, QuartoDesocupadoException, NumeroQuartoInvalido {
		return recepcao.realizaCheckout(email, quarto);
	}

	/** Metodo que exibe informaçoes de hospedagens de hospedes
	 * @param email Email do hospede
	 * @param atributo Atributo a ser acessado
	 * @return Retonar a informacao solicitada
	 * @throws HospedeNaoHospedadoException Lanca Exception caso o hospede nao esteja cadastrado no sistema
	 * @throws HospedeNaoCadastradoException Lanca exception caso o hospede nao esteja cadastrado no sistema
	 * @throws AtributoInvalidoException Lanca exception caso atributo solicitado seja invalido
	 * @throws EmailInvalidoException Lanca exception caso email seja invalido
	 */
	public String getInfoHospedagem(String email, String atributo) throws HospedeNaoCadastradoException, AtributoInvalidoException, HospedeNaoHospedadoException, EmailInvalidoException {
		return recepcao.getInfoHospedagem(email, atributo);
	}

	/** Metodo que consulta informacoes sobre transacoes
	 * @param atributo Atributos Solicitado
	 * @return Retorna a informacao solicitada
	 */
	public String consultaTransacoes(String atributo) {
		return recepcao.consultaTransacoes(atributo);
	}

	/** Metodo que consulta informacoes sobre transacoes
	 * @param atributo Atributos Solicitado
	 * @param indice Indice a se pesquisar
	 * @return Retorna a informacao solicitada
	 * @throws IndiceInvalidoException Lanca exception caso indice seja invalido
	 */
	public String consultaTransacoes(String atributo, int indice) throws IndiceInvalidoException {
		return recepcao.consultaTransacoes(atributo, indice);
	}
	
	/** Metodo que cadastra novos pratos no  sistema
	 * @param nome Nome do prato
	 * @param preco Preco do prato
	 * @param descricao Breve descricao do Prato
	 * @throws restaurante.exception.NomeInvalidoException Lanca exception caso nome seja invalido
	 * @throws PrecoInvalidoException Lanca exception caso preco seja invalido
	 * @throws DescricaoInvalidaException Lanca exception caso descricao seja invalido
	 */
	public void cadastraPrato(String nome, double preco, String descricao)
			throws restaurante.exception.NomeInvalidoException, PrecoInvalidoException, DescricaoInvalidaException {
		restaurante.cadastraPrato(nome, preco, descricao);
	}

	/** Metodo que cadastra refeicoes no sistema
	 * @param nome Nome do prato
	 * @param descricao Descricao da refeicao
	 * @param componentes Pratos que compoem a refeicao
	 * @throws restaurante.exception.NomeInvalidoException Lanca exception caso nome seja invalido
	 * @throws DescricaoInvalidaException Lanca exception caso descricao seja invalida
	 * @throws PratosInvalidoException Lanca exception caso pratos seja invalido
	 */
	public void cadastraRefeicao(String nome, String descricao, String componentes)
			throws restaurante.exception.NomeInvalidoException, DescricaoInvalidaException, PratosInvalidoException {
		restaurante.cadastraRefeicao(nome, descricao, componentes);
	}
	
	/** metodo que consulta informacao de restaurante
	 * @param nome Nome do prato/refeicao
	 * @param atributo atributo desejado
	 * @return informacao solicitada
	 * @throws restaurante.exception.NomeInvalidoException Lanca exeception caso nome seja invalido
	 */
	public String consultaRestaurante(String nome, String atributo) throws restaurante.exception.NomeInvalidoException {
		return restaurante.consultaRestaurante(nome, atributo);
	}

	// documentar
	
	public void ordenaMenu(String tipoOrdenacao) {
		restaurante.ordenaMenu(tipoOrdenacao);
	}
	
	public String consultaMenuRestaurante() {
		return restaurante.consultaMenuRestaurante();
	}
		
	public String realizaPedido(String email, String nome) throws HospedeNaoCadastradoException, AtributoInvalidoException {
		return restaurante.realizaPedido(email, nome);
	}

	public double convertePontos(String id, double valor) {
		return cadastro.convertePontos(id, valor);
	}

	/**
	 * Metodo que seja implmentado futuramente
	 * @throws IOException Lanca exception caso haja erro na manipulacao de arquivos
	 */
	public void fechaSistema() throws IOException{
		String relatorioCadastro = this.cadastro.toString();
		String relatorioRecepcao = this.recepcao.toString();
		String relatorioRestaurante = this.restaurante.toString();
		String separador = "======================================================\n";
		String relatorioFinal = separador+relatorioCadastro+separador+relatorioRestaurante+separador+relatorioRecepcao;
		
		FileWriter out = null;
		
		try {
			out = new FileWriter("arquivos_sistema/relatorios/cad_hospedes.txt");
			out.write(relatorioCadastro);
			out.close();
			out = new FileWriter("arquivos_sistema/relatorios/cad_restaurante.txt");
			out.write(relatorioRestaurante);
			out.close();
			out = new FileWriter("arquivos_sistema/relatorios/cad_transacoes.txt");
			out.write(relatorioRecepcao);
			out.close();
			out = new FileWriter("arquivos_sistema/relatorios/hotel_principal.txt");
			out.write(relatorioFinal);
			out.close();
			
		} finally {
			out.close();
		}
	}

}
