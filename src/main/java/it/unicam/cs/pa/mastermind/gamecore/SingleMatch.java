package it.unicam.cs.pa.mastermind.gamecore;

import it.unicam.cs.pa.mastermind.factories.BreakerFactory;
import it.unicam.cs.pa.mastermind.factories.InteractionViewFactory;
import it.unicam.cs.pa.mastermind.factories.MakerFactory;
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
	 * @param bFactory istanza della <code>BreakerFavctory</code> relativa al giocatore <code>CodeBreaker</code> selezionato per la partita.
	 * @param mFactory istanza della <code>MakerFactory</code> relativa al giocatore <code>CodeMaker</code> selezionato per la partita.
	 */
	public SingleMatch(int sequenceLength, int attempts, InteractionViewFactory viewFactory, BreakerFactory bFactory,
			MakerFactory mFactory) {
		BoardModel newModel = new BoardModel(sequenceLength, attempts);
		this.controller = new BoardController(newModel);
		this.interactionView = viewFactory.getIntView(newModel);
				
		this.maker = mFactory.getMaker(interactionView, sequenceLength, attempts);
		this.breaker = bFactory.getBreaker(interactionView, sequenceLength, attempts);
		
		this.gameStats = new CurrentGameStats(newModel);
	}

	/**
	 * Avvio e gestione completa di una singola partita di gioco.
	 */
	public void start() {
		controller.insertCodeToGuess(this.maker.getCodeToGuess());
		do {
			controller.insertNewAttempt(this.breaker.getAttempt());
			// Result result = controller.insertNewAttempt(this.breaker.getNextAttempt());
			// this.breaker.setResultOfLastAttempt(result);
			if (this.breaker.hasGivenUp()) {
				gameStats.toggleMakerWin();
			}
		} while (!(gameStats.getHasMakerWon() || gameStats.getHasBreakerWon()));
		//notifica ai player!
		interactionView.endingScreen(gameStats.getMessage());
	}

}
