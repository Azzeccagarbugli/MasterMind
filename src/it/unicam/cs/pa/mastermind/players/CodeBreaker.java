package it.unicam.cs.pa.mastermind.players;

import java.util.List;

import it.unicam.cs.pa.mastermind.pegs.CodePegs;

/**
 * Interfaccia relativa ai giocatori che cercano di indovinare la sequenza
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public interface CodeBreaker {
	/**
	 * Restituisce la sequenza di pioli valida come singolo tentativo
	 * 
	 * @param inputManager
	 * @return
	 */
	public List<CodePegs> getCode(InteractionManager inputManager);
}
