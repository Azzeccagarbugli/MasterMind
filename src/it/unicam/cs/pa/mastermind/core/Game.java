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
public class Game {

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
	public Game(CodeMaker maker, CodeBreaker breaker, int sequenceLength, int attempts, InteractionManager manager) {
		this.maker = maker;
		this.breaker = breaker;
		this.board = new Board(sequenceLength, attempts);
		this.coordinator = new Coordinator();
		this.manager = manager;
	}

	/**
	 * Avvio effettivo della partita
	 */
	public void start() {
		// TODO
	}

}
