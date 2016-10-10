package recepcao.quarto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Ricardo Andrade
 * @since 10/10/2016
 */
public class FactoryDeQuartoTest {
	private FactoryDeQuarto h;
	private Quarto q;
	private final String NUMERO = "a1";
	private final TipoDeQuarto TIPO = TipoDeQuarto.SIMPLES;
	
	@Before
	public void setup(){
		h = new FactoryDeQuarto();
		q = new Quarto(NUMERO, TIPO);
	}
	
	@Test
	public void testCriaQuarto() {
		assertEquals(q, h.criaQuarto(NUMERO, TIPO));
	}

}
