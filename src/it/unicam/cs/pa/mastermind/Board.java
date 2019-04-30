package it.unicam.cs.pa.mastermind;

import java.util.Map;

/**
 * Immagazzina i dati relativi alla plancia di gioco, quali posizione e natura dei pioli codice e dei pioli chiave.
 * Fornisce informazioni sullo stato di gioco alle classi che lo gestiscono (Coordinator, Starter e InteractionManager) 
 * @author Francesco
 *
 */
public class Board {

	private CodePegs[] sequenceToGuess;
	private Map<CodePegs[], KeyPegs[]> board;
	private final int maxAttempts;
	private final int sequenceLength;
	
	/**
	 * Costruttore che riceve come parametri la lunghezza delle sequenze di pioli e il numero massimo di tentativi disponibili 
	 * @param sequenceLength
	 * @param attempts
	 */
	public Board(int sequenceLength, int maxAttempts) {
		this.sequenceLength = sequenceLength;
		this.maxAttempts = maxAttempts;
	}
	
	/**
	 * Costruttore senza parametri. La plancia � inizializzata con le regole standard 
	 */
	public Board() {
		this(4,9);
	}
	
	/**
	 * Restituisce la sequenza di pioli da indovinare
	 * @return
	 */
	public CodePegs[] getSequenceToGuess() {
		
	}
	
	/**
	 * Imposta la sequenza di pioli da indovinare
	 * @return
	 */
	public boolean setSequenceToGuess(CodePegs[] toGuess) {
		
	}
	/**
	 * Restituisce il numero di tentativi rimanenti
	 * @return
	 */
	public int leftAttempts() {
		
	}
	
	/**
	 * Indica se la plancia � completamente vuota o meno
	 * @return
	 */
	public boolean isEmpty() {
		
	}
	/**
	 * Aggiunge alla plancia una nuova sequenza di pioli tentativo e la relativa sequenza di pioli indizio
	 * @param attempt
	 * @param clue
	 * @return
	 */
	public boolean addAttempt(CodePegs[] attempt, KeyPegs[] clue) {
		
	}
	
	/**
	 * Restituisce l'ultima sequenza di pioli tentativo inseriti e la relativa sequenza di pioli indizio
	 * @return
	 */
	public Map.Entry<CodePegs[], KeyPegs[]> lastAttempt(){
		
	}
}
