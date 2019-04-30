package it.unicam.cs.pa.mastermind.core;

import java.util.List;
import java.util.Map;

import it.unicam.cs.pa.mastermind.pegs.CodePegs;

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

	private CodePegs[] sequenceToGuess;
	private Map<List<CodePegs>, List<CodePegs>> board;
	private final int maxAttempts;
	private final int sequenceLength;

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

	/**
	 * Restituisce la sequenza di pioli da indovinare
	 * 
	 * @return
	 */
	public CodePegs[] getSequenceToGuess() {
		// TODO
		return null;
	}

	/**
	 * Imposta la sequenza di pioli da indovinare
	 * 
	 * @return
	 */
	public boolean setSequenceToGuess(CodePegs[] toGuess) {
		// TODO
		return false;
	}

	/**
	 * Restituisce il numero di tentativi rimanenti
	 * 
	 * @return
	 */
	public int leftAttempts() {
		// TODO
		return 0;
	}

	/**
	 * Indica se la plancia � completamente vuota o meno
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		// TODO
		return false;
	}

	/**
	 * Aggiunge alla plancia una nuova sequenza di pioli tentativo e la relativa
	 * sequenza di pioli indizio
	 * 
	 * @param attempt
	 * @param clue
	 * @return
	 */
	public boolean addAttempt(List<CodePegs> attempt, List<CodePegs> clue) {
		// TODO
		return false;
	}

	/**
	 * Restituisce l'ultima sequenza di pioli tentativo inseriti e la relativa
	 * sequenza di pioli indizio
	 * 
	 * @return
	 */
	public Map.Entry<List<CodePegs>, List<CodePegs>> lastAttempt() {
		// TODO
		return null;
	}
}
