package cadastro.hospede.cartaofidelidade;

/** Interface que defique o que cada tipo de cartao deve fazer
 * @author Ricardo Andrade
 * @since 13/10/2016
 */
public interface TipoDeCartao {
	
	public int adicionaPontos(double valor);
	
	public double aplicaDesconto(double valor);
	
	public double valorAPagar();
	
}
