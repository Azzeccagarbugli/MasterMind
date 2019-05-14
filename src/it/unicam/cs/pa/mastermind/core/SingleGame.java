package it.unicam.cs.pa.mastermind.core;

import it.unicam.cs.pa.mastermind.exceptions.EndingException;
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
	 * Inizializza un nuovo gioco con un giocatore che codifica e un giocatore che
	 * decodifica.
	 * 
	 * @param maker          player addetto alla creazione della sequenza da
	 *                       indovinare
	 * @param breaker        player addetto alla risoluzione della sequenza da
	 *                       indovinare
	 * @param sequenceLength la lunghezza di tale sequenza
	 * @param attempts       il numero di tentativi concessi
	 * @param manager        entit� relativa alla gestione delle interazioni con
	 *                       gli utenti fisici
	 */
	public SingleGame(CodeMaker maker, CodeBreaker breaker, int sequenceLength, int attempts,
			InteractionManager manager) {
		this.maker = maker;
		this.breaker = breaker;
		this.coordinator = new BoardCoordinator(new Board(sequenceLength, attempts));
		this.manager = manager;
	}

	/**
	 * Avvio effettivo di una singola partita. Il metodo restituisce un array con
	 * due valori booleani, che indicano la volontà di iniziare o meno una nuova
	 * partita e la volontà di iniziarla con altre impostazioni.
	 * 
	 * @return un Array di booleani che stabiliranno le condizioni di ending del
	 *         gioco, come ad esempio inziare una nuova partita o ricominciare il
	 *         gioco con le precendenti impostazioni
	 */
	public boolean[] start() {
		coordinator.insertCodeToGuess(maker.getCodeToGuess(coordinator.getSequenceLength()));
		try {
			while (true) {
				coordinator.insertNewAttempt(breaker.getAttempt(coordinator.getSequenceLength()));
				manager.showGame(coordinator.getAttemptAndClueList());
				coordinator.checkEnd();
				//breaker.askGiveUp();
			}
		} catch (EndingException e) {
			return manager.ending(e, coordinator.getSequenceToGuess());
		}
	}

}
