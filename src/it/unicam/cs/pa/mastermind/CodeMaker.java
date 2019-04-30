package it.unicam.cs.pa.mastermind;

import java.util.List;

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
	public List<CodePegs> getCodeToGuess(InteractionManager inputManager);
}
