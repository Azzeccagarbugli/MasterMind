package it.unicam.cs.pa.mastermind.players;

import java.util.List;

import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

/**
 * Interfaccia relativa ai giocatori che forniscono la sequenza da codificare
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public interface CodeMaker {

	/**
	 * Restituisce la sequenza di pioli da indovinare.
	 * 
	 * @param sequenceLength la lunghezza della sequenza da indovinare
	 * @return la lista contenente la sequenza corretta di colori da indovinare
	 */
	public List<ColorPegs> getCodeToGuess(int sequenceLength);
}
