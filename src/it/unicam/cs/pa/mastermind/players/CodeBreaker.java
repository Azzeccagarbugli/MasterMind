package it.unicam.cs.pa.mastermind.players;

import java.util.List;

import it.unicam.cs.pa.mastermind.gui.InteractionManager;
import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

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
	public List<ColorPegs> getCode(int sequenceLength, InteractionManager inputManager);
	public boolean isGiveUp();
	public void setGiveUp(boolean giveUp);
}
