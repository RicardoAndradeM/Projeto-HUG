package recepcao;

import recepcao.exception.DiasInvalidoException;
import recepcao.exception.NumeroQuartoInvalido;

/** Classe que verifica informacoes nas operacoes de Recepcao
 * @author Ricardo Andrade
 * @since 09/10/2016
 */
public class VerificadorDeRecepcao {

	/** Metodo que verifica se dias de estadia eh valido
	 * @param dias dias da estadia
	 * @throws DiasInvalidoException Lanca exception caso o valor de dias seja invalido
	 */
	public void verificaDias(int dias) throws DiasInvalidoException {
		if(dias < 1){
			throw new DiasInvalidoException("Quantidade de dias esta invalida.");
		}
	}

	/** Metodo que verifica o numero do quarto eh invalido
	 * @param quarto numero do quarto
	 * @throws NumeroQuartoInvalido lanca exception caso numero seja invalido
	 */
	public void verificaQuarto(String quarto) throws NumeroQuartoInvalido {
		if(quarto == null || quarto.trim().equals("")){
			throw new NumeroQuartoInvalido("Numero de quarto nao poder ser vazio ou nulo");
		}
	}

}