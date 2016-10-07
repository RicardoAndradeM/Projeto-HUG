package cadastro;

import java.util.HashMap;
import java.util.Set;

import cadastro.componentes.FactoryDeHospedes;
import cadastro.componentes.VerificadorDeHospede;
import cadastro.exception.AtributoInvalidoException;
import cadastro.exception.DataNascimentoInvalidaException;
import cadastro.exception.EmailInvalidoException;
import cadastro.exception.HospedeNaoCadastradoException;
import cadastro.exception.NomeInvalidoException;

/** Classe responsavel por cadastrar, armazenar, gerenciar e remover hospedes
 * @author Ricardo Andrade
 * @since 06/10/2016
 */
public class ControllerCadastro {
	private HashMap<String, Hospede> hospedes;
	private FactoryDeHospedes factoryDeHospedes;
	private VerificadorDeHospede verificadorDeHospede;
	
	/**
	 *  Construtor que inicia os atributos
	 */
	public ControllerCadastro() {
		this.hospedes = new HashMap<String, Hospede>();
		this.factoryDeHospedes = new FactoryDeHospedes();
		this.verificadorDeHospede = new VerificadorDeHospede();
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
	public String cadastraHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException{
		try {
			this.verificadorDeHospede.verificaNome(nome);
		} catch (NomeInvalidoException e) {
			throw new NomeInvalidoException("Erro no cadastro de Hospede. " + e.getMessage());
		}
		try {
			this.verificadorDeHospede.verificaEmail(email);
		} catch (EmailInvalidoException e) {
			throw new EmailInvalidoException("Erro no cadastro de Hospede. " + e.getMessage());
		}
		try {
			this.verificadorDeHospede.verificaDataNascimento(dataNascimento);
		} catch (DataNascimentoInvalidaException e) {
			throw new DataNascimentoInvalidaException("Erro no cadastro de Hospede. " + e.getMessage());
		}
		this.hospedes.put(email, this.factoryDeHospedes.criaHospede(nome, email, dataNascimento));
		return email;
	}
	
	/** Metodo que consulta uma informacao especifica do hospede
	 * @param id Email do hospede
	 * @param atributo Atributos que se deseja consultar
	 * @return Retorna o atributo desejado
	 * @throws HospedeNaoCadastradoException Lanca exception caso o hospede nao seja encontrado
	 * @throws AtributoInvalidoException Lanca exception caso atributo solicitado nao seja encontrado
	 */
	public String getInfoHospede(String id, String atributo) throws HospedeNaoCadastradoException, AtributoInvalidoException{
		if(!this.hospedes.containsKey(id)){
			throw new HospedeNaoCadastradoException(String.format("Erro na consulta de hospede. Hospede de email %s nao foi cadastrado(a).", id));
		}
		switch (atributo) {
		case "Nome":
			return this.hospedes.get(id).getNome();		
		
		case "Email":
			return this.hospedes.get(id).getEmail();
		
		case "Data de Nascimento":
			return this.hospedes.get(id).getDataNascimento();
			
		default:
			throw new AtributoInvalidoException("Erro na consulta de hospede. Atributo solicitado nao encontrado.");
		}
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
	public void atualizaCadastro(String id, String atributo, String valor) throws HospedeNaoCadastradoException, NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException, AtributoInvalidoException{
		if(!this.hospedes.containsKey(id)){
			throw new HospedeNaoCadastradoException(String.format("Erro na atualizacao do cadastro de Hospede. Hospede de email %s nao foi cadastrado(a).", id));
		}
		switch (atributo) {
		case "Nome":
			try {
				this.verificadorDeHospede.verificaNome(valor);
			} catch (NomeInvalidoException e) {
				throw new NomeInvalidoException("Erro na atualizacao do cadastro de Hospede. " + e.getMessage());
			}
			this.hospedes.get(id).setNome(valor);
			break;
		
		case "Email":
			try {
				this.verificadorDeHospede.verificaEmail(valor);
			} catch (EmailInvalidoException e) {
				throw new EmailInvalidoException("Erro na atualizacao do cadastro de Hospede. " + e.getMessage());
			}
			this.hospedes.get(id).setEmail(valor);
			/* Alem de atualizar o hospede, tambem eh nescesario atualizar a chave usada para mapea-lo */
			Hospede hospede = this.hospedes.remove(id);
			this.hospedes.put(hospede.getEmail(), hospede);
			break;
		
		case "Data de Nascimento":
			try {
				this.verificadorDeHospede.verificaDataNascimento(valor);
			} catch (DataNascimentoInvalidaException e) {
				throw new DataNascimentoInvalidaException("Erro na atualizacao do cadastro de Hospede. " + e.getMessage());
			}
			this.hospedes.get(id).setDataNascimento(valor);
			break;
			
		default:
			throw new AtributoInvalidoException("Erro na consulta de hospede. Atributo solicitado nao encontrado.");
		}
	}
	
	/** Meotodo que remove um hospde do sistema
	 * @param id Email do hospede a ser removido
	 * @throws EmailInvalidoException Exception lancada quando email passado eh invaldo
	 * @throws HospedeNaoCadastradoException Exception lancada quando se tenta remover um hospede que nao existe no sistema
	 */
	public void removeHospede(String id) throws EmailInvalidoException, HospedeNaoCadastradoException{
		try {
			this.verificadorDeHospede.verificaEmail(id);
		} catch (EmailInvalidoException e) {
			throw new EmailInvalidoException("Erro na remocao do Hospede. Formato de email invalido.");
		}
		if(!this.hospedes.containsKey(id)){
			throw new HospedeNaoCadastradoException(String.format("Erro na atualizacao do cadastro de Hospede. Hospede de email %s nao foi cadastrado(a).", id));
		}
		this.hospedes.remove(id);
	}
	
	@Override
	public String toString() {
		String relatorioHostel = "Hospedes instalados no momento:";
		Set<String> listaDeHospedes = this.hospedes.keySet();
		for (String hospede : listaDeHospedes) {
			relatorioHostel += String.format("\n -%s", this.hospedes.get(hospede));
		}
		return relatorioHostel;
	}
}
