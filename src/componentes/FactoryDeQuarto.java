package componentes;

import enums.TipoDeQuarto;
import execeptions.NomeDeAtributoInvalidoException;
import componentes.Quarto;

public class FactoryDeQuarto {

	public Quarto criaQuarto(String numeroQuarto, TipoDeQuarto tipoDeQuarto) throws NomeDeAtributoInvalidoException {
		return new Quarto(numeroQuarto,tipoDeQuarto);
	}

}
