package componentes;

import java.util.ArrayList;

import execeptions.NomeDeAtributoInvalidoException;

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
	
}
