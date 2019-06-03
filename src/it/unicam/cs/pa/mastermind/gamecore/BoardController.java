package it.unicam.cs.pa.mastermind.gamecore;

import java.util.List;

/**
 * La seguente classe <code>BoardController</code> fa parte del modello MVC
 * realizzato ed ha la responsabilità di gestire le interazioni che si
 * svlippuano all'interno della plancia di gioco.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BoardController {

	/**
	 * Board di gioco.
	 */
	private BoardModel board;

	/**
	 * Il costruttore permette di instanziare un nuovo BoardController.
	 * 
	 * @param newBoard la BoardModel che si desidera gestire
	 */
	public BoardController(BoardModel newBoard) {
		this.board = newBoard;
	}

	/**
	 * Metodo che consente l'inserimento di un nuovo tentativo all'interno della
	 * plancia di gioco.
	 * 
	 * @param attempt la <code>List</code> di <code>ColorPegs</code> contenente i
	 *                valori che si vogliono inserire all'interno della plancia
	 * @return un booleano che determina l'esito dell'inserimento
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
	 * della plancia di gioco.
	 * 
	 * @param toGuess la <code>List</code> di <code>ColorPegs</code> contenente i
	 *                valori che si vogliono inserire come sequenza da indovinare.
	 * @return un booleano che determina l'esito dell'inserimento
	 */
	public boolean insertCodeToGuess(List<ColorPegs> toGuess) {
		try {
			board.setSequenceToGuess(toGuess);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo che restituisce la reference della board sulla quale è stato
	 * instaziato il coordinator.
	 * 
	 * @return la <code>BoardModel</code> utilizzata
	 */
	public BoardModel getBoardReference() {
		return this.board;
	}

}
