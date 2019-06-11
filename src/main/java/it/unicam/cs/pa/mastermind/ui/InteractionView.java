package it.unicam.cs.pa.mastermind.ui;

import java.util.List;
import java.util.Map;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;

/**
 * <b>Responsabilità</b>: fornire ai giocatori coinvolti in una singola partita
 * interazioni con quest'ultima.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class InteractionView extends BoardObserver {

	/**
	 * La sequenza da indovinare.
	 */
	private List<ColorPegs> currentSequenceToGuess;

	/**
	 * La lunghezza della sequenza da indovinare.
	 */
	private int currentSequenceLength;

	/**
	 * Singola entry di una mappa, contenente l'ultima lista di ColorPegs inseriti e
	 * la relativa sequenza indizio.
	 */
	private Map.Entry<List<ColorPegs>, List<ColorPegs>> lastAttemptAndClue;

	/**
	 * Metodo setter che imposta la sequenza da indovinare.
	 */
	protected void setCurrentSequenceToGuess(List<ColorPegs> currentSequenceToGuess) {
		this.currentSequenceToGuess = currentSequenceToGuess;
	}

	/**
	 * Metodo setter che imposta la lunghezza della sequenza da indovinare.
	 */
	protected void setCurrentSequenceLength(int currentSequenceLength) {
		this.currentSequenceLength = currentSequenceLength;
	}

	/**
	 * Metodo setter che imposta la entry di mappa contenente l'ultima lista di
	 * ColorPegs inseriti e la relativa sequenza indizio.
	 */
	protected void setLastAttemptAndClue(Map.Entry<List<ColorPegs>, List<ColorPegs>> lastAttemptAndClue) {
		this.lastAttemptAndClue = lastAttemptAndClue;
	}

	/**
	 * Metodo getter che restituisce la sequenza da indovinare.
	 * 
	 * @return List la lista di ColorPegs da indovinare
	 */
	public List<ColorPegs> getCurrentSequenceToGuess() {
		return currentSequenceToGuess;
	}

	/**
	 * Metodo getter che restituisce la lunghezza della sequenza da indovinare.
	 *
	 * @return int il valore intero di tale lunghezza
	 */
	public int getCurrentSequenceLength() {
		return currentSequenceLength;
	}

	/**
	 * Metodo getter che restituisce la entry di mappa contenente l'ultima lista di
	 * ColorPegs inseriti e la relativa sequenza indizio.
	 * 
	 * @return Map.Entry contenente l'ultima lista di ColorPegs inseriti e la
	 *         relativa sequenza indizio.
	 */
	public Map.Entry<List<ColorPegs>, List<ColorPegs>> getLastAttemptAndClue() {
		return lastAttemptAndClue;
	}

	/**
	 * Interazione con l'utente fisico o altra entità per poter ottenere gli indici
	 * associati ai diversi valori di <code>ColorPegs</code>. Se il valore
	 * restituito contiene l'<code>Integer</code> 0 è stata rappresentata la volontà
	 * di un giocatore <code>CodeBreaker</code> di arrendersi.
	 * 
	 * @param toGuess flag che indica se la sequenza di interi da ottenere si
	 *                riferisce alla sequenza da indovinare o meno
	 * @return List contenente gli indici da 1 a currentSequenceLength, associati
	 *         all'enum ColorPegs
	 */
	public abstract List<Integer> getIndexSequence(boolean toGuess);

	/**
	 * Interazione finale con il giocatore relativa al termine di una partita
	 * 
	 * @param gameEndingMessage stringa con il messaggio finale da mostrare al
	 *                          giocatore
	 */
	public abstract void endingScreen(String gameEndingMessage);

	/**
	 * Restituisce la sequenza di <code>ColorPegs</code> valida come sequenza da
	 * indovinare chiedendola al giocatore <code>CodeMaker</code>.
	 * 
	 * @param maker riferimento al giocatore <code>CodeMaker</code> codificatore
	 * @return List di <code>ColorPegs</code> valida come sequenza da indovinare
	 */
	public abstract List<ColorPegs> getCodeToGuess(CodeMaker maker);

	/**
	 * Restituisce la sequenza di <code>ColorPegs</code> valida come singolo
	 * tentativo chiedendola al giocatore <code>CodeBreaker</code>.
	 * 
	 * @param breaker riferimento al giocatore <code>CodeBreaker</code>
	 *                decodificatore
	 * @return List di <code>ColorPegs</code> valida come singolo tentativo
	 */
	public abstract List<ColorPegs> getAttempt(CodeBreaker breaker);
}
