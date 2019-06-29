package it.unicam.cs.pa.mastermind.ui;

import java.util.List;

import it.unicam.cs.pa.mastermind.gamecore.BoardObserver;

/**
 * <b>Responsabilità</b>: fornire agli utenti fisici coinvolti in una singola
 * partita operazioni di Input/Output. Rientra nel pattern <b>Observer</b> per
 * poter fornire in output all'utente fisico una rappresentazione di quelle che
 * sono le azioni effettuate dai giocatori nel gioco.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class GameView extends BoardObserver {

	/**
	 * Interazione con l'utente fisico per poter ottenere gli indici associati ai
	 * diversi valori di <code>ColorPegs</code>. Se il valore restituito contiene
	 * l'<code>Integer</code> 0 è stata rappresentata la volontà di un giocatore
	 * <code>CodeBreaker</code> di arrendersi.
	 * 
	 * @param toGuess flag che indica se la sequenza di indici interi da ottenere si
	 *                riferisce alla sequenza da indovinare o meno
	 * @return List contenente gli indici interi associati all'enum ColorPegs
	 */
	public abstract List<Integer> getIndexSequence(boolean toGuess);

	/**
	 * Interazione finale con l'utente fisico relativa al termine di una partita
	 * 
	 * @param gameEndingMessage stringa con il messaggio finale da mostrare
	 *                          all'utente
	 */
	public abstract void endingScreen(String gameEndingMessage);

	/**
	 * Interazione con l'utente fisico per mostrare la situazione di gioco.
	 */
	public abstract void showGame();
}
