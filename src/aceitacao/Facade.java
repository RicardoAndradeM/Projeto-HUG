package aceitacao;

import cadastro.ControllerCadastro;
import cadastro.exception.AtributoInvalidoException;
import cadastro.exception.DataNascimentoInvalidaException;
import cadastro.exception.EmailInvalidoException;
import cadastro.exception.HospedeNaoCadastradoException;
import cadastro.exception.NomeInvalidoException;

/** Classe responsavel por delegar metodos dos controlles
 * @author Ricardo Andrarde
 * @since 06/10/2016
 */
public class Facade {
	private ControllerCadastro cadastro;
	
	/**
	 * Construtor que inicializa os controles
	 */
	public Facade() {
		this.cadastro = new ControllerCadastro();
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
	
	/**
	 * Metodo que seja implmentado futuramente
	 */
	public void fechaSistema(){
		
	}
}
