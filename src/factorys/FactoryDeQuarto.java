package factorys;

import enums.TipoDeQuarto;
import exceptions.valordeatributoinvalido.NomeDeAtributoInvalidoException;
import recepcao.Quarto;

/**
 * Cria objetos do tripo Quarto
 * @since 16/09/16
 */
public class FactoryDeQuarto {

	public Quarto criaQuarto(String numeroQuarto, TipoDeQuarto tipoDeQuarto) throws NomeDeAtributoInvalidoException {
		return new Quarto(numeroQuarto,tipoDeQuarto);
	}

}
