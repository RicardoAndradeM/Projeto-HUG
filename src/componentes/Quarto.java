package componentes;

import execeptions.NomeDeAtributoInvalidoException;
import enums.TipoDeQuarto;

public class Quarto {
	private String numeroQuarto;
	private TipoDeQuarto tipo ;
	
	
	public Quarto(String numeroQuarto, TipoDeQuarto tipo ) throws NomeDeAtributoInvalidoException{
		if(numeroQuarto == null || numeroQuarto.equals("")){
			throw new NomeDeAtributoInvalidoException("Quarto invalido");
		}
		this.numeroQuarto = numeroQuarto;
	}

	public String getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	} 
	
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
