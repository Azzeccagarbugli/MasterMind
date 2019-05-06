package it.unicam.cs.pa.mastermind.gui;

import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unicam.cs.pa.mastermind.core.Board;
import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

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
	public List<Integer> getIndexSequence(int sequenceLength, boolean toGuess);


	/**
	 * Mostra all'utente la situazione corrente del gioco
	 */
	public void showGame(Set<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues);
	
	public void showGame(List<ColorPegs> toGuess, Set<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues);


	/**
	 * Gestisce la fine di una singola partita
	 * @return
	 */
	public boolean[] ending();
}
