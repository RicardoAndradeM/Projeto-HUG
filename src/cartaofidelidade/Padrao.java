package cartaofidelidade;

public class Padrao extends CartaoFidelidade {

	@Override
	public void adicionaPontos(double valor) {
		pontos += (int) valor * 0.10;
	}

	@Override
	public double aplicaDesconto(double valor) {
		return valor;
	}

	
}
