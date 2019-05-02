package it.unicam.cs.pa.mastermind.gui;

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
	public int[] getSequenceToGuess();

	/**
	 * Richiede all'utente umano la sequenza da indovinare
	 * 
	 * @return
	 */
	public int[] getSequenceAttempt();

	/**
	 * Mostra all'utente la situazione corrente del gioco
	 */
	public void showGame();


	/**
	 * Gestisce la fine di una singola partita
	 * @return
	 */
	public boolean[] ending();
}
