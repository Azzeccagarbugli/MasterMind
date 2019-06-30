package it.unicam.cs.pa.mastermind.gamecore;

import java.util.List;

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
public class SingleMatch extends Observable implements Observer{

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
	 * Istanza della particolare implementazione di <code>GameView</code> scelta per
	 * l'istanza di partita in corso.
	 */
	private GameView view;

	/**
	 * Oggetto contenente informazioni relative al vincitore della partita in corso.
	 */
	MatchState gameState;

	/**
	 * Copia della sequenza da indovinare nel match corrente
	 */
	List<ColorPegs> sequenceToGuess;
	/**
	 * Costruttore di una singola partita
	 * 
	 * @param sequenceLength relativa alle sequenze di <code>CodePegs</code>
	 *                       impiegate nella partita.
	 * @param attempts       massimi per il giocatore Breaker per indovinare.
	 * @param view           Istanza della particolare implementazione di
	 *                       <code>InteractionView</code> scelta per l'istanza di
	 *                       partita in corso.
	 * @param bFactory       istanza della <code>BreakerFavctory</code> relativa al
	 *                       giocatore <code>CodeBreaker</code> selezionato per la
	 *                       partita.
	 * @param mFactory       istanza della <code>MakerFactory</code> relativa al
	 *                       giocatore <code>CodeMaker</code> selezionato per la
	 *                       partita.
	 */
	public SingleMatch(int sequenceLength, int attempts, GameViewFactory viewFactory, BreakerFactory bFactory,
			MakerFactory mFactory) {

		BoardModel newModel = new BoardModel(sequenceLength, attempts);
		
		this.gameState = new MatchState();
		this.view = viewFactory.getGameView();
		newModel.addObserver(gameState);
		newModel.addObserver(view);
		newModel.addObserver(this);
		
		this.addObserver(this.view);
		this.controller = new BoardController(newModel);
		this.maker = mFactory.getMaker(view, sequenceLength, attempts);
		this.breaker = bFactory.getBreaker(view, sequenceLength, attempts);
	}

	/**
	 * Metodo che comunica l'esito finale della partita corrente.
	 * 
	 * @return String che comunica il vincitore attuale della partita
	 */
	public String endingMessage() {
		return gameState.getMessage();
	}
	/**
	 * Avvio e gestione completa di una singola partita di gioco.
	 */
	public void start() {
		controller.insertCodeToGuess(this.maker.getCodeToGuess());
		do {
			this.singleTurn();
		} while (!(gameState.getHasMakerWon() || gameState.getHasBreakerWon()));
		this.notifyObservers();
	}

	private void singleTurn() {
		controller.insertNewAttempt(this.breaker.getAttempt());
		if (this.breaker.hasGivenUp()) {
			gameState.toggleBreakerGiveUp();
			gameState.toggleMakerWin();
		}
	}

	@Override
	public void update(Object o) {
		if(o instanceof BoardModel) {
			BoardModel temp = (BoardModel) o;
			this.sequenceToGuess = temp.getSequenceToGuess();
		}
	}

	public List<ColorPegs> getSequenceToGuess() {
		return sequenceToGuess;
	}
}
