package it.unicam.cs.pa.mastermind;

/**
 * Interfaccia relativa alla gestione dell'interazione con l'utente
 * 
 * @author Francesco
 *
 */
public interface InteractionManager {

	/**
	 * Richiede all'utente la sequenza
	 * 
	 * @return
	 */
	public byte[] getSequence();

	/**
	 * Mostra all'utente la situazione corrente del gioco
	 */
	public void showGame();

}
