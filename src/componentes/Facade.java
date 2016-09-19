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

public class Facade {
	private ControlerRecepcao controlerRecepcao;
	private ControlerRestaurante controlerRestaurante;
	
	
	public Facade(){
		controlerRecepcao = new ControlerRecepcao();
		controlerRestaurante = new ControlerRestaurante();
	}
	
	public String cadastraHospede(String nome, String email, String dataNascimento) throws NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException{
		return controlerRecepcao.cadastraHospede(nome, email, dataNascimento);
	}
	public String getInfoHospede(String email, String atributo) throws NomeDeAtributoInvalidoException, HospedeNaoEncontradoException{
		return controlerRecepcao.getInfoHospede(email, atributo);
	}
	public void atualizaCadastro(String id, String atributo, String valor) throws EmailInvalidoException, NomeInvalidoException, DataNascimentoInvalidaException, NomeDeAtributoInvalidoException, HospedeNaoEncontradoException{
		controlerRecepcao.atualizaCadastro(id, atributo, valor);
	}
	public boolean removeHospede(String email) throws HospedeNaoEncontradoException{
		return controlerRecepcao.removeHospede(email);
	}
	public Hospede buscaHospede(String email) throws HospedeNaoEncontradoException{
		return controlerRecepcao.buscaHospede(email);
	}
	public void checkin(String id, String numeroQuarto, TipoDeQuarto tipoDeQuarto, int quantidadeDias) throws NomeDeAtributoInvalidoException, QuantidadedeDiasInvalidaException, HospedeNaoEncontradoException{
		controlerRecepcao.checkin(id, numeroQuarto, tipoDeQuarto, quantidadeDias);
	}
	public void checkout(String id, String numeroQuarto) throws HospedeNaoEncontradoException{
		controlerRecepcao.checkout(id, numeroQuarto);
	}
	public void cadastraPrato(String nome, double preco, String descricao) throws Exception{
		controlerRestaurante.cadastraPrato(nome, preco, descricao);
	}
	public void cadastraRefeicao(String nome, String descricao, Prato ṕrimeiroPrato, Prato segundoPrato, Prato terceiroPrato) throws Exception{
		controlerRestaurante.cadastraRefeicao(nome, descricao, ṕrimeiroPrato, segundoPrato, terceiroPrato);
	}
	public void cadastraRefeicao(String nome, String descricao, Prato ṕrimeiroPrato, Prato segundoPrato, Prato terceiroPrato, Prato quartoPrato ) throws Exception{
		controlerRestaurante.cadastraRefeicao(nome, descricao, ṕrimeiroPrato, segundoPrato, terceiroPrato, quartoPrato);
	}
	public void atualizaPrato(String nome, String atributo, String valor) throws Exception{
		controlerRestaurante.atualizaPrato(nome, atributo, valor);
	}
	public void atualizaRefeicao(String nomeRefeicao, String atributo, String valor) throws Exception{
		controlerRestaurante.atualizaRefeicao(nomeRefeicao, atributo, valor);
	}	
	public Refeicao buscaRefeicao(String nomeRefeicao){
		return controlerRestaurante.buscaRefeicao(nomeRefeicao);
	}
	public boolean verificaPrato(String nomePrato){
		return controlerRestaurante.verificaPrato(nomePrato);
	}
	public boolean verificaRefeicao(String nomeRefeicao){
		return controlerRestaurante.verificaRefeicao(nomeRefeicao);
	}
	public void removerPrato(String nomePrato) throws Exception{
		controlerRestaurante.removePrato(nomePrato);
	}
	public void removerRefeicao(String nomeRefeicao) throws Exception{
		controlerRestaurante.removeRefeicao(nomeRefeicao);
	}	
}