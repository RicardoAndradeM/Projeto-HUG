package factorys;

import enums.TipoDeQuarto;
import exceptions.valordeatributoinvalido.NomeDeAtributoInvalidoException;
import recepcao.Quarto;

public class FactoryDeQuarto {

	public Quarto criaQuarto(String numeroQuarto, TipoDeQuarto tipoDeQuarto) throws NomeDeAtributoInvalidoException {
		return new Quarto(numeroQuarto,tipoDeQuarto);
	}

}
