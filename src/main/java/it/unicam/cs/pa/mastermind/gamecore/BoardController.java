package it.unicam.cs.pa.mastermind.gamecore;

import java.util.List;

/**
 * <b>Responsabilità</b>: gestire le interazioni dall'esterno e dirette alla
 * modifica di un'istanza <code>BoardModel</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BoardController {

	/**
	 * L'istanza <code>BoardModel</code> che l'istanza di
	 * <code>BoardCoordinator</code> corrente gestisce.
	 */
	private BoardModel board;

	/**
	 * Costruttore
	 * 
	 * @param newBoard la <code>BoardModel</code> che si desidera gestire
	 */
	public BoardController(BoardModel newBoard) {
		this.board = newBoard;
	}

	/**
	 * Metodo che consente l'inserimento di un nuovo tentativo all'interno della
	 * <code>BoardModel</code>.
	 * 
	 * @param attempt la <code>List</code> di <code>ColorPegs</code> contenente i
	 *                valori che si vogliono inserire all'interno della
	 *                <code>BoardModel</code>
	 * @return boolean a rappresentazione dell'esito dell'inserimento
	 */
	public boolean insertNewAttempt(List<ColorPegs> attempt) {
		try {
			board.addAttempt(attempt);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo che consente l'inserimento di una sequenza da indovinare all'interno
	 * della <code>BoardModel</code>.
	 * 
	 * @param toGuess la <code>List</code> di <code>ColorPegs</code> contenente i
	 *                valori che si vogliono inserire come sequenza da indovinare.
	 * @return boolean a rappresentazione dell'esito dell'inserimento
	 */
	public boolean insertCodeToGuess(List<ColorPegs> toGuess) {
		try {
			board.setSequenceToGuess(toGuess);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}


}
