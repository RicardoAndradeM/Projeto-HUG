package recepcao.quarto;

/** Classe que criar novos quartos
 * @author Ricardo Andrade
 * @since 09/10/2016
 */
public class FactoryDeQuarto {

	/** Cria um novo quarto
	 * @param numero numero do quarto
	 * @param tipo tipo do quarto
	 * @return retorna o quarto criado
	 */
	public Quarto criaQuarto(String numero, TipoDeQuarto tipo) {
		return new Quarto(numero, tipo);
	}

}
