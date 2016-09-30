package cartaofidelidade;

public class Padrao implements CartaoFidelidade {
	
	/** metodo que adicionarar pontos ao cartao do hospede
	 * @param valor	valor a ser convertidos a pontos
	 * @return pontos convertidos 
	 */
	@Override
	public int adicionarPontos(double valor) {
		double pontos = valor*0.1;
		return (int) pontos;
	}

	/** metodo que aplicarar deconto
	 * @param valor valor sera descontato de acordado com o tipo do cartao
	 * @return
	 */
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
