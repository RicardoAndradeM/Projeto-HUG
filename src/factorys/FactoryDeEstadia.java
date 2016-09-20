package factorys;

import exceptions.valordeatributoinvalido.QuantidadedeDiasInvalidaException;
import recepcao.Estadia;
import recepcao.Quarto;

public class FactoryDeEstadia {

	public Estadia criaEstadia(Quarto quarto, int quantidadeDias) throws QuantidadedeDiasInvalidaException {
		return new Estadia(quarto, quantidadeDias);
	}

}
