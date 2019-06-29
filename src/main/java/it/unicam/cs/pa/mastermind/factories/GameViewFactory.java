package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
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
	 * <b>Contratto</b>: il metodo deve avere come argomento un riferimento ad un
	 * oggetto BoardModel in quanto l'istanza restituita appartiene al pattern
	 * <b>Observer</b> in cui è coinvolto BoardModel.
	 * 
	 * @param subject l'istanza fondamentale per il pattern <b>Observer</b>
	 * @return GameView istanza richiesta
	 */
	public default GameView getGameView(BoardModel subject) {
		GameView newInstance = getNewInstance();
		newInstance.addSubject(subject);
		return newInstance;
	}

	/**
	 * 
	 * @return GameView nuova istanza di <code>GameView</code> a cui non è stato
	 *         aggiunto il soggetto da osservare secondo il pattern <b>Observer</b>
	 */
	public GameView getNewInstance();
}
