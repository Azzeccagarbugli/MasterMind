package it.unicam.cs.pa.mastermind.gamecore;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * <b>Responsabilità</b>: gestione dello svolgimento di una singola partita di
 * gioco.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class SingleMatch {

	/**
	 * Il controllore associato con l'istanza di partita in corso.
	 */
	private BoardController controller;

	/**
	 * Il giocatore Maker che costruirà la sequenza da indovinare.
	 */
	private CodeMaker maker;

	/**
	 * Il giocatore Breaker che decodificherà la sequenza da indovinare.
	 */
	private CodeBreaker breaker;

	/**
	 * Istanza della particolare implementazione di <code>InteractionView</code>
	 * scelta per l'istanza di partita in corso.
	 */
	private InteractionView interactionView;

	/**
	 * Oggetto contenente informazioni relative al vincitore della partita in corso.
	 */
	CurrentGameStats gameStats;

	/**
	 * Costruttore di una singola partita
	 * 
	 * @param sequenceLength relativa alle sequenze di <code>CodePegs</code>
	 *                       impiegate nella partita.
	 * @param attempts       massimi per il giocatore Breaker per indovinare.
	 * @param view           Istanza della particolare implementazione di
	 *                       <code>InteractionView</code> scelta per l'istanza di
	 *                       partita in corso.
	 * @param currentBreaker istanza del giocatore che decodifica.
	 * @param currentMaker   istanza del giocatore che codifica.
	 */
	public SingleMatch(int sequenceLength, int attempts, InteractionView view, CodeBreaker currentBreaker,
			CodeMaker currentMaker) {
		this.maker = currentMaker;
		this.breaker = currentBreaker;
		this.controller = new BoardController(new BoardModel(sequenceLength, attempts));
		this.gameStats = new CurrentGameStats(this.controller.getBoardReference());
		this.interactionView = view;
		this.interactionView.addSubject(this.controller.getBoardReference());
	}

	/**
	 * Avvio e gestione completa di una singola partita di gioco.
	 */
	public void start() {
		controller.insertCodeToGuess(interactionView.getCodeToGuess(this.maker));
		do {
			controller.insertNewAttempt(interactionView.getAttempt(this.breaker));
			if (this.breaker.hasGivenUp()) {
				gameStats.toggleMakerWin();
			}
		} while (!(gameStats.getHasMakerWon() || gameStats.getHasBreakerWon()));
		interactionView.endingScreen(gameStats.getMessage());
	}

}
