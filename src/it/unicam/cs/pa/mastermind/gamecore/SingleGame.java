package it.unicam.cs.pa.mastermind.gamecore;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.ui.InteractionManager;

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
	private BoardCoordinator coordinator;

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
	private InteractionManager manager;

	/**
	 * Oggetto contenente informazioni relative al vincitore della partita in corso.
	 */
	WinStats winStats;

	/**
	 * Inizializza un nuovo gioco con un giocatore che codifica e un giocatore che
	 * decodifica.
	 * 
	 * @param maker          player addetto alla creazione della sequenza da
	 *                       indovinare
	 * @param breaker        player addetto alla risoluzione della sequenza da
	 *                       indovinare
	 * @param sequenceLength la lunghezza di tale sequenza
	 * @param attempts       il numero di tentativi concessi
	 * @param manager        entità relativa alla gestione delle interazioni con gli
	 *                       utenti fisici
	 */
	public SingleGame(int sequenceLength, int attempts, InteractionManager manager, CodeBreaker currentBreaker,
			CodeMaker currentMaker) {
		this.maker = currentMaker;
		this.breaker = currentBreaker;
		this.winStats = new WinStats();
		this.coordinator = new BoardCoordinator(new Board(sequenceLength, attempts));
		this.manager = manager;
	}

	/**
	 * Aggiornamento delle informazioni relative al vincitore della partita.
	 */
	private void updateWinStats() {
		if (this.breaker.hasGivenUp()) {
			winStats.toggleMakerWin();
			return;
		} else if (this.coordinator.hasBreakerGuessed()) {
			winStats.toggleBreakerWin(this.coordinator.numberOfAttemptsInserted());
			return;
		} else if (!this.coordinator.hasLeftAttempts()) {
			winStats.toggleMakerWin();
			return;
		}
	}

	/**
	 * Avvio effettivo di una singola partita. Il metodo restituisce un array con
	 * due valori booleani, che indicano la volontà di iniziare o meno una nuova
	 * partita e la volontà di iniziarla con altre impostazioni.
	 * 
	 * @return un Array di booleani che stabiliranno le condizioni di ending del
	 *         gioco, come ad esempio inziare una nuova partita o ricominciare il
	 *         gioco con le precendenti impostazioni.
	 */
	public boolean[] start() {
		coordinator.insertCodeToGuess(maker.getCodeToGuess(coordinator.getSequenceLength(), this.manager));
		do {
			coordinator.insertNewAttempt(breaker.getAttempt(coordinator.getSequenceLength(), this.manager));
			manager.showGame(coordinator.getAttemptAndClueList());
			this.updateWinStats();
		} while (!(winStats.getHasMakerWon() || winStats.getHasBreakerWon()));
		return manager.ending(winStats.getMessage(), coordinator.getSequenceToGuess());
	}

}
