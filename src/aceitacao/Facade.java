package aceitacao;

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
import recepcao.exception.NumeroQuartoInvalido;
import recepcao.exception.QuartoDesocupadoException;
import recepcao.exception.QuartoOcupadoException;
import recepcao.exception.TipoDeQuartoInvalido;

/** Classe responsavel por delegar metodos dos controlles
 * @author Ricardo Andrarde
 * @since 06/10/2016
 */
public class Facade {
	private ControllerCadastro cadastro;
	private ControllerRecepcao recepcao;
	
	/**
	 * Construtor que inicializa os controles
	 */
	public Facade() {
		this.cadastro = new ControllerCadastro();
		this.recepcao = new ControllerRecepcao(cadastro);
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
	 */
	public String realizaCheckout(String email, String quarto) throws QuartoNaoEncontradoException,
			HospedeNaoCadastradoException, EmailInvalidoException, QuartoDesocupadoException {
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

	//documentar
	public String consultaTransacoe(String atributo) {
		return recepcao.consultaTransacoe(atributo);
	}

	public String consultaTransacoe(String atributo, int indice) {
		return recepcao.consultaTransacoe(atributo, indice);
	}

	/**
	 * Metodo que seja implmentado futuramente
	 */
	public void fechaSistema(){
		
	}
}
