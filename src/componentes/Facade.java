package componentes;

import componentes.Hospede;
import easyaccept.EasyAccept;
import enums.TipoDeQuarto;
import exceptions.DataNascimentoInvalidaException;
import exceptions.EmailInvalidoException;
import exceptions.HospedeNaoEncontradoException;
import exceptions.NomeDeAtributoInvalidoException;
import exceptions.NomeInvalidoException;
import exceptions.QuantidadedeDiasInvalidaException;
import componentes.ControlerRecepcao;
	
/**
 * 
 * @author ygorlor
 *@since 19/09/16
 */
public class Facade {
	private ControlerRecepcao controlerRecepcao;
	private ControlerRestaurante controlerRestaurante;
	
	
	public Facade(){
		controlerRecepcao = new ControlerRecepcao();
		controlerRestaurante = new ControlerRestaurante();
	}
<<<<<<< HEAD
	
	public String cadastraHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException{
=======
	/**
	 * 
	 * @param nome do hospede
	 * @param email do hospede
	 * @param dataNascimento do hospede
	 * @return ah id do hospede
	 * @throws NomeInvalidoException
	 * @throws EmailInvalidoException
	 * @throws dataNascimentoInvalidaException
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, dataNascimentoInvalidaException{
>>>>>>> bbdab1912125bd80d43a29597125d55f7a8c9a64
		return controlerRecepcao.cadastraHospede(nome, email, dataNascimento);
	}
	/**
	 * @param nome nome do hospede
	 * @param email email do hospede que sera usado de logind
	 * @param dataNascimento data completa de nascimento no formato DD/MM/AAAA
	 * @return id do hospede, neste caso, o email
	 * @throws EmailInvalidoException 
	 * @throws NomeInvalidoException 
	 * @throws dataNascimentoInvalidaException 
	 */
	public String getInfoHospede(String email, String atributo) throws NomeDeAtributoInvalidoException, HospedeNaoEncontradoException{
		return controlerRecepcao.getInfoHospede(email, atributo);
	}
<<<<<<< HEAD
	public void atualizaCadastro(String id, String atributo, String valor) throws EmailInvalidoException, NomeInvalidoException, DataNascimentoInvalidaException, NomeDeAtributoInvalidoException, HospedeNaoEncontradoException{
=======
	/**
	 * @param id email do hospede
	 * @param atributo informacao a ser atualizado
	 * @param valor novo valor
	 * @throws EmailInvalidoException 
	 * @throws NomeInvalidoException 
	 * @throws dataNascimentoInvalidaException 
	 * @throws NomeDeAtributoInvalidoException 
	 * @throws HospedeNaoEncontradoException 
	 */
	public void atualizaCadastro(String id, String atributo, String valor) throws EmailInvalidoException, NomeInvalidoException, dataNascimentoInvalidaException, NomeDeAtributoInvalidoException, HospedeNaoEncontradoException{
>>>>>>> bbdab1912125bd80d43a29597125d55f7a8c9a64
		controlerRecepcao.atualizaCadastro(id, atributo, valor);
	}
	/**
	 * @param email email do hospede
	 * @return retorna verdadeiro caso seja concluido com sucesso
	 * @throws HospedeNaoEncontradoException 
	 */
	public boolean removeHospede(String email) throws HospedeNaoEncontradoException{
		return controlerRecepcao.removeHospede(email);
	}
	/**
	 * @param id email do hospede
	 * @return retorna o hospede buscado
	 * @throws HospedeNaoEncontradoException 
	 */
	public Hospede buscaHospede(String email) throws HospedeNaoEncontradoException{
		return controlerRecepcao.buscaHospede(email);
	}
	public void checkin(String id, String numeroQuarto, TipoDeQuarto tipoDeQuarto, int quantidadeDias) throws NomeDeAtributoInvalidoException, QuantidadedeDiasInvalidaException, HospedeNaoEncontradoException{
		controlerRecepcao.checkin(id, numeroQuarto, tipoDeQuarto, quantidadeDias);
	}
	public void checkout(String id, String numeroQuarto) throws HospedeNaoEncontradoException{
		controlerRecepcao.checkout(id, numeroQuarto);
	}
	
	/**
	 * 
	 * @param nome nome do prato
	 * @param preco preco do prato
	 * @param descricao do prato cadastrado
	 * @return verdadeiro caso cadastro com sucesso 
	 * @throws Exception
	 */
	public boolean cadastraPrato(String nome, double preco, String descricao) throws Exception{
		return controlerRestaurante.cadastraPrato(nome, preco, descricao);
	}
	
	/**
	 * 
	 * @param nome da refeicao
	 * @param descricao da refeicao
	 * @param primeiroPrato da refeicao
	 * @param segundoPrato da refeicao
	 * @param terceiroPrato da refeicao
	 * @param quartoPrato
	 * @return verdadeiro caso cadastro com sucesso 
	 * @throws Exception
	 */
	public boolean cadastraRefeicao(String nome, String descricao, Prato ṕrimeiroPrato, Prato segundoPrato, Prato terceiroPrato) throws Exception{
		return controlerRestaurante.cadastraRefeicao(nome, descricao, ṕrimeiroPrato, segundoPrato, terceiroPrato);
	}
	
	/**
	 * 
	 * @param nome da refeicao
	 * @param descricao da refeicao
	 * @param primeiroPrato da refeicao
	 * @param segundoPrato da refeicao
	 * @param terceiroPrato da refeicao
	 * @param quartoPrato
	 * @return verdadeiro caso cadastro com sucesso 
	 * @throws Exception
	 */
	public boolean cadastraRefeicao(String nome, String descricao, Prato ṕrimeiroPrato, Prato segundoPrato, Prato terceiroPrato, Prato quartoPrato ) throws Exception{
		return controlerRestaurante.cadastraRefeicao(nome, descricao, ṕrimeiroPrato, segundoPrato, terceiroPrato, quartoPrato);
	}
	
	/**
	 * 
	 * @param nomePrato nome do prato
	 * @param atributo do prato
	 * @param valor do prato
	 * @return verdadeiro caso atualizado com sucesso 
	 * @throws Exception
	 */
	public boolean atualizaPrato(String nome, String atributo, String valor) throws Exception{
		return controlerRestaurante.atualizaPrato(nome, atributo, valor);
	}
	
	/**
	 * 
	 * @param nomeRefeicao nome da refeicao
	 * @param atributo da refeicao
	 * @param valor da refeicao
	 * @return verdadeiro caso cadastro com sucesso 
	 * @throws Exception
	 */
	public boolean atualizaRefeicao(String nomeRefeicao, String atributo, String valor) throws Exception{
		return controlerRestaurante.atualizaRefeicao(nomeRefeicao, atributo, valor);
	}	
	
	/**
	 * 
	 * @param nomeRefeicao nome da refeicao
	 * @return refeicao encontrada
	 */
	public Refeicao buscaRefeicao(String nomeRefeicao){
		return controlerRestaurante.buscaRefeicao(nomeRefeicao);
	}
	
	/**
	 * 
	 * @param nomePrato nome da prato
	 * @return verdadeiro caso encontrado com sucesso 
	 */
	public boolean verificaPrato(String nomePrato){
		return controlerRestaurante.verificaPrato(nomePrato);
	}
	
	/**
	 * 
	 * @param nomeRefeicao nome da refeicao
	 * @return verdadeiro caso encontrado com sucesso 
	 */
	public boolean verificaRefeicao(String nomeRefeicao){
		return controlerRestaurante.verificaRefeicao(nomeRefeicao);
	}
	
	/**
	 * 
	 * @param nomePrato
	 * @return verdadeiro caso prato remavido com sucesso 
	 * @throws Exception
	 */
	public void removerPrato(String nomePrato) throws Exception{
		controlerRestaurante.removePrato(nomePrato);
	}
	
	/**
	 * 
	 * @param nomeRefeicao
	 * @return verdadeiro caso prato remavido com sucesso 
	 * @throws Exception
	 */
	public void removerRefeicao(String nomeRefeicao) throws Exception{
		controlerRestaurante.removeRefeicao(nomeRefeicao);
	}	
}