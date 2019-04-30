package it.unicam.cs.pa.mastermind;

/**
 * Interfaccia relativa ai giocatori che forniscono la sequenza da codificare
 * 
 * @author Francesco
 *
 */
public interface CodeMaker {

	/**
	 * Restituisce la sequenza di pioli da indovinare
	 * 
	 * @param inputManager
	 * @return
	 */
	public CodePegs[] getCodeToGuess(InteractionManager inputManager);
}
