package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.ui.GameView;

/**
 * Interfaccia finalizzata all'implementazione di classi factory per le
 * particolari implementazioni della vista <code>GameView</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public interface GameViewFactory {

	/**
	 * Ottenimento di un'istanza di una vista <code>GameView</code>.
	 * 
	 */
	public GameView getGameView();
}
