package it.unicam.cs.pa.mastermind;

/**
 * Rappresentazione concreta di una singola partita a due giocatori
 * 
 * @author Francesco
 *
 */
public class Game {

	private Board board;
	private Starter starter;
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
		this.starter = new Starter();
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
