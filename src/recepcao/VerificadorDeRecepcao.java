package recepcao;

import recepcao.exception.DiasInvalidoException;
import recepcao.exception.NumeroQuartoInvalido;

public class VerificadorDeRecepcao {

	public void verificaDias(int dias) throws DiasInvalidoException {
		if(dias < 1){
			throw new DiasInvalidoException("Quantidade de dias esta invalida.");
		}
	}

	public void verificaQuarto(String quarto) throws NumeroQuartoInvalido {
		if(quarto == null || quarto.trim().equals("")){
			throw new NumeroQuartoInvalido("Numero de quarto nao poder ser vazio ou nulo");
		}
	}

}