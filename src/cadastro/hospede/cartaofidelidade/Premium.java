package cadastro.hospede.cartaofidelidade;

public class Premium implements TipoDeCartao {

	@Override
	public int adicionaPontos(double valor) {
		int pontosGanhos = 0;
		
		pontosGanhos += (int) valor * 0.30;
		if (valor > 100.00){
			pontosGanhos += 10 * (valor - 100.00) / 100;
		}
		
		return pontosGanhos;
	}

	@Override
	public double aplicaDesconto(double valor) {
		return valor - valor*0.10;
	}

	@Override
	public double convertePontos(double valor) {
		return valor * 0.3 + (valor/10 * 0.2);
	}

}
