package it.unicam.cs.pa.mastermind.core;

import it.unicam.cs.pa.mastermind.gui.InteractionManager;
import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;

/**
 * Rappresentazione concreta di una singola partita a due giocatori
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class SingleGame {

	private Board board;
	private Coordinator coordinator;
	private CodeMaker maker;
	private CodeBreaker breaker;
	private InteractionManager manager;

	/**
	 * Inizializza un nuovo gioco con un giocatore che codifica e un giocatore che
	 * decodifica
	 * 
	 * @param maker
	 * @param breaker
	 * @param sequenceLength
	 * @param attempts
	 */
	public SingleGame(CodeMaker maker, CodeBreaker breaker, int sequenceLength, int attempts,
			InteractionManager manager) {
		this.maker = maker;
		this.breaker = breaker;
		this.board = new Board(sequenceLength, attempts);
		this.coordinator = new Coordinator();
		this.manager = manager;
	}

	/**
	 * Avvio effettivo di una singola partita. Il metodo restituisce un array con
	 * due valori booleani, che indicano la volontà di iniziare o meno una nuova
	 * partita e la volontà di iniziarla con altre impostazioni
	 * 
	 * @return
	 */
	public boolean[] start() {
		coordinator.insertCodeToGuess(maker.getCodeToGuess(board.getSequenceLength(), manager), board);
		while (!coordinator.checkEnd(breaker, board)) {
			manager.showGame(this.board);
			coordinator.insertNewAttempt(breaker.getCode(board.getSequenceLength(), manager), board);
		}
		return manager.ending();
	}

}
