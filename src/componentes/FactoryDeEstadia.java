package componentes;

public class FactoryDeEstadia {

	public Estadia criaEstadia(Quarto quarto, int quantidadeDias) {
		return new Estadia(quarto, quantidadeDias);
	}

}
