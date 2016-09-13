package controllers;

import java.util.HashSet;
import componentes.Hospede;

public class HospedeController {
	private HashSet<Hospede>hospedes;
	
	public void HospedeFacace(){
		hospedes = new HashSet<Hospede>();
	}
	
	// Se for adicionado o mesmo hospede duas vezes, o segundo será adicionado da mesma forma.
	// Decidir se informar caso o hospede repetir
	
	public Hospede cadastraHospede(String nome, String email, String dataNascimento){
		Hospede novoHospede = new Hospede(nome, email, dataNascimento);
		hospedes.add(novoHospede);
		return novoHospede;
	}
	
	public Hospede buscaHospede(String email){
		for (Hospede hospede : hospedes){
			if (hospede.getEmail().equals(email)){
				return hospede;
			}
		}
		return null;
	}
	
	/*public String getInfoHospede(Hospede id, String atributo){
		
	}
	*/
	
	//public boolean atualizaCadastro()
	
	public boolean removeHospede(String email){
		Hospede hospede = buscaHospede(email);
		return hospedes.remove(hospede);
	}
	
}
