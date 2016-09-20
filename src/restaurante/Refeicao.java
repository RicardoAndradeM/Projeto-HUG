package restaurante;

import java.util.ArrayList;

import exceptions.NomeDeAtributoInvalidoException;

public class Refeicao {
	private String nome;
	private String descricao;
	private ArrayList<Prato> pratos;
	
	
	
	public Refeicao(String nome, String descricao, Prato primeiroPrato, Prato segundoPrato, Prato terceiroPrato) throws NomeDeAtributoInvalidoException {
		
		this.nome = nome;
		this.descricao = descricao;
		pratos = new ArrayList<Prato>();
		
		if(nome == null|| nome.equals("")){
			throw new NomeDeAtributoInvalidoException("Nome invalido");
		}
		if( descricao == null || descricao.equals("")){
			throw new NomeDeAtributoInvalidoException("Descricao invalida");
		}
		pratos.add(primeiroPrato);
		pratos.add(segundoPrato);
		pratos.add(terceiroPrato);
	}
	
	public Refeicao(String nome, String descricao, Prato primeiroPrato, Prato segundoPrato, Prato terceiroPrato, Prato quartoPrato) throws NomeDeAtributoInvalidoException {
		
		this.nome = nome;
		this.descricao = descricao;
		pratos = new ArrayList<Prato>();
		
		if(nome == null|| nome.equals("")){
			throw new NomeDeAtributoInvalidoException("Nome invalido");
		}
		if( descricao == null || descricao.equals("")){
			throw new NomeDeAtributoInvalidoException("Descricao invalida");
		}
		pratos.add(primeiroPrato);
		pratos.add(segundoPrato);
		pratos.add(terceiroPrato);
		pratos.add(quartoPrato);
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public double getValor(){
		double valor = 0;
		for (Prato prato : pratos) {
			valor += prato.getPreco();
		}
		return valor - (valor*0.1);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void autualizaPrato(int posicaoPrato, Prato prato){
		pratos.add(posicaoPrato, prato);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pratos == null) ? 0 : pratos.hashCode());
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
		Refeicao other = (Refeicao) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pratos == null) {
			if (other.pratos != null)
				return false;
		} else if (!pratos.equals(other.pratos))
			return false;
		return true;
	}

}
