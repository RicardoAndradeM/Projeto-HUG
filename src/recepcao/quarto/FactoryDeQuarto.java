package recepcao.quarto;

public class FactoryDeQuarto {

	public Quarto criaQuarto(String numero, TipoDeQuarto tipo) {
		return new Quarto(numero, tipo);
	}

}
