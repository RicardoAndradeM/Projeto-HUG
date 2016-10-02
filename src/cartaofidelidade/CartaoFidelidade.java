package cartaofidelidade;

public abstract class CartaoFidelidade {
	public int pontos;
	
	public abstract void adicionaPontos(double valor);
	
	public abstract double aplicaDesconto(double valor);
	
	public int getPontos(){
		return this.pontos;
	}
	
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
}
