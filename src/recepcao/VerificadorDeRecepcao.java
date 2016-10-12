package recepcao;

import recepcao.exception.DiasInvalidoException;
import recepcao.exception.NumeroQuartoInvalido;
import recepcao.exception.TipoDeQuartoInvalido;

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
		if(quarto == null || quarto.trim().equals("") || quarto.matches("\\W")){
			throw new NumeroQuartoInvalido("ID do quarto invalido, use apenas numeros ou letras.");
		}
	}

	public void verificaTipoDeQuarto(String tipoDeQuarto) throws TipoDeQuartoInvalido {
		if(!(tipoDeQuarto.equals("Simples") || tipoDeQuarto.equals("Luxo") || tipoDeQuarto.equals("Presidencial"))){
			throw new TipoDeQuartoInvalido("Tipo de quarto invalido.");
		}
	}

}