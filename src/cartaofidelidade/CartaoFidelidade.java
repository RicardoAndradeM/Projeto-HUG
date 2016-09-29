package cartaoFidelidade;

public interface CartaoFidelidade {
	
	public int adicionarPontos(double valor);
	public double aplicarDesconto(double valor);
	public int pagarDividas();
	
}
