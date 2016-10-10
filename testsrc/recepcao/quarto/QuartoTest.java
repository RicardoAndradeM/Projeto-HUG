package recepcao.quarto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import recepcao.exception.QuartoDesocupadoException;
import recepcao.exception.QuartoOcupadoException;

/**
 * @author Ricardo Andrade
 * @since 10/10/2016
 */
public class QuartoTest {
	Quarto q;
	
	@Before
	public void setup(){
		this.q =  new Quarto("a1", TipoDeQuarto.SIMPLES);
	}
	
	@Test
	public void testQuarto() {
		assertEquals(q, new Quarto("a1", TipoDeQuarto.SIMPLES));
	}

	@Test
	public void testRecebeEstadia() throws QuartoOcupadoException {
		q.recebeEstadia(new Estadia("rovert@bol.com", 10));
		
		try {
			q.recebeEstadia(new Estadia("albertot@hotmail.com", 20));
			fail("Nao deveria aceitar novas estadias quando quarto esta ocupado");
		} catch (QuartoOcupadoException e) {
			assertEquals("Quarto a1 ja esta ocupado.", e.getMessage());
		}
	}

	@Test
	public void testDevolveEstadia() throws QuartoOcupadoException, QuartoDesocupadoException {
		q.recebeEstadia(new Estadia("rovert@bol.com", 10));
		
		assertEquals(new Estadia("rovert@bol.com", 10), q.devolveEstadia());
		
		try {
			q.devolveEstadia();
			fail("Deveria ter lancado Exception pois o quarto jah nao esta ocupado");
		} catch (QuartoDesocupadoException e) {
			assertEquals("Quarto a1 nao esta ocupado.", e.getMessage());
		}
	}

	@Test
	public void testCalculaValor() throws QuartoOcupadoException, QuartoDesocupadoException {
		q.recebeEstadia(new Estadia("rovert@bol.com", 10));
		
		assertEquals(1000, q.calculaValor(),0);
		
		q.devolveEstadia();
		q.recebeEstadia(new Estadia("albertot@hotmail.com", 12));
		assertEquals(1200, q.calculaValor(),0);
		
		q.devolveEstadia();
		try {
			q.devolveEstadia();
		} catch (QuartoDesocupadoException e) {
			assertEquals("Quarto a1 nao esta ocupado.", e.getMessage());
		}
	}

}
