package recepcao.quarto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Ricardo Andrade
 * @since 10/10/2016
 */
public class EstadiaTest {
	Estadia e;
	
	@Before
	public void setup(){
		this.e = new Estadia("robert@uol.com.br", 12);
	}
	
	@Test
	public void testEstadia() {
		assertEquals(new Estadia("robert@uol.com.br", 12), e);
	}

	@Test
	public void testCalculaValor() {
		assertEquals(e.calculaValor(TipoDeQuarto.SIMPLES), 1200,0);
		assertEquals(e.calculaValor(TipoDeQuarto.LUXO), 3000,0);
		assertEquals(e.calculaValor(TipoDeQuarto.PRESIDENCIAL), 5400,0);
	}

}
