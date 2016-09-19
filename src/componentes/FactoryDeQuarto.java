package componentes;

import enums.TipoDeQuarto;

public class FactoryDeQuarto {

	public Quarto criaQuarto(String numeroQuarto, TipoDeQuarto tipoDeQuarto) {
		return new Quarto(numeroQuarto,tipoDeQuarto);
	}

}
