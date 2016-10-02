package cartaofidelidade;

public class Premium extends CartaoFidelidade {

	@Override
	public void adicionaPontos(double valor) {
		int pontosGanhos = 0;
		
		pontosGanhos += (int) valor * 0.30;
		if (valor > 100.00){
			pontosGanhos += 10 * (valor - 100.00) / 100;
		}
		
		this.pontos += pontosGanhos;
	}

	@Override
	public double aplicaDesconto(double valor) {
		return valor - valor*0.10;
	}
}
