package it.unicam.cs.pa.mastermind.gamecore;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * Rappresentazione concreta di una singola partita a due giocatori.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class SingleGame {

	/**
	 * Variabile che descrive il BoardCoordinator.
	 */
	private BoardController controller;

	/**
	 * Variabile che inizializza il player che costruirà la sequenza da indovinare.
	 */
	private CodeMaker maker;

	/**
	 * Variabile che inizializza il player che decodificherà la sequenza da
	 * indovinare.
	 */
	private CodeBreaker breaker;

	/**
	 * Manager con il quale si andranno a determinare le varie interazioni con il
	 * gioco.
	 */
	private InteractionView interactionView;

	/**
	 * Oggetto contenente informazioni relative al vincitore della partita in corso.
	 */
	CurrentGameStats winStats;

	/**
	 * Inizializza un nuovo gioco con un player che codifica e un player che
	 * decodifica.
	 * 
	 * @param currentMaker          player addetto alla creazione della sequenza da
	 *                       indovinare
	 * @param currentBreaker        player addetto alla risoluzione della sequenza da
	 *                       indovinare
	 * @param sequenceLength la lunghezza di tale sequenza
	 * @param attempts       il numero di tentativi concessi
	 * @param view           entità relativa alla gestione delle interazioni con gli
	 *                       utenti fisici
	 */
	public SingleGame(int sequenceLength, int attempts, InteractionView view, CodeBreaker currentBreaker,
			CodeMaker currentMaker) {
		this.maker = currentMaker;
		this.breaker = currentBreaker;
		this.controller = new BoardController(new BoardModel(sequenceLength, attempts));
		this.winStats = new CurrentGameStats(this.controller.getBoardReference());
		this.interactionView = view;
		this.interactionView.addSubject(this.controller.getBoardReference());
	}

	/**
	 * Avvio effettivo di una singola partita. Il metodo di natura void esegue il
	 * setup della partita e inizializza il tutto per permettere di eseguire la
	 * partita.
	 * 
	 */
	public void start() {
		controller.insertCodeToGuess(maker.getCodeToGuess(this.interactionView));
		do {
			controller.insertNewAttempt(breaker.getAttempt(this.interactionView));
			if (this.breaker.hasGivenUp()) {
				winStats.toggleMakerWin();
			}
		} while (!(winStats.getHasMakerWon() || winStats.getHasBreakerWon()));
		interactionView.endingScreen(winStats.getMessage(), this.interactionView.getCurrentSequenceToGuess());
	}

}
