package componentes;

import execeptions.QuantidadedeDiasInvalidaException;

public class FactoryDeEstadia {

	public Estadia criaEstadia(Quarto quarto, int quantidadeDias) throws QuantidadedeDiasInvalidaException {
		return new Estadia(quarto, quantidadeDias);
	}

}
