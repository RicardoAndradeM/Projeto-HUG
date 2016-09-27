package recepcao;

import enums.TipoDeQuarto;
import exceptions.valordeatributoinvalido.NomeDeAtributoInvalidoException;

/** 
 * Classe que representa um quarto
 * @since 15/09/16
 */
public class Quarto {
	private String numeroQuarto;
	private TipoDeQuarto tipo ;
	
	public Quarto(String numeroQuarto, TipoDeQuarto tipo ) throws NomeDeAtributoInvalidoException{
		if(numeroQuarto == null || numeroQuarto.equals("")){
			throw new NomeDeAtributoInvalidoException("Quarto invalido");
		}
		this.numeroQuarto = numeroQuarto;
		this.tipo = tipo;
	}

	/**
	 * @return retorna numero do quarto
	 */
	public String getNumeroQuarto() {
		return numeroQuarto;
	}

	/** altera numero do quarto
	 * @param numeroQuarto novo numero do quarto
	 */
	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	} 
	
	/** 
	 * @return retorna o valor do quarto
	 */
	public double getValorDoQuarto(){
		return tipo.getPreco();
	}
	
	@Override
	public String toString() {
		return "Quarto [numeroQuarto=" + numeroQuarto + ", tipo=" + tipo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroQuarto == null) ? 0 : numeroQuarto.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quarto other = (Quarto) obj;
		if (numeroQuarto == null) {
			if (other.numeroQuarto != null)
				return false;
		} else if (!numeroQuarto.equals(other.numeroQuarto))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
}
