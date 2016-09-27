package testrecepcao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.naocadastrado.HospedeNaoEncontradoException;
import exceptions.naocadastrado.NaoCadastradoException;
import exceptions.valordeatributoinvalido.DataNascimentoInvalidaException;
import exceptions.valordeatributoinvalido.EmailInvalidoException;
import exceptions.valordeatributoinvalido.NomeDeAtributoInvalidoException;
import exceptions.valordeatributoinvalido.NomeInvalidoException;
import exceptions.valordeatributoinvalido.ValorDeAtributoInvalidoException;
import recepcao.ControlerRecepcao;
import recepcao.Hospede;

public class ControlerRecepcaoTest {

	ControlerRecepcao controler;
	
	@Before
	public void setUp() throws Exception {
		controler = new ControlerRecepcao();
		controler.cadastraHospede("Marieta", "marieta@gmail.com", "01/01/1992");
	}

	@Test
	public void testCadastraHospede() throws NomeInvalidoException, EmailInvalidoException, DataNascimentoInvalidaException {
		
		//Caso de criacao Simples
		assertEquals("felipe@gmail.com.br",controler.cadastraHospede("Felipe", "felipe@gmail.com.br", "21/02/1995")	);
		
		//Casos de Exception
		
		try {
			controler.cadastraHospede("    ", "ricardo@hotmail.com.br", "22/03/1996");
			fail("Nao deveria aceitar nome somente com espacos");
		} catch (NomeInvalidoException e) {
			assertEquals("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.", e.getMessage());
		}
		
		try {
			controler.cadastraHospede(null,"nada@gmail.com", "06/06/1966");
			fail("Nao deveria aceitar nome null");
		} catch (Exception e) {
			assertEquals("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.", e.getMessage());
		}
		
		try {
			controler.cadastraHospede("", "ricardo@hotmail.com.br", "22/03/1996");
			fail("Nao deveria aceitar o nome vazio");
		} catch (NomeInvalidoException e) {
			assertEquals("Erro no cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.", e.getMessage());
		}
		
		try {
			controler.cadastraHospede("Gabriel", "gabriel@eu", "22/05/1986");	
			fail("Deveri ter retornado uma Exception, parceiro.");
		} catch (ValorDeAtributoInvalidoException e) {
			assertEquals("Erro no cadastro de Hospede. Email do(a) hospede esta invalido.", e.getMessage());
		}
		
		try {
			controler.cadastraHospede("Ronaldo", "", "22/05/1986");	
			fail("O e-mail nao deveria ser aceito, jah que eh vazio");
		} catch (ValorDeAtributoInvalidoException e) {
			assertEquals("Erro no cadastro de Hospede. Email do(a) hospede nao pode ser vazio.", e.getMessage());
		}
		
		try {
			controler.cadastraHospede("Pedrinho", null, "22/05/1986");	
			fail("O e-mail nao deveria ser aceito, jah que eh null");
		} catch (ValorDeAtributoInvalidoException e) {
			assertEquals("Erro no cadastro de Hospede. Email do(a) hospede nao pode ser vazio.", e.getMessage());
		}
		
		try {
			controler.cadastraHospede("Osho", "     ", "22/05/1986");	
			fail("O e-mail nao deveria ser aceito, jah que possui somente espacos");
		} catch (ValorDeAtributoInvalidoException e) {
			assertEquals("Erro no cadastro de Hospede. Email do(a) hospede nao pode ser vazio.", e.getMessage());
		}
		
		try {
			controler.cadastraHospede("Amanda", "amanda@google.com.br", "555/03/01000");
			fail("Nao deveria aceitar essa data");
		} catch (NomeInvalidoException e) {
			assertEquals("Erro no cadastro de Hospede. Formato de data invalido.", e.getMessage());
		}
	}

	@Test
	public void testGetInfoHospede() throws NomeDeAtributoInvalidoException, HospedeNaoEncontradoException {
		assertEquals("Marieta", controler.getInfoHospede("marieta@gmail.com", "nome"));
		assertEquals("01/01/1992", controler.getInfoHospede("marieta@gmail.com", "Data de Nascimento"));
	}

	@Test
	public void testAtualizaCadastro() throws EmailInvalidoException, NomeInvalidoException, DataNascimentoInvalidaException, NomeDeAtributoInvalidoException, HospedeNaoEncontradoException {
		controler.atualizaCadastro("marieta@gmail.com","nome", "Mario");
		assertEquals("Mario", controler.getInfoHospede("maormato de data invalidrieta@gmail.com", "nome"));
	}

	@Test
	public void testRemoveHospede() throws HospedeNaoEncontradoException, EmailInvalidoException {
		controler.removeHospede("marieta@gmail.com");
		try {
			assertEquals(null, controler.buscaHospede("marieta@gmail.com"));
			fail("Deveria ter retornado uma Exception");
		} catch (NaoCadastradoException e) {
			assertEquals("Erro na consulta de hospede. Hospede de email marieta@gmail.com nao foi cadastrado(a).", e.getMessage());
		}
	}

	@Test
	public void testBuscaHospede() throws HospedeNaoEncontradoException {
		Hospede marieta = controler.buscaHospede("marieta@gmail.com");
		assertEquals("Marieta",marieta.getNome());
	}

}