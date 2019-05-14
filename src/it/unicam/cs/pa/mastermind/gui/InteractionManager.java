package it.unicam.cs.pa.mastermind.gui;

import java.util.List;
import java.util.Map;

import it.unicam.cs.pa.mastermind.exceptions.BreakerGiveUpException;
import it.unicam.cs.pa.mastermind.exceptions.EndingException;
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
	 * @param toGuess        se la sequenza da inserire è la sequenza da indovinare
	 *                       o meno
	 * @throws BreakerGiveUpException la resa condizionata del player 
	 * @return la lista di interi che andranno a definire la sequenza
	 */
	public List<Integer> getIndexSequence(int sequenceLength, boolean toGuess) throws BreakerGiveUpException;

	/**
	 * Mostra all'utente la situazione corrente del gioco.
	 * 
	 * @param attemptsAndClues la lista di indizi e tentativi da visualizzare
	 */
	public void showGame(List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues);

	/**
	 * Mostra all'utente la situazione corrente del gioco e inoltre visualizza la
	 * sequenza da indovinare. Fondamentalmente il seguente metodo può essere
	 * utilizzato durante la fase di debugging.
	 * 
	 * @param toGuess          la lista da indovinare
	 * @param attemptsAndClues la lista di indizi e tentativi da visualizzare
	 */
	public void showGameDebug(List<ColorPegs> toGuess, List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues);

	/**
	 * Gestisce la fine di una singola partita. Metodo da richiamare dopo che è
	 * stato garantinto che la partita in atto è da definirsi conclusa.
	 * 
	 * @param exe eccezione personalizzata
	 * @param toGuess i valori della sequenza da indovinare
	 * @return un array di boolean contenente i settaggi di ending della partita
	 */
	public boolean[] ending(EndingException exe, List<ColorPegs> toGuess);
}
