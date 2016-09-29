package cartaoFidelidade;

public class Padrao implements CartaoFidelidade {

	@Override
	public int adicionarPontos(double valor) {
		double pontos = valor*0.1;
		return (int) pontos;
	}

	@Override
	public double aplicarDesconto( double valor) {
		return 0;
		
	}

	@Override
	public int pagarDividas() {
		// TODO Auto-generated method stub
		return 0;
	}

}
