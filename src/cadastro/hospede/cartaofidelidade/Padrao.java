package cadastro.hospede.cartaofidelidade;

/** Classe que representa o tipo Padrao de Cartao
 * @author Ricardo Andrade
 * @author Ygor
 * @since 13/10/2016
 */
public class Padrao implements TipoDeCartao {

	@Override
	public int adicionaPontos(double valor) {
		return (int) (valor * 0.10);
	}

	@Override
	public double aplicaDesconto(double valor) {
		return valor;
	}

	@Override
	public double valorAPagar() {
		// TODO Auto-generated method stub
		return 0;
	}

}
