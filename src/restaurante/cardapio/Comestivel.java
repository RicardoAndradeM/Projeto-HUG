package restaurante.cardapio;

/** Interface que estabece regras para que algum produto consumivel possa ir para o cadarpio
 * @author Ricardo Andrade
 * @since 12/10/2016
 */
public interface Comestivel {
	
	/** Metodo Que retorna o nome do item do cardapio
	 * @return Retorna o Nome do item
	 */
	public String getNome();
	
	/** Metodo que retorna o valor do item do cardapio
	 * @return Retorna o Preco a ser pago
	 */
	public double getPreco();
	
	/** Metodo que retorna uma descricao do item do cardapio
	 * @return Retorna a Descricao do item
	 */
	public String getDescricao();
}
