package it.unicam.cs.pa.mastermind.gamecore;

import it.unicam.cs.pa.mastermind.factories.BreakerFactory;
import it.unicam.cs.pa.mastermind.factories.GameViewFactory;
import it.unicam.cs.pa.mastermind.factories.MakerFactory;
import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.ui.GameView;

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
	private GameView view;

	/**
	 * Oggetto contenente informazioni relative al vincitore della partita in corso.
	 */
	MatchState gameState;

	/**
	 * Costruttore di una singola partita
	 * 
	 * @param sequenceLength relativa alle sequenze di <code>CodePegs</code>
	 *                       impiegate nella partita.
	 * @param attempts       massimi per il giocatore Breaker per indovinare.
	 * @param view           Istanza della particolare implementazione di
	 *                       <code>InteractionView</code> scelta per l'istanza di
	 *                       partita in corso.
	 * @param bFactory istanza della <code>BreakerFavctory</code> relativa al giocatore <code>CodeBreaker</code> selezionato per la partita.
	 * @param mFactory istanza della <code>MakerFactory</code> relativa al giocatore <code>CodeMaker</code> selezionato per la partita.
	 */
	public SingleMatch(int sequenceLength, int attempts, GameViewFactory viewFactory, BreakerFactory bFactory,
			MakerFactory mFactory) {
		
		BoardModel newModel = new BoardModel(sequenceLength, attempts);
		this.controller = new BoardController(newModel);
		this.view = viewFactory.getGameView(newModel);
				
		this.maker = mFactory.getMaker(view, sequenceLength, attempts);
		this.breaker = bFactory.getBreaker(view, sequenceLength, attempts);
		
		this.gameState = new MatchState(newModel);
	}

	/**
	 * Avvio e gestione completa di una singola partita di gioco.
	 */
	public void start() {
		controller.insertCodeToGuess(this.maker.getCodeToGuess());
		do {
			this.singleTurn();
		} while (!(gameState.getHasMakerWon() || gameState.getHasBreakerWon()));
		view.endingScreen(gameState.getMessage());
	}

	private void singleTurn() {
		controller.insertNewAttempt(this.breaker.getAttempt());
		if (this.breaker.hasGivenUp()) {
			gameState.toggleMakerWin();
		}
	}
}
