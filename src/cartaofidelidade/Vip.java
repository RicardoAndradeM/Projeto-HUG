package cartaofidelidade;

public class Vip implements CartaoFidelidade {

	/** metodo que adicionarar pontos ao cartao do hospede
	 * @param valor	valor a ser convertidos a pontos
	 * @return pontos convertidos 
	 */
	@Override
	public int adicionarPontos(double valor) {
		int pontos = (int) (valor*0.5);
		return pontos;
	}

	/** metodo que aplicarar deconto
	 * @param valor valor sera descontato de acordado com o tipo do cartao
	 * @return
	 */
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
