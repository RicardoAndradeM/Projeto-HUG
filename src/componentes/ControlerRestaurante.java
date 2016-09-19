package componentes;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.NaoCadastradoException;
import exceptions.jacadastrado.JaCadastradoException;

public class ControlerRestaurante {
	private final String NOME = "nome";
	private final String DESCRICAO = "descricao";
	private final String PRECO = "preco";
	
	private HashMap<String, Prato> pratos;
	private ArrayList<Refeicao> refeicoes;
	
	public ControlerRestaurante(){
		pratos = new HashMap<String, Prato>();
		refeicoes = new ArrayList<Refeicao>();
	}
	
	public boolean cadastraPrato(String nome, double preco, String descricao) throws Exception{
			if (! (pratos.get(nome)==null)){
				throw new JaCadastradoException("prato jah esta cadastrado");
				
			}else{
				Prato novoPrato = new Prato(nome, preco, descricao);
				pratos.put(nome, novoPrato);
				return true;
			}
	}
	
	public boolean cadastraRefeicao(String nome, String descricao, Prato primeiroPrato, Prato segundoPrato, Prato terceiroPrato) throws Exception{
			if (! (buscaRefeicao(nome)==null)){
				throw new JaCadastradoException("Refeicao jah esta cadastrada");
			}else{
				Refeicao novaRefeicao = new Refeicao(nome, descricao, primeiroPrato,segundoPrato, terceiroPrato);
				refeicoes.add(novaRefeicao);
				return true;
			}
	}
	
	public boolean cadastraRefeicao(String nome, String descricao, Prato primeiroPrato, Prato segundoPrato, Prato terceiroPrato, Prato quartoPrato) throws Exception{
		if (! (buscaRefeicao(nome)==null)){
			throw new JaCadastradoException("Refeicao jah esta cadastrada");
		}else{
			Refeicao novaRefeicao = new Refeicao(nome, descricao, primeiroPrato,segundoPrato, terceiroPrato, quartoPrato);
			refeicoes.add(novaRefeicao);
			return true;
		}
	}
	
	public boolean atualizaPrato(String nomePrato, String atributo, String valor) throws Exception{
		Prato prato = pratos.get(nomePrato);
		
		if (pratos.get(nomePrato)==null){
			throw new NaoCadastradoException("Prato nao existe");
		}
		
		if (atributo.equals(NOME)){
			prato.setNome(valor);
			return true;
		}else if (atributo.equals(DESCRICAO)){
			prato.setDescricao(valor);
			return true;
		}else if (atributo.equals(PRECO)){
			prato.setPreco(Double.parseDouble(valor));
			return true;
		}
		return false;
	}
	
	public boolean atualizaRefeicao(String nomeRefeicao, String atributo, String valor) throws Exception{
		if (buscaRefeicao(nomeRefeicao)==null){
			throw new NaoCadastradoException("Refeicao nao existe");
		}
		
		Refeicao refeicao = buscaRefeicao(nomeRefeicao);
		
		if (atributo.equals(NOME)){
			refeicao.setNome(valor);
			return true;
		}else if (atributo.equals(DESCRICAO)){
			refeicao.setDescricao(valor);
			return true;
		}
		return false;
	}
	

	
	public Refeicao buscaRefeicao(String nomeRefeicao){
		for (Refeicao refeicao : refeicoes){
			if (refeicao.getNome().equals(nomeRefeicao)){
				return refeicao;
			}
		}
		return null;
	}
	
	public Prato buscaPrato(String nomePrato){
		return pratos.get(nomePrato);
	}
	
	public boolean verificaPrato(String nomePrato){
		if (pratos.get(nomePrato)==null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean verificaRefeicao(String nomeRefeicao){
		if (buscaRefeicao(nomeRefeicao)==null){
			return false;
		}else{
			return true;
		}
	}
	
	public boolean removePrato(String nomePrato) throws Exception{
		if (verificaPrato(nomePrato)){
			pratos.remove(nomePrato);
			return true;
		}else{
			throw new NaoCadastradoException("Prato nao existe");
		}
	}
	
	public boolean removeRefeicao(String nomeRefeicao) throws Exception{
		if (verificaRefeicao(nomeRefeicao)){
			refeicoes.remove(buscaRefeicao(nomeRefeicao));
			return true;
		}
		return false;
	}
}
