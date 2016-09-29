package cartaofidelidade;
/**
 * @since 29/09/16
 */
public interface CartaoFidelidade {
	
	/** metodo que adicionarar pontos ao cartao do hospede
	 * @param valor	valor a ser convertidos a pontos
	 * @return pontos convertidos 
	 */
	public int adicionarPontos(double valor);
	
	/** metodo que aplicarar deconto
	 * @param valor valor sera descontato de acordado com o tipo do cartao
	 * @return
	 */
	public double aplicarDesconto(double valor);
	public int pagarDividas();
	
}
