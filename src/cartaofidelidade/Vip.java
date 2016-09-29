package cartaofidelidade;

public class Vip implements CartaoFidelidade {

	@Override
	public int adicionarPontos(double valor) {
		int pontos = (int) (valor*0.5);
		return pontos;
	}

	@Override
	public double aplicarDesconto(double valor) {
		double desconto = valor*0.15;
		int desconto1= (int) (valor*0.1);
		double descontoFinal = valor - desconto - desconto1;
		return descontoFinal;
	}

	@Override
	public int pagarDividas() {
		// TODO Auto-generated method stub
		return 0;
	}
}
