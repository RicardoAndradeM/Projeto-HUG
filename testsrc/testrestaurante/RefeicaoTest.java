package testrestaurante;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.valordeatributoinvalido.NomeInvalidoException;
import exceptions.valordeatributoinvalido.PrecoInvalidoException;
import exceptions.valordeatributoinvalido.ValorDeAtributoInvalidoException;
import restaurante.Prato;
import restaurante.Refeicao;

public class RefeicaoTest {
	Prato macarrao;
	Prato sorvete;
	Prato batataDoce;
	Prato frango;
	
	@Before
	public void setUp() throws Exception {
		macarrao = new Prato("macarrao simples", 5.00, "macarrao gostoso");
		sorvete = new Prato("sorvete kibon", 4.00, "kibon que vc vai comprar");
		batataDoce = new Prato("comida de monstro", 6.00, "carboidrato puro");
		frango = new Prato("frango desfiado", 5.00, "proteinas a mil");
		
		Refeicao frangao = new Refeicao("frangao2000", "frango ate o amanhecer!", frango, frango, frango);
		Refeicao frangao2 = new Refeicao("frangao2000", "frango ate o amanhecer!", frango, frango, frango, frango);
	}

	@Test
	public void testRefeicaoStringStringPratoPratoPrato() throws NomeInvalidoException, PrecoInvalidoException, ValorDeAtributoInvalidoException {
		try {
			Refeicao paraMaromba = new Refeicao("", "para ficar grandao", frango, frango, batataDoce);
			fail("deveria ter retornado uma AtributoInvalidoException");
		} catch (ValorDeAtributoInvalidoException e) {
			assertEquals("Nome invalido", e.getMessage());
		}
	
	
	try {
			Refeicao paraMaromba = new Refeicao("Preparem-se marombas", "", frango, frango, batataDoce);
			fail("deveria ter retornado uma AtributoInvalidoException");
		} catch (ValorDeAtributoInvalidoException e) {
			assertEquals("Descricao invalida", e.getMessage());
		}
	
	try {
		Refeicao paraMaromba = new Refeicao("Preparem-se marombas", "para ficar grandao", null, frango, batataDoce);
		fail("deveria ter retornado uma AtributoInvalidoException");
	} catch (ValorDeAtributoInvalidoException e) {
		assertEquals("O prato indicado nao eh um prato valido", e.getMessage());
	}
	
	try {
		Refeicao paraMaromba = new Refeicao("Preparem-se marombas", "para ficar grandao", frango, null, batataDoce);
		fail("deveria ter retornado uma AtributoInvalidoException");
	} catch (ValorDeAtributoInvalidoException e) {
		assertEquals("O prato indicado nao eh um prato valido", e.getMessage());
	}
	
	try {
		Refeicao paraMaromba = new Refeicao("Preparem-se marombas", "para ficar grandao", frango, frango, null);
		fail("deveria ter retornado uma AtributoInvalidoException");
	} catch (ValorDeAtributoInvalidoException e) {
		assertEquals("O prato indicado nao eh um prato valido", e.getMessage());
	}
	
	}
	
	
	@Test
	public void testRefeicaoStringStringPratoPratoPratoPrato() {
		try {
			Refeicao paraMaromba = new Refeicao("", "para ficar grandao", frango, frango, batataDoce, batataDoce);
			fail("deveria ter retornado uma AtributoInvalidoException");
		} catch (ValorDeAtributoInvalidoException e) {
			assertEquals("Nome invalido", e.getMessage());
		}
	
	
	try {
			Refeicao paraMaromba = new Refeicao("Preparem-se marombas", "", frango, frango, batataDoce, batataDoce);
			fail("deveria ter retornado uma AtributoInvalidoException");
		} catch (ValorDeAtributoInvalidoException e) {
			assertEquals("Descricao invalida", e.getMessage());
		}
	
	try {
		Refeicao paraMaromba = new Refeicao("Preparem-se marombas", "para ficar grandao", null, frango, batataDoce, batataDoce);
		fail("deveria ter retornado uma AtributoInvalidoException");
	} catch (ValorDeAtributoInvalidoException e) {
		assertEquals("O prato indicado nao eh um prato valido", e.getMessage());
	}
	
	try {
		Refeicao paraMaromba = new Refeicao("Preparem-se marombas", "para ficar grandao", frango, null, batataDoce, batataDoce);
		fail("deveria ter retornado uma AtributoInvalidoException");
	} catch (ValorDeAtributoInvalidoException e) {
		assertEquals("O prato indicado nao eh um prato valido", e.getMessage());
	}
	
	try {
		Refeicao paraMaromba = new Refeicao("Preparem-se marombas", "para ficar grandao", frango, frango, null, batataDoce);
		fail("deveria ter retornado uma AtributoInvalidoException");
	} catch (ValorDeAtributoInvalidoException e) {
		assertEquals("O prato indicado nao eh um prato valido", e.getMessage());
	}
	
	try {
		Refeicao paraMaromba = new Refeicao("Preparem-se marombas", "para ficar grandao", frango, frango, batataDoce, null);
		fail("deveria ter retornado uma AtributoInvalidoException");
	} catch (ValorDeAtributoInvalidoException e) {
		assertEquals("O prato indicado nao eh um prato valido", e.getMessage());
	}
	
	}

	@Test
	public void testGetValor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNome() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDescricao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNome() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDescricao() {
		fail("Not yet implemented");
	}

	@Test
	public void testAutualizaPrato() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

}
