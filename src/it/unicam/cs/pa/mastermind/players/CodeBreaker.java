package it.unicam.cs.pa.mastermind.players;

import java.util.List;

import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

/**
 * Interfaccia relativa ai giocatori che cercano di indovinare la sequenza.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public interface CodeBreaker {

	/**
	 * Restituisce la sequenza di pioli valida come singolo tentativo.
	 * 
	 * @param sequenceLength la lunghezza della sequenza
	 * @return la lista dei valori ottenuta
	 */
	public List<ColorPegs> getAttempt(int sequenceLength);

	/**
	 * Definisce o meno una potenziale arresa da parte del player.
	 * 
	 * @return un booleano a seconda della sua scelta di resa
	 */
	public boolean isGiveUp();

	/**
	 * Setta lo stato di resa da parte del player.
	 * 
	 * @param giveUp un booleano a seconda della sua scelta di resa
	 */
	public void setGiveUp(boolean giveUp);
}
