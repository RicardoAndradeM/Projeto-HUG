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
	Refeicao frangao;
	Refeicao frangao2;
	Refeicao mariaDoFrango;
	
	@Before
	public void setUp() throws Exception {
		macarrao = new Prato("macarrao simples", 5.00, "macarrao gostoso");
		sorvete = new Prato("sorvete kibon", 4.00, "kibon que vc vai comprar");
		batataDoce = new Prato("comida de monstro", 6.00, "carboidrato puro");
		frango = new Prato("frango desfiado", 5.00, "proteinas a mil");
		
		frangao = new Refeicao("frangao2000", "frango ate o amanhecer!", frango, frango, frango);
		frangao2 = new Refeicao("frangao2002", "frango ate o anoitecer do outro dia!", frango, frango, frango, frango);
		mariaDoFrango = new Refeicao("frangao2002", "frango ate o anoitecer do outro dia!", frango, frango, frango, frango);
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
		assertEquals(13.5, frangao.getValor(), 0);
		assertEquals(18, frangao2.getValor(), 0);
	}

	@Test
	public void testGetNome() {
		assertEquals("frangao2000", frangao.getNome());
		assertEquals("frangao2002", frangao2.getNome());
	}

	@Test
	public void testGetDescricao() {
		assertEquals("frango ate o amanhecer!", frangao.getDescricao());
		assertEquals("frango ate o anoitecer do outro dia!", frangao2.getDescricao());
	}

	@Test
	public void testSetNome() {
		frangao.setNome("frangao naruto");
		frangao2.setNome("frangao sasuke");
		
		assertEquals("frangao naruto", frangao.getNome());
		assertEquals("frangao sasuke", frangao2.getNome());
	}

	@Test
	public void testSetDescricao() {
		frangao.setDescricao("frango a bessa");
		frangao2.setDescricao("frango a intermares");
		
		assertEquals("frango a bessa", frangao.getDescricao());
		assertEquals("frango a intermares", frangao2.getDescricao());;
	}

	@Test
	public void testAutualizaPrato() {
		frangao.autualizaPrato(0, batataDoce);
		frangao.getPrato(0);
	}

	@Test
	public void testEqualsObject() {
		assertEquals(mariaDoFrango, frangao2);
	}

}
