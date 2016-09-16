package componentes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import execeptions.EmailInvalidoException;
import execeptions.HospedeNaoEncontradoException;
import execeptions.NomeDeAtributoInvalidoException;
import execeptions.NomeInvalidoException;
import execeptions.dataNascimentoInvalidaException;

public class ControlerTest {

	Controler controler;
	
	@Before
	public void setUp() throws Exception {
		controler = new Controler();
		controler.cadastraHospede("Marieta", "marieta@gmail.com", "01/01/1992");
	}

	@Test
	public void testCadastraHospede() throws NomeInvalidoException, EmailInvalidoException, dataNascimentoInvalidaException {
		
		//Caso de criacao Simples
		assertEquals("felipe@gmail.com.br",controler.cadastraHospede("Felipe", "felipe@gmail.com.br", "21/02/1995")	);
		
		//Casos de Exception
		
		try {
			controler.cadastraHospede("    ", "ricardo@hotmail.com.br", "22/03/1996");
			fail("Nao deveria aceitar nome somente com espacos");
		} catch (NomeInvalidoException e) {
			assertEquals("Formato de nome invalido", e.getMessage());
		}
		
		try {
			controler.cadastraHospede(null,"nada@gmail.com", "06/06/1966");
			fail("Nao deveria aceitar nome null");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser vazio ou nulo", e.getMessage());
		}
		
		try {
			controler.cadastraHospede("", "ricardo@hotmail.com.br", "22/03/1996");
			fail("Nao deveria aceitar o nome vazio");
		} catch (NomeInvalidoException e) {
			assertEquals("Nome nao pode ser vazio ou nulo", e.getMessage());
		}
		
		try {
			controler.cadastraHospede("Gabriel", "gabriel@eu", "22/05/1986");	
			fail("O e-mail digital eh invalido.");
		} catch (EmailInvalidoException e) {
			assertEquals("Formato de email invalido", e.getMessage());
		}
		
		try {
			controler.cadastraHospede("Ronaldo", "", "22/05/1986");	
			fail("O e-mail nao deveria ser aceito, jah que eh vazio");
		} catch (EmailInvalidoException e) {
			assertEquals("email nao pode ser vazio ou nulo", e.getMessage());
		}
		
		try {
			controler.cadastraHospede("Pedrinho", null, "22/05/1986");	
			fail("O e-mail nao deveria ser aceito, jah que eh null");
		} catch (EmailInvalidoException e) {
			assertEquals("email nao pode ser vazio ou nulo", e.getMessage());
		}
		
		try {
			controler.cadastraHospede("Osho", "     ", "22/05/1986");	
			fail("O e-mail nao deveria ser aceito, jah que possui somente espacos");
		} catch (EmailInvalidoException e) {
			assertEquals("Formato de email invalido", e.getMessage());
		}
		
		try {
			controler.cadastraHospede("Amanda", "amanda@google.com.br", "555/03/01000");
			fail("Nao deveria aceitar essa data");
		} catch (NomeInvalidoException e) {
			assertEquals("Formato de data invalido", e.getMessage());
		}
	}

	@Test
	public void testGetInfoHospede() throws NomeDeAtributoInvalidoException, HospedeNaoEncontradoException {
		assertEquals("Marieta", controler.getInfoHospede("marieta@gmail.com", "nome"));
		assertEquals("01/01/1992", controler.getInfoHospede("marieta@gmail.com", "Data de Nascimento"));
	}

	@Test
	public void testAtualizaCadastro() throws EmailInvalidoException, NomeInvalidoException, dataNascimentoInvalidaException, NomeDeAtributoInvalidoException, HospedeNaoEncontradoException {
		controler.atualizaCadastro("marieta@gmail.com","nome", "Mario");
		assertEquals("Mario", controler.getInfoHospede("marieta@gmail.com", "nome"));
	}

	@Test
	public void testRemoveHospede() throws HospedeNaoEncontradoException {
		controler.removeHospede("marieta@gmail.com");
		assertEquals(null, controler.buscaHospede("marieta@gmail.com"));
	}

	@Test
	public void testBuscaHospede() throws HospedeNaoEncontradoException {
		Hospede marieta = controler.buscaHospede("marieta@gmail.com");
		assertEquals("Marieta",marieta.getNome());
	}

}
