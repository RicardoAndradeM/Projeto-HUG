package componentes;

import recepcao.ControlerRecepcao;
import recepcao.Hospede;
import restaurante.ControlerRestaurante;
import restaurante.Prato;
import restaurante.Refeicao;
import enums.TipoDeQuarto;
import exceptions.naocadastrado.HospedeNaoEncontradoException;
import exceptions.naocadastrado.NaoCadastradoException;
import exceptions.valordeatributoinvalido.DataNascimentoInvalidaException;
import exceptions.valordeatributoinvalido.EmailInvalidoException;
import exceptions.valordeatributoinvalido.NomeDeAtributoInvalidoException;
import exceptions.valordeatributoinvalido.NomeInvalidoException;
import exceptions.valordeatributoinvalido.QuantidadedeDiasInvalidaException;
	
/**
 * facade do sistema
 * @since 13/09/16
 */
public class Facade {
	private ControlerRecepcao controlerRecepcao;
	private ControlerRestaurante controlerRestaurante;
	
	
	public Facade(){
		controlerRecepcao = new ControlerRecepcao();
		controlerRestaurante = new ControlerRestaurante();
	}
	
	public void iniciaSistema(){
		
	}
	
	/** cadastra um hospede no sistema
	 * @param nome do hospede
	 * @param email do hospede
	 * @param dataNascimento do hospede
	 * @return ah id do hospede
	 * @throws NomeInvalidoException caso nome seja invalido
	 * @throws EmailInvalidoException caso email seja invalido
	 */
	public String cadastraHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException{
		return controlerRecepcao.cadastraHospede(nome, email, dataNascimento);
	}
	
	/** obtem informações do hospede no sitema
	 * @param nome nome do hospede
	 * @param email email do hospede que sera usado de logind
	 * @param dataNascimento data completa de nascimento no formato DD/MM/AAAA
	 * @return id do hospede, neste caso, o email
	 * @throws EmailInvalidoException caso email invalido
	 * @throws NomeInvalidoException caso nome invalido
	 * @throws dataNascimentoInvalidaException caso data de nascimento seja invalido
	 */
	public String getInfoHospede(String email, String atributo) throws NomeDeAtributoInvalidoException, HospedeNaoEncontradoException{
		return controlerRecepcao.getInfoHospede(email, atributo);
	}
	
	/** retorna informacoes do espede
	 * @param email email do hospede
	 * @param atributo atributo solicitado
	 * @return atribulo que foi solicitado
	 * @throws Exception
	 */
	public String getInfoHospedagem(String email, String atributo) throws Exception {
		return controlerRecepcao.getInfoHospedagem(email, atributo);
	}

	
	/**
	 * @param id email do hospede
	 * @param atributo informacao a ser atualizado
	 * @param valor novo valor
	 * @throws EmailInvalidoException 
	 * @throws NomeInvalidoException 
	 * @throws NomeDeAtributoInvalidoException 
	 * @throws HospedeNaoEncontradoException 
	 * @throws DataNascimentoInvalidaException 
	 */
	public void atualizaCadastro(String id, String atributo, String valor) throws EmailInvalidoException, NomeInvalidoException, NomeDeAtributoInvalidoException, HospedeNaoEncontradoException, DataNascimentoInvalidaException{
		controlerRecepcao.atualizaCadastro(id, atributo, valor);
	}
	
	/**
	 * @param email email do hospede
	 * @return retorna verdadeiro caso seja concluido com sucesso
	 * @throws HospedeNaoEncontradoException 
	 * @throws EmailInvalidoException 
	 */
	public boolean removeHospede(String email) throws HospedeNaoEncontradoException, EmailInvalidoException{
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
	
	/** realiza o chekin do hospede
	 * @param id email do hospede
	 * @param quantidadeDias dia que ficara hospedado
	 * @param numeroQuarto numero do quarto em que ficara
	 * @param tipoDeQuartoString string do tipo de quarto que ocupara
	 * @throws NomeDeAtributoInvalidoException caso nome seja invalido
	 * @throws QuantidadedeDiasInvalidaException caso a quantidade de dias seja invalida
	 * @throws HospedeNaoEncontradoException caso hospe não esja cadastrado
	 */
	public void realizaCheckin(String id, int quantidadeDias, String numeroQuarto, String tipoDeQuartoString) throws NomeDeAtributoInvalidoException, QuantidadedeDiasInvalidaException, HospedeNaoEncontradoException{
		controlerRecepcao.realizaCheckin(id, numeroQuarto, tipoDeQuartoString, quantidadeDias);
	}
	
	/** faz o checkout do hospede no sistema
	 * @param id email do hospede
	 * @param numeroQuarto numero do quarto em que ficara
	 * @throws HospedeNaoEncontradoException caso hospede não seja encontrado
	 */
	public void checkout(String id, String numeroQuarto) throws HospedeNaoEncontradoException{
		controlerRecepcao.checkout(id, numeroQuarto);
	}
	
	/** cadastra um prato no cardapio
	 * @param nome nome do prato
	 * @param preco preco do prato
	 * @param descricao do prato cadastrado
	 * @return verdadeiro caso cadastro com sucesso 
	 * @throws Exception
	 */
	public boolean cadastraPrato(String nome, double preco, String descricao) throws Exception{
		return controlerRestaurante.cadastraPrato(nome, preco, descricao);
	}
	
	/** cadastra uma refeicao no sistema
	 * @param nome da refeicao
	 * @param descricao da refeicao
	 * @param primeiroPrato da refeicao
	 * @param segundoPrato da refeicao
	 * @param terceiroPrato da refeicao
	 * @param quartoPrato
	 * @return verdadeiro caso cadastro com sucesso 
	 * @throws Exception
	 */
	public boolean cadastraRefeicao(String nome, String descricao, Prato primeiroPrato, Prato segundoPrato, Prato terceiroPrato) throws Exception{
		return controlerRestaurante.cadastraRefeicao(nome, descricao, primeiroPrato, segundoPrato, terceiroPrato);
	}
	
	/** cadastra uma refeicao no sistema
	 * @param nome da refeicao
	 * @param descricao da refeicao
	 * @param primeiroPrato da refeicao
	 * @param segundoPrato da refeicao
	 * @param terceiroPrato da refeicao
	 * @param quartoPrato
	 * @return verdadeiro caso cadastro com sucesso 
	 * @throws Exception
	 */
	public boolean cadastraRefeicao(String nome, String descricao, Prato primeiroPrato, Prato segundoPrato, Prato terceiroPrato, Prato quartoPrato ) throws Exception{
		return controlerRestaurante.cadastraRefeicao(nome, descricao, primeiroPrato, segundoPrato, terceiroPrato, quartoPrato);
	}
	
	/** atualiza os dados de um prato
	 * @param nomePrato nome do prato
	 * @param atributo do prato
	 * @param valor do prato
	 * @return verdadeiro caso atualizado com sucesso 
	 * @throws Exception
	 */
	public boolean atualizaPrato(String nome, String atributo, String valor) throws Exception{
		return controlerRestaurante.atualizaPrato(nome, atributo, valor);
	}
	
	/** atualiza os dados de uma refeicao
	 * @param nomeRefeicao nome da refeicao
	 * @param atributo da refeicao
	 * @param valor da refeicao
	 * @return verdadeiro caso cadastro com sucesso 
	 * @throws Exception
	 */
	public boolean atualizaRefeicao(String nomeRefeicao, String atributo, String valor) throws Exception{
		return controlerRestaurante.atualizaRefeicao(nomeRefeicao, atributo, valor);
	}	
	
	/** busca uma refeicao no cardapio
	 * @param nomeRefeicao nome da refeicao
	 * @return refeicao encontrada
	 */
	public Refeicao buscaRefeicao(String nomeRefeicao){
		return controlerRestaurante.buscaRefeicao(nomeRefeicao);
	}
	
	/** verifica se um prato esta no cardapio
	 * @param nomePrato nome da prato
	 * @return verdadeiro caso encontrado com sucesso 
	 */
	public boolean verificaPrato(String nomePrato){
		return controlerRestaurante.verificaPrato(nomePrato);
	}
	
	/** verifica se uma refeicao esta no cardapio
	 * @param nomeRefeicao nome da refeicao
	 * @return verdadeiro caso encontrado com sucesso 
	 */
	public boolean verificaRefeicao(String nomeRefeicao){
		return controlerRestaurante.verificaRefeicao(nomeRefeicao);
	}
	
	/** remove um prato do sistema
	 * @param nomePrato nome do prato
	 * @return verdadeiro caso prato remavido com sucesso 
	 * @throws Exception
	 */
	public void removerPrato(String nomePrato) throws Exception{
		controlerRestaurante.removePrato(nomePrato);
	}
	
	/** remove uma refeicao do sistema
	 * @param nomeRefeicao nome da refeicao
	 * @return verdadeiro caso prato remavido com sucesso 
	 * @throws Exception
	 */
	public void removerRefeicao(String nomeRefeicao) throws Exception{
		controlerRestaurante.removeRefeicao(nomeRefeicao);
	}	
	
	 public void fechaSistema(){
		 
	 }
}