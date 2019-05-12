package it.unicam.cs.pa.mastermind.players;

import java.util.List;

import it.unicam.cs.pa.mastermind.exceptions.BreakerGiveUpException;
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
	 * Metodo che chiede all'entità del giocatore che decodifica se ha intenzione di arrendersi
	 * @throws BreakerGiveUpException
	 */
	public void askGiveUp() throws BreakerGiveUpException;
}
