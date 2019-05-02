package it.unicam.cs.pa.mastermind.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

/**
 * Immagazzina i dati relativi alla plancia di gioco, quali posizione e natura
 * dei pioli codice e dei pioli chiave. Fornisce informazioni sullo stato di
 * gioco alle classi che lo gestiscono (Coordinator, Starter e
 * InteractionManager)
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class Board {

	private List<ColorPegs> sequenceToGuess;
	private Map<List<ColorPegs>, List<ColorPegs>> board;
	private final int maxAttempts;
	private final int sequenceLength;
	private Map<List<ColorPegs>, List<ColorPegs>> lastAttemptAndClue;

	/**
	 * Costruttore che riceve come parametri la lunghezza delle sequenze di pioli e
	 * il numero massimo di tentativi disponibili
	 * 
	 * @param sequenceLength
	 * @param attempts
	 */
	public Board(int sequenceLength, int maxAttempts) {
		this.sequenceLength = sequenceLength;
		this.maxAttempts = maxAttempts;
	}

	/**
	 * Costruttore senza parametri. La plancia � inizializzata con le regole
	 * standard
	 */
	public Board() {
		this(4, 9);
	}



	public int getSequenceLength(){
		return this.sequenceLength;
	}
	/**
	 * Restituisce la sequenza di pioli da indovinare
	 * 
	 * @return
	 */
	public List<ColorPegs> getSequenceToGuess() {
		return new ArrayList<ColorPegs>(sequenceToGuess);
	}



	/**
	 * Imposta la sequenza di pioli da indovinare
	 * 
	 * @return
	 */
	public boolean setSequenceToGuess(List<ColorPegs> toGuess) throws IllegalArgumentException {
		if (toGuess.size() != this.sequenceLength) {
			throw new IllegalArgumentException(
					"Si è provato ad inserire nella plancia una sequenza con dimensione illegale");
		} else {
			this.sequenceToGuess = toGuess;
			return true;
		}
	}

	/**
	 * Restituisce il numero di tentativi rimanenti
	 * 
	 * @return
	 */
	public int leftAttempts() {
		return maxAttempts - board.size();
	}

	/**
	 * Plancia completamente vuota o meno
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return sequenceToGuess.isEmpty() && board.isEmpty();
	}

	/**
	 * Aggiunge alla plancia una nuova sequenza di pioli tentativo e la relativa
	 * sequenza di pioli indizio
	 * 
	 * @param attempt
	 * @param clue
	 * @return
	 */
	public boolean addAttempt(List<ColorPegs> attempt, List<ColorPegs> clue) throws IllegalArgumentException {
		if ((attempt.size() != this.sequenceLength) || (clue.size() > this.sequenceLength)) {
			throw new IllegalArgumentException(
					"Si è provato ad inserire nella plancia una sequenza con dimensione illegale");
		} else {
			/*
			 * Aggiorno l'ultimo tentativo andando a fare il clear della struttura dati
			 */
			lastAttemptAndClue.clear();
			lastAttemptAndClue.put(attempt, clue);
			board.put(attempt, clue);
			return true;
		}
	}

	/**
	 * Restituisce l'ultima sequenza di pioli tentativo inseriti e la relativa
	 * sequenza di pioli indizio
	 * 
	 * @return
	 */
	public Map.Entry<List<ColorPegs>, List<ColorPegs>> lastAttemptAndClue() {
		Map.Entry<List<ColorPegs>, List<ColorPegs>> temp = lastAttemptAndClue.entrySet().iterator().next();
		return Map.entry(new ArrayList<ColorPegs>(temp.getKey()), new ArrayList<ColorPegs>(temp.getValue()));
	}
}
