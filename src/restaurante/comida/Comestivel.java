package restaurante.comida;

/** Interface que estabece regras para que algum produto consumivel possa ir para o cadarpio
 * @author Ricardo Andrade
 * @since 12/10/2016
 */
public interface Comestivel extends Comparable<Comestivel> {
	
	/** Metodo que retorna o valor do item do cardapio
	 * @return Retorna o Preco a ser pago
	 */
	public double getPreco();
	
	/** Metodo que retorna uma descricao do item do cardapio
	 * @return Retorna a Descricao do item
	 */
	public String getDescricao();
}
