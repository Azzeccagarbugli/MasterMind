package it.unicam.cs.pa.mastermind.core;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;

/**
 * Interagisce continuamente con i giocatori aggiornando la plancia di gioco di conseguenza
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class Coordinator {

	/**
	 * Interroga il breaker sulla nuova sequenza da inserire nella plancia come
	 * nuovo tentativo. Inserisce nella plancia anche la sequenza di pioli indizio
	 * relativa.
	 * 
	 * @param breaker
	 * @param boardToUpdate
	 * @return
	 */
	public boolean insertNewAttempt(CodeBreaker breaker, Board boardToUpdate) {
		// TODO
		return false;
	}

	/**
	 * Indica se la partita termina o meno. Pu� terminare solo se i tentativi sono
	 * finiti, se il giocatore breaker ha indovinato la sequenza o se, infine, il
	 * giocatore breaker si � arreso
	 * 
	 * @param breaker
	 * @param boardToUpdate
	 * @return
	 */
	public boolean checkEnd(CodeBreaker breaker, Board boardToUpdate) {
		// TODO
		return false;
	}
	
	/**
	 * Interroga il maker sulla sequenza da inserire nella plancia come sequenza da
	 * indovinare ed effettua la relativa operazione
	 * 
	 * @param maker
	 * @param boardToUpdate
	 * @return
	 */
	public boolean insertCodeToGuess(CodeMaker maker, Board boardToUpdate) {
		// TODO
		return false;
	}
}
