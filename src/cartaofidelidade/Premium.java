package cartaofidelidade;

public class Premium implements CartaoFidelidade{

	@Override
	public int adicionarPontos(double valor) {
		int pontos = (int) (valor*0.3);
		int pontos2 = (int) (valor/10);
		
		return pontos + pontos2;
	}

	@Override
	public double aplicarDesconto(double valor) {
		return valor - valor*0.1;
		
		
	}

	@Override
	public int pagarDividas() {
		// TODO Auto-generated method stub
		return 0;
	}

}
