package recepcao;

import java.util.ArrayList;
import java.util.HashMap;

import cadastro.ControllerCadastro;
import cadastro.exception.HospedeNaoCadastradoException;
import recepcao.exception.DiasInvalidoException;
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
	
	public ControllerRecepcao(ControllerCadastro cadastro) {
		this.cadastro = cadastro;
		this.quartos = new HashMap<String, Quarto>();
		this.transacoes = new ArrayList<Transacao>();
		this.factoryDeQuarto = new FactoryDeQuarto();
	}
	
	public void  realizaCheckin(String email, int dias, String quarto, String tipoQuarto) throws DiasInvalidoException, NumeroQuartoInvalido, TipoDeQuartoInvalido, QuartoOcupadoException, cadastro.exception.QuartoOcupadoException, HospedeNaoCadastradoException, QuartoDesocupadoException{
		this.verificadorDeRecepcao.verificaDias(dias);
		this.verificadorDeRecepcao.verificaQuarto(quarto);
		if(!this.quartos.containsKey(quarto)){
			TipoDeQuarto tipoDoNovoQuarto;
			switch (tipoQuarto) {
			case "Simples":
				tipoDoNovoQuarto = TipoDeQuarto.SIMPLES;
				break;
			
			case "Luxo":
				tipoDoNovoQuarto = TipoDeQuarto.LUXO;
				break;
				
			case "Presidencial":
				tipoDoNovoQuarto = TipoDeQuarto.PRESIDENCIAL;
				break;
		
			default:
				throw new TipoDeQuartoInvalido("Erro ao realizar checkin. Nome do tipo de quarto invalido");
			}
			Estadia novaEstadia = new Estadia(email, dias);
			Quarto novoQuarto =  this.factoryDeQuarto.criaQuarto(quarto, tipoDoNovoQuarto);
			novoQuarto.recebeEstadia(novaEstadia);
			this.cadastro.concluirCheckin(email, novoQuarto.getNumero(), novoQuarto.calculaValor());
			this.quartos.put(novoQuarto.getNumero(), novoQuarto);
		}
		throw new QuartoOcupadoException(String.format("Erro ao realizar checkin. Quarto %s ja esta ocupado.", quarto));
	}
}
