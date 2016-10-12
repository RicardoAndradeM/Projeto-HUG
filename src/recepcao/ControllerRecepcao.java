package recepcao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import cadastro.ControllerCadastro;
import cadastro.exception.AtributoInvalidoException;
import cadastro.exception.EmailInvalidoException;
import cadastro.exception.HospedeNaoCadastradoException;
import cadastro.exception.QuartoNaoEncontradoException;
import cadastro.hospede.VerificadorDeHospede;
import recepcao.exception.DiasInvalidoException;
import recepcao.exception.HospedeNaoHospedadoException;
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
	 */
	public String realizaCheckout(String email, String quarto) throws QuartoNaoEncontradoException, HospedeNaoCadastradoException, EmailInvalidoException, QuartoDesocupadoException{
		this.cadastro.concluirCheckout(email, quarto);
		try {
			this.transacoes.add(new Transacao(LocalDate.now(), this.cadastro.getInfoHospede(email, "nome"), quarto, this.quartos.get(quarto).calculaValor()));
		} catch (AtributoInvalidoException e) {
			e.printStackTrace();
		}
		return String.format("R$%2.f", this.quartos.remove(quarto).calculaValor());
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
	
	public String consultaTransacoe(String atributo){
		return null; // implementar
	}
	
	public String consultaTransacoe(String atributo, int indice){
		return null; // implementar
	}
}
