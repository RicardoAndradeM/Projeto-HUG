package cadastro.hospede.cartaofidelidade;

/** Classe que representa o tipo Vip de Cartao
 * @author Ricardo Andrade
 * @author Ygor
 * @since 13/10/2016
 */
public class Vip implements TipoDeCartao {

	@Override
	public int adicionaPontos(double valor) {
		return (int) (valor * 0.5);
	}

	@Override
	public double aplicaDesconto(double valor) {
		double valorFinal = 0;
		
		valorFinal -= 10*(int)valor / 100;
		
		valorFinal = (valor - valor*0.15);
		return valorFinal;
	}

	@Override
	public double convertePontos(double valor) {
		return valor * 0.7 + (valor/10 * 0.5);
	}

}
