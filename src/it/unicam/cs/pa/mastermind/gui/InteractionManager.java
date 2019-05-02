package it.unicam.cs.pa.mastermind.gui;

import java.util.List;

import it.unicam.cs.pa.mastermind.core.Board;

/**
 * Interfaccia relativa alla gestione dell'interazione con l'utente
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public interface InteractionManager {

	/**
	 * Richiede all'utente umano la sequenza tentativo
	 * 
	 * @return
	 */
	public List<Integer> getSequence(int sequenceLength, boolean toGuess);


	/**
	 * Mostra all'utente la situazione corrente del gioco
	 */
	public void showGame(Board board);


	/**
	 * Gestisce la fine di una singola partita
	 * @return
	 */
	public boolean[] ending();
}
