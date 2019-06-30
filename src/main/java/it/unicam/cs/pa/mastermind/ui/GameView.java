package it.unicam.cs.pa.mastermind.ui;

import java.util.List;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.gamecore.Observer;

/**
 * <b>Responsabilità</b>: fornire agli utenti fisici coinvolti in una singola
 * partita operazioni di Input/Output. Rientra nel pattern <b>Observer</b> per
 * poter fornire in output all'utente fisico una rappresentazione di quelle che
 * sono le azioni effettuate dai giocatori nel gioco. Rientra nel pattern
 * <b>MVC</b>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class GameView implements Observer {

	/**
	 * Interazione con l'utente fisico per poter ottenere gli indici associati ai
	 * diversi valori di <code>ColorPegs</code>. Se il valore restituito contiene
	 * l'<code>Integer</code> 0 è stata rappresentata la volontà di un giocatore
	 * <code>CodeBreaker</code> di arrendersi.
	 * 
	 * @param seqLength la lunghezza della sequenza di cui si vogliono ottenere indici
	 * @param toGuess flag che indica se la sequenza di indici interi da ottenere si
	 *                riferisce alla sequenza da indovinare o meno
	 * @return List contenente gli indici interi associati all'enum ColorPegs
	 */
	public abstract List<Integer> getIndexSequence(int seqLength, boolean toGuess);

	/**
	 * Interazione con l'utente fisico per la terminazione di una partita
	 * @param gameEndingMessage messaggio che comunica all'utente fisico l'esito
	 * @param seqToGuess sequenza da indovinare dal gioco, da mostrare all'utente fisico
	 */
	public abstract void endingScreen(String gameEndingMessage, List<ColorPegs> seqToGuess);

	/**
	 * Interazione con l'utente fisico per mostrare la situazione di gioco.
	 * @param o plancia di gioco da mostrare
	 */
	public abstract void showGame(BoardModel o);
}
