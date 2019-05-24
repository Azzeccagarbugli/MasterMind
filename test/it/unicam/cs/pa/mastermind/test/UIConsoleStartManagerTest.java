package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.ui.ConsoleStartManager;

/**
 * Test di controllo utili al check dell'unica instanza della classe sotto
 * esamina.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class UIConsoleStartManagerTest {

	/**
	 * Test method for {@link it.unicam.cs.pa.mastermind.ui.ConsoleStartManager#getIstance()}.
	 */
	@Test
	void testGetIstance() {
		ConsoleStartManager cs = ConsoleStartManager.getIstance();
		assertNotNull(cs);
	}
	
}
