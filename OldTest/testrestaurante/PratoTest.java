package testrestaurante;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import restaurante.Prato;
import exceptions.valordeatributoinvalido.ValorDeAtributoInvalidoException;
public class PratoTest {

	Prato macarraoIntegral;
	
	@Before
	public void setUp() throws Exception {
		macarraoIntegral = new Prato("Macarrone", 7.00,"Super bom" );
	}
		
	@Test(expected = ValorDeAtributoInvalidoException.class)
		public void testPrato() throws Exception{
		Prato McLanche = new Prato("", 50.0, "Acabe com sua saude");
		Prato BurgerBomb = new Prato(null, 50.0, "Exploda sua saude");
	}

	@Test
	public void testGetNome() {
		assertEquals("Macarrone", macarraoIntegral.getNome());
	}

	@Test
	public void testSetNome() {
		macarraoIntegral.setNome("PeiPou");
		assertEquals("PeiPou", macarraoIntegral.getNome());
	}

	@Test
	public void testGetPreco() {
		assertEquals(7.00, macarraoIntegral.getPreco(), 0);
	}

	@Test
	public void testSetPreco() {
		macarraoIntegral.setPreco(55.0);
		assertEquals(55.0, macarraoIntegral.getPreco(), 0);
		
	}

	@Test
	public void testGetDescricao() {
		assertEquals("Super bom", macarraoIntegral.getDescricao());
	}

	@Test
	public void testSetDescricao() {
		macarraoIntegral.setDescricao("Bomzaum");
		assertEquals("Bomzaum", macarraoIntegral.getDescricao());
	}

}
