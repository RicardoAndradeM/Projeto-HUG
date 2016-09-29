package cartaofidelidade;

public class Premium implements CartaoFidelidade{

	/** metodo que adicionarar pontos ao cartao do hospede
	 * @param valor	valor a ser convertidos a pontos
	 * @return pontos convertidos 
	 */
	@Override
	public int adicionarPontos(double valor) {
		int pontos = (int) (valor*0.3);
		int pontos2 = (int) (valor/10);
		
		return pontos + pontos2;
	}

	/** metodo que aplicarar deconto
	 * @param valor valor sera descontato de acordado com o tipo do cartao
	 * @return
	 */
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
