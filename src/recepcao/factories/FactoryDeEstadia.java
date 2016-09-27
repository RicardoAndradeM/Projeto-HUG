package recepcao.factories;

import exceptions.valordeatributoinvalido.QuantidadedeDiasInvalidaException;
import recepcao.Estadia;
import recepcao.Quarto;

/**
 * Cria objetos do tipo Estadia
 * @since 16/09/16
 */
public class FactoryDeEstadia {

	public Estadia criaEstadia(Quarto quarto, int quantidadeDias) throws QuantidadedeDiasInvalidaException {
		return new Estadia(quarto, quantidadeDias);
	}

}
