package it.unicam.cs.pa.mastermind.gui;

import java.util.List;
import java.util.Map;

import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

/**
 * Interfaccia relativa alla gestione dell'interazione con l'utente.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public interface InteractionManager {

	/**
	 * Richiede all'utente umano la sequenza tentativo.
	 * 
	 * @param sequenceLength la lunghezza della sequenza inserita
	 * @param toGuess        se la sequenza da inserire √® la sequenza da indovinare
	 *                       o meno
	 * @return la lista di interi che andranno a definire la sequenza
	 */
	public List<Integer> getIndexSequence(int sequenceLength, boolean toGuess);

	/**
	 * Mostra all'utente la situazione corrente del gioco.
	 * 
	 * @param attemptsAndClues la lista di indizi e tentativi da visualizzare
	 */
	public void showGame(List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues);

	/**
	 * Mostra all'utente la situazione corrente del gioco e inoltre visualizza la
	 * sequenza da indovinare. Fondamentalmente il seguente metodo pu√≤ essere
	 * utilizzato durante la fase di debugging.
	 * 
	 * @param toGuess          la lista da indovinare
	 * @param attemptsAndClues la lista di indizi e tentativi da visualizzare
	 */
	public void showGame(List<ColorPegs> toGuess, List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues);

	/**
	 * Gestisce la fine di una singola partita.
	 * Metodo da richiamare dopo che Ë stato garantinto che la partita in atto Ë da definirsi conclusa.
	 * @return un array di boolean contenente i settaggi di ending della partita
	 */
	public boolean[] ending();

}
