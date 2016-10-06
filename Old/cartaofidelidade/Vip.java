package cartaofidelidade;

public class Vip extends CartaoFidelidade{

	@Override
	public void adicionaPontos(double valor) {
		this.pontos += (int) valor * 0.5;
	}

	@Override
	public double aplicaDesconto(double valor) {
		double valorFinal = 0;
		
		valorFinal -= 10*(int)valor / 100;
		
		valorFinal = (valor - valor*0.15);
		return valorFinal;
	}
}
