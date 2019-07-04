package it.unicam.cs.pa.mastermind.gamecore;

import it.unicam.cs.pa.mastermind.factories.ConsoleGameViewFactory;
import it.unicam.cs.pa.mastermind.factories.ConsoleStartViewFactory;
import it.unicam.cs.pa.mastermind.factories.GameViewFactory;
import it.unicam.cs.pa.mastermind.factories.StartViewFactory;

/**
 * Implementazione di <code>MainManager</code> correlata ad implementazioni di
 * <code>GameView</code> e <code>StartView</code> basate su interazione via
 * console.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class ConsoleMainManager extends MainManager {

	@Override
	protected StartViewFactory getStartViewFactory() {
		return new ConsoleStartViewFactory();
	}

	@Override
	protected GameViewFactory getGameViewFactory() {
		return new ConsoleGameViewFactory();
	}

	/**
	 * Metodo main fondamentale per l'avvio, richiesto dal contratto di
	 * <code>MainManager</code>.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ConsoleMainManager main = new ConsoleMainManager();
		main.startUp();
	}
}
