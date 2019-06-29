package it.unicam.cs.pa.mastermind.gamecore;

import it.unicam.cs.pa.mastermind.factories.ConsoleGameViewFactory;
import it.unicam.cs.pa.mastermind.factories.GameViewFactory;
import it.unicam.cs.pa.mastermind.ui.ConsoleStartView;
import it.unicam.cs.pa.mastermind.ui.StartView;

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
	protected StartView getStartViewInstance() {
		return ConsoleStartView.getInstance();
	}

	@Override
	protected GameViewFactory getGameViewFactory() {
		return new ConsoleGameViewFactory();
	}

	/**
	 * Metodo main fondamentale per l'avvio
	 * @param args
	 */
	public static void main(String[] args) {
		ConsoleMainManager main = new ConsoleMainManager();
		main.startUp();
	}
}
