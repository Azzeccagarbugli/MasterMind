package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.ui.ConsoleStartView;

/**
 * Test di controllo utili al check dell'unica instanza della classe sotto
 * esamina.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class UIConsoleStartManagerTest {

	/**
	 * Test method for {@link it.unicam.cs.pa.mastermind.ui.ConsoleStartView#getIstance()}.
	 */
	@Test
	void testGetIstance() {
		ConsoleStartView cs = ConsoleStartView.getIstance();
		assertNotNull(cs);
	}
	
}
