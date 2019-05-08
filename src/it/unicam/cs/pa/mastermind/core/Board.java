package it.unicam.cs.pa.mastermind.core;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

/**
 * Immagazzina i dati relativi alla plancia di gioco, quali posizione e natura
 * dei pioli codice e dei pioli chiave. Fornisce informazioni sullo stato di
 * gioco alle classi che lo gestiscono (Coordinator, Starter e
 * InteractionManager).
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class Board {

	/**
	 * Lista di ColorPegs contenente la sequenza da indovinare.
	 */
	private List<ColorPegs> sequenceToGuess;

	/**
	 * Mappa composta da due liste di ColorPegs contenente la board di gioco.
	 */
	private Map<List<ColorPegs>, List<ColorPegs>> board;

	/**
	 * Numero massimo di tentativi possibili per indovinare la sequenza.
	 */
	private final int maxAttempts;

	/**
	 * Lunghezza massima della sequenza da inserire.
	 */
	private final int sequenceLength;

	/**
	 * Costruttore che riceve come parametri la lunghezza delle sequenze di pioli e
	 * il numero massimo di tentativi disponibili.
	 * 
	 * @param sequenceLength lunghezza della sequenza inserita
	 * @param maxAttempts    numero di tentativi possibii per indovindare la
	 *                       sequenza
	 */
	public Board(int sequenceLength, int maxAttempts) {
		this.board = new LinkedHashMap<List<ColorPegs>, List<ColorPegs>>();
		this.sequenceLength = sequenceLength;
		this.maxAttempts = maxAttempts;
	}

	/**
	 * Restituisce la lunghezza della sequenza da inserire.
	 * 
	 * @return la lunghezza della sequenza
	 */
	public int getSequenceLength() {
		return this.sequenceLength;
	}

	/**
	 * Restituisce la sequenza di pioli da indovinare.
	 * 
	 * @return la lista composta da ColorPegs contente la sequenza da indovinare
	 */
	public List<ColorPegs> getSequenceToGuess() {
		return this.sequenceToGuess;
	}

	/**
	 * Restituisce la board contenente i tentativi inseriti e i corrispetivi indizi.
	 * 
	 * @return la board con i relativi attempt e clue
	 */
	public Map<List<ColorPegs>, List<ColorPegs>> getAttemptAndClueMap() {
		return board;
	}

	/**
	 * Imposta la sequenza di pioli da indovinare.
	 * 
	 * @param toGuess lista di ColorPegs della sequenza da indovinare
	 * @throws IllegalArgumentException se la lunghezza della sequenza inserita non
	 *                                  è valida
	 * @return un booleano a seconda della riuscita o meno dell'inserimento nella
	 *         plancia di gioco
	 */
	public boolean setSequenceToGuess(List<ColorPegs> toGuess) throws IllegalArgumentException {
		if (toGuess.size() != this.sequenceLength) {
			throw new IllegalArgumentException("The lenght of the sequence is not valid");
		} else {
			this.sequenceToGuess = toGuess;
			return true;
		}
	}

	/**
	 * Restituisce il numero di tentativi rimanenti.
	 * 
	 * @return il numero di tentativi rimasti
	 */
	public int leftAttempts() {
		return maxAttempts - board.size();
	}

	/**
	 * Metodo che stabilisce se la plancia di gioco è completamente vuota o meno.
	 * 
	 * @return un booleano a seconda dello stato vuoto o meno della plancia
	 */
	public boolean isEmpty() {
		return sequenceToGuess.isEmpty() && board.isEmpty();
	}

	/**
	 * Aggiunge alla plancia una nuova sequenza di pioli tentativo e la relativa
	 * sequenza di pioli indizio.
	 * 
	 * @param attempt la lista della sequnza tentativo
	 * @param clue    la lista degli indizi forniti
	 * @throws IllegalArgumentException se il tentativo di inserimento fallisce
	 * @return un booleano che conferma la riuscita o meno dell'inserimento della
	 *         sequenza nella plancia
	 */
	public boolean addAttempt(List<ColorPegs> attempt, List<ColorPegs> clue) throws IllegalArgumentException {
		if (this.isEmpty()) {
			throw new NullPointerException("The board is empty, there is nothing to add");
		}
		if ((attempt.size() != this.sequenceLength) || (clue.size() > this.sequenceLength)) {
			throw new IllegalArgumentException("The lenght of the sequence is not valid");
		} else {
			board.put(attempt, clue);
			return true;
		}
	}

	/**
	 * Restituisce l'ultima sequenza di pioli tentativo inseriti e la relativa
	 * sequenza di pioli indizio.
	 * 
	 * @return l'utlima sequenza di pioli tentativo inseriti e la lista di indizi
	 *         relativi a quest'ultima
	 */
	public Map.Entry<List<ColorPegs>, List<ColorPegs>> lastAttemptAndClue() {
		Map.Entry<List<ColorPegs>, List<ColorPegs>> temp = null;
		Iterator<Map.Entry<List<ColorPegs>, List<ColorPegs>>> it = this.board.entrySet().iterator();
		while (it.hasNext()) {
			temp = it.next();
		}
		return temp;
	}

}
