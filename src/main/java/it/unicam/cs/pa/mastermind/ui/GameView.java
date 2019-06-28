package it.unicam.cs.pa.mastermind.ui;

import java.util.List;

import it.unicam.cs.pa.mastermind.gamecore.BoardObserver;

/**
 * <b>Responsabilità</b>: fornire ai giocatori coinvolti in una singola partita
 * operazioni di Input/Output.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class GameView extends BoardObserver {

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

	// TODO JavaDoc
	public abstract void showGame();
}
