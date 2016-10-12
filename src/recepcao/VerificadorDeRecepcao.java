package recepcao;

import recepcao.exception.DiasInvalidoException;
import recepcao.exception.IndiceInvalidoException;
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
		if(quarto == null || quarto.trim().equals("") || !quarto.matches("(\\w|\\d){1,}")){
			throw new NumeroQuartoInvalido("ID do quarto invalido, use apenas numeros ou letras.");
		}
	}

	/** Metodo que verifica se tipo de quarto eh invalido
	 * @param tipoDeQuarto Tipo do quarto 
	 * @throws TipoDeQuartoInvalido Lanca exeception caso tipo de quarto seja invalido
	 */
	public void verificaTipoDeQuarto(String tipoDeQuarto) throws TipoDeQuartoInvalido {
		if(!(tipoDeQuarto.equals("Simples") || tipoDeQuarto.equals("Luxo") || tipoDeQuarto.equals("Presidencial"))){
			throw new TipoDeQuartoInvalido("Tipo de quarto invalido.");
		}
	}

	/** Metodo que verifica se indice de consulta eh invalido
	 * @param indice indice a ser consultado
	 * @throws IndiceInvalidoException Lanca Exception caso indice seja invalido
	 */
	public void verificaIndice(int indice) throws IndiceInvalidoException {
		if(indice < 0){
			throw new IndiceInvalidoException("Indice invalido.");
		}	
	}

}