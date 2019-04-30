package it.unicam.cs.pa.mastermind;

/**
 * Interfaccia relativa ai giocatori che cercano di indovinare la sequenza
 * 
 * @author Francesco
 *
 */
public interface CodeBreaker {
	/**
	 * Restituisce la sequenza di pioli valida come singolo tentativo
	 * 
	 * @param inputManager
	 * @return
	 */
	public CodePegs[] getCode(InteractionManager inputManager);
}
