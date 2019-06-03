package it.unicam.cs.pa.mastermind.ui;

import java.util.List;
import java.util.Map;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * Interfaccia relativa alla gestione dell'interazione con l'utente.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class InteractionView extends BoardObserver {

	/**
	 * La sequenza da indovinare.
	 */
	protected List<ColorPegs> currentSequenceToGuess;

	/**
	 * La lunghezza della sequenza da indovinare.
	 */
	protected int currentSequenceLength;

	/**
	 * La mappa composta da due liste di ColorPegs la quale contiene l'utlimo
	 * tentativo inserito dall'utente e la relativa sequenza indizio che è stata
	 * generata basandosi du quest'ultima.
	 */
	protected Map.Entry<List<ColorPegs>, List<ColorPegs>> lastAttemptAndClue;

	/**
	 * Metodo getter che restituisce la sequenza da indovinare.
	 * 
	 * @return la lista di ColorPegs da indovinare
	 */
	public List<ColorPegs> getCurrentSequenceToGuess() {
		return currentSequenceToGuess;
	}

	/**
	 * Metodo getter che restituisce la lunghezza della sequenza da indovinare.
	 *
	 * @return il valore intero di tale lunghezza
	 */
	public int getCurrentSequenceLength() {
		return currentSequenceLength;
	}

	/**
	 * Metodo getter che restituisce la mappa composta da due liste di ColorPegs la
	 * quale contiene l'utlimo tentativo inserito dall'utente e la relativa sequenza
	 * indizio che è stata generata basandosi du quest'ultima.
	 * 
	 * @return la mappa con l'ultima sequenza inserita dall'utente e l'ultima
	 *         sequenza di indizi generata automaticamente
	 */
	public Map.Entry<List<ColorPegs>, List<ColorPegs>> getLastAttemptAndClue() {
		return lastAttemptAndClue;
	}

	/**
	 * Richiede all'utente umano la sequenza tentativo.
	 * 
	 * @param sequenceLength la lunghezza della sequenza inserita
	 * @param toGuess        se la sequenza da inserire è la sequenza da indovinare
	 *                       o meno
	 * @throws BreakerGiveUpException la resa condizionata del player
	 * @return la lista di interi che andranno a definire la sequenza. Posti n
	 *         colori, gli elementi all'interno della lista avranno valore compreso
	 *         tra 1 e n
	 */
	public abstract List<Integer> getIndexSequence(boolean toGuess);

	/**
	 * Mostra all'utente la situazione corrente del gioco e inoltre visualizza la
	 * sequenza da indovinare. Fondamentalmente il seguente metodo può essere
	 * utilizzato durante la fase di debugging.
	 * 
	 * @param toGuess          la lista da indovinare
	 * @param attemptsAndClues la lista di indizi e tentativi da visualizzare
	 */
	// public abstract void showGameDebug(List<ColorPegs> toGuess,
	// List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues);

	/**
	 * Gestisce la fine di una singola partita. Metodo da richiamare dopo che è
	 * stato garantinto che la partita in atto è da definirsi conclusa.
	 * 
	 * @param exe     eccezione personalizzata
	 * @param toGuess i valori della sequenza da indovinare
	 * @return un array di boolean contenente i settaggi di ending della partita
	 */
	public abstract void endingScreen(String gameEndingMessage, List<ColorPegs> toGuess);
}
