package recepcao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import cadastro.ControllerCadastro;
import cadastro.exception.AtributoInvalidoException;
import cadastro.exception.EmailInvalidoException;
import cadastro.exception.HospedeNaoCadastradoException;
import cadastro.exception.QuartoNaoEncontradoException;
import cadastro.hospede.VerificadorDeHospede;
import recepcao.exception.DiasInvalidoException;
import recepcao.exception.HospedeNaoHospedadoException;
import recepcao.exception.IndiceInvalidoException;
import recepcao.exception.NumeroQuartoInvalido;
import recepcao.exception.QuartoDesocupadoException;
import recepcao.exception.QuartoOcupadoException;
import recepcao.exception.TipoDeQuartoInvalido;
import recepcao.quarto.Estadia;
import recepcao.quarto.FactoryDeQuarto;
import recepcao.quarto.Quarto;
import recepcao.quarto.TipoDeQuarto;

/** Classe responsavel com fazer checkin e checkout do clientes
 * @author Ricardo Andrade
 * @since 09/10/2016
 */
public class ControllerRecepcao {
	private ControllerCadastro cadastro;
	private HashMap<String, Quarto> quartos;
	private ArrayList<Transacao> transacoes;
	private FactoryDeQuarto factoryDeQuarto;
	private VerificadorDeRecepcao verificadorDeRecepcao;
	
	/** Constroi Recepcao e inicializa as variaveis
	 * @param cadastro Controler Cadastro utilizado para gerencias os hospedes
	 */
	public ControllerRecepcao(ControllerCadastro cadastro) {
		this.cadastro = cadastro;
		this.quartos = new HashMap<String, Quarto>();
		this.transacoes = new ArrayList<Transacao>();
		this.factoryDeQuarto = new FactoryDeQuarto();
		this.verificadorDeRecepcao = new VerificadorDeRecepcao();
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
	public void realizaCheckin(String email, int dias, String quarto, String tipoQuarto) throws TipoDeQuartoInvalido, cadastro.exception.QuartoOcupadoException, QuartoOcupadoException, HospedeNaoCadastradoException, EmailInvalidoException, DiasInvalidoException, NumeroQuartoInvalido{
		try {
			this.verificadorDeRecepcao.verificaDias(dias);
		} catch (DiasInvalidoException e) {
			throw new DiasInvalidoException("Erro ao realizar checkin. " + e.getMessage());
		}
		try {
			this.verificadorDeRecepcao.verificaQuarto(quarto);
		} catch (NumeroQuartoInvalido e) {
			throw new NumeroQuartoInvalido("Erro ao realizar checkin. " + e.getMessage());
		}
		try {
			this.verificadorDeRecepcao.verificaTipoDeQuarto(tipoQuarto);			
		} catch (TipoDeQuartoInvalido e) {
			throw new TipoDeQuartoInvalido("Erro ao realizar checkin. " + e.getMessage());
		}
		
		if(!this.quartos.containsKey(quarto)){
			TipoDeQuarto tipoDoNovoQuarto;
			switch (tipoQuarto) {
			case "Simples":
				tipoDoNovoQuarto = TipoDeQuarto.SIMPLES;
				break;
			
			case "Luxo":
				tipoDoNovoQuarto = TipoDeQuarto.LUXO;
				break;
				
			default:
				tipoDoNovoQuarto = TipoDeQuarto.PRESIDENCIAL;
				break;
			}
			Estadia novaEstadia = new Estadia(email, dias);
			Quarto novoQuarto =  this.factoryDeQuarto.criaQuarto(quarto, tipoDoNovoQuarto);
			try {
				novoQuarto.recebeEstadia(novaEstadia);
			} catch (QuartoOcupadoException e) {
				throw new QuartoOcupadoException("Erro ao realizar checkin. " + e.getMessage());
			}
			try {
				this.cadastro.concluirCheckin(email, novoQuarto.getNumero(), novoQuarto.calculaValor());
			} catch (QuartoDesocupadoException e) {
				e.printStackTrace();
			} catch (HospedeNaoCadastradoException e) {
				throw new HospedeNaoCadastradoException("Erro ao realizar checkin. " + e.getMessage());
			}
			this.quartos.put(novoQuarto.getNumero(), novoQuarto);
			return;
		}
		try {
			new VerificadorDeHospede().verificaEmail(email);
		} catch (EmailInvalidoException e) {
			throw new EmailInvalidoException("Erro ao realizar checkin. " + e.getMessage());
		}
		throw new QuartoOcupadoException(String.format("Erro ao realizar checkin. Quarto %s ja esta ocupado.", quarto));
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
	public String realizaCheckout(String email, String quarto) throws QuartoNaoEncontradoException, HospedeNaoCadastradoException, QuartoDesocupadoException, EmailInvalidoException, NumeroQuartoInvalido{
		try {
			this.verificadorDeRecepcao.verificaQuarto(quarto);
		} catch (NumeroQuartoInvalido e) {
			throw new NumeroQuartoInvalido("Erro ao realizar checkout. " + e.getMessage());
		}
		try {
			this.cadastro.concluirCheckout(email, quarto);
		} catch (EmailInvalidoException e) {
			throw new EmailInvalidoException("Erro ao realizar checkout. " + e.getMessage());
		}
		try {
			this.transacoes.add(new Transacao(LocalDate.now(), this.cadastro.getInfoHospede(email, "Nome"), quarto, this.quartos.get(quarto).calculaValor()));
		} catch (AtributoInvalidoException e) {
			e.printStackTrace();
		}
		return String.format("R$%.2f", this.quartos.remove(quarto).calculaValor());
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
	public String getInfoHospedagem(String email, String atributo) throws HospedeNaoHospedadoException, HospedeNaoCadastradoException, AtributoInvalidoException, EmailInvalidoException{
		try {
			new VerificadorDeHospede().verificaEmail(email);
		} catch (EmailInvalidoException e) {
			throw new EmailInvalidoException("Erro ao checar hospedagem ativa. " + e.getMessage());
		}
		try {
			String infoHospedagem = this.cadastro.getInfoHospede(email, atributo);
			if(infoHospedagem.equals("0") || infoHospedagem.equals("R$0,00") || infoHospedagem.equals("")){
				throw new HospedeNaoHospedadoException(String.format("Erro na consulta de hospedagem. Hospede %s nao esta hospedado(a).", this.cadastro.getInfoHospede(email, "Nome")));
			}
			return infoHospedagem;
		} catch (HospedeNaoCadastradoException e) {
			throw new HospedeNaoCadastradoException(String.format("Erro na consulta de hospedagem. Hospede de email %s nao foi cadastrado(a).", email));
			
		} catch (AtributoInvalidoException e) {
			throw new AtributoInvalidoException("Erro na consulta de hospedagem. Atributo solicitado nao encontrado.");
		}
	}
	
	/** Metodo que consulta informacoes sobre transacoes
	 * @param atributo Atributos Solicitado
	 * @return Retorna a informacao solicitada
	 */
	public String consultaTransacoes(String atributo){
		switch (atributo) {
		case "Quantidade":
			return String.valueOf(this.transacoes.size());
		
		case "Total":
			double total = 0;
			for (Transacao transacao : transacoes) {
				total += transacao.getTotalPago();
			}
			return String.format("R$%.2f",total);
			
		case "Nome":
			StringBuilder pessoas = new StringBuilder();
			for (Transacao transacao : transacoes) {
				if(pessoas.length() == 0){
					pessoas.append(transacao.getNomeHospede());
					continue;
				}
				pessoas.append(";");
				pessoas.append(transacao.getNomeHospede());
			}
			return pessoas.toString();
			
		default:
			return null;
		}
	}
	
	/** Metodo que consulta informacoes sobre transacoes
	 * @param atributo Atributos Solicitado
	 * @param indice Indice a se pesquisar
	 * @return Retorna a informacao solicitada
	 * @throws IndiceInvalidoException Lanca exception caso indice seja invalido
	 */
	public String consultaTransacoes(String atributo, int indice) throws IndiceInvalidoException{
		try {
			this.verificadorDeRecepcao.verificaIndice(indice);
		} catch (IndiceInvalidoException e) {
			throw new IndiceInvalidoException("Erro na consulta de transacoes. " + e.getMessage());
		}
		switch (atributo) {
		case "Total":
			return String.format("R$%.2f",this.transacoes.get(indice).getTotalPago());
			
		case "Nome":
			return this.transacoes.get(indice).getNomeHospede();
		
		case "Detalhes":
			return this.transacoes.get(indice).getNumeroDoQuarto();

		default:
			return null;
		}
	}
	
	public void registraTransacao(String nomeHospede, String nome, double totalPago ) throws HospedeNaoCadastradoException, AtributoInvalidoException{
		this.transacoes.add(new Transacao(LocalDate.now(), this.cadastro.getInfoHospede(nomeHospede, "Nome"), nome, totalPago));
	}
}
