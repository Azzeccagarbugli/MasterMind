package it.unicam.cs.pa.mastermind.gamecore;

import java.util.ArrayList;
import java.util.List;

/**
 * Interagisce continuamente con i giocatori aggiornando la plancia di gioco di
 * conseguenza.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BoardController {

	/**
	 * Variabile privata relativa alla plancia di gioco corrente.
	 */
	private BoardModel board;

	/**
	 * Costruttore che va ad inizializzare la nuova plancia di gioco in cui verranno
	 * effettuate le operazioni descritte dai metodi presenti nella medesima classe.
	 * 
	 * @param newBoard la board su cui si vogliono effettuare le operazioni di
	 *                 coordinazione
	 */
	public BoardController(BoardModel newBoard) {
		this.board = newBoard;
	}

	/**
	 * Riceve come argomento una nuova sequenza da inserire nella plancia come nuovo
	 * tentativo. Inserisce nella plancia anche la sequenza di pioli indizio
	 * relativa.
	 * 
	 * @param attempt la lista di pioli tentativo che si vuole inserire
	 * @return un booleano che controlla lo stato della operazione,
	 *         <strong>true</strong> se l'operazione è stata effettuata con successo
	 *         o <strong>false</strong> se l'operazione è fallita
	 */
	public boolean insertNewAttempt(List<ColorPegs> attempt) {
		try {
			board.addAttempt(attempt);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}



	/**
	 * Riceve come argomento la sequenza da inserire nella plancia come sequenza da
	 * indovinare ed effettua la relativa operazione.
	 * 
	 * @param toGuess la lista da indovinare.
	 * @return boolean che afferma il corretto inserimento della sequenza.
	 */
	public boolean insertCodeToGuess(List<ColorPegs> toGuess) {
		try {
			board.setSequenceToGuess(toGuess);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo getter il quale restituisce una lista contenente la sequenza da
	 * indovinare.
	 *
	 * @return l'ArrayList contenente la sequenza da indovinare.
	 */
	public List<ColorPegs> getSequenceToGuess() {
		return new ArrayList<ColorPegs>(board.getSequenceToGuess());
	}


	/**
	 * Metodo pubblico che restituisce il valore della lunghezza della sequenza
	 * inserita.
	 *
	 * @return int che rappresenta la lunghezza delle sequenze da inserire.
	 */
	public int getSequenceLength() {
		return this.board.getSequenceLength();
	}

	public BoardModel getBoardReference() {
		return this.board;
	}

}
