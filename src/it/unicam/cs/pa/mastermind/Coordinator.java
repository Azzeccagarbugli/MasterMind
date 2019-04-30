package it.unicam.cs.pa.mastermind;

/**
 * Interagisce continuamente con il giocatore che decifra il codice e con la
 * plancia di gioco
 * 
 * @author Francesco
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
	 * Indica se la partita termina o meno. Può terminare solo se i tentativi sono
	 * finiti, se il giocatore breaker ha indovinato la sequenza o se, infine, il
	 * giocatore breaker si è arreso
	 * 
	 * @param breaker
	 * @param boardToUpdate
	 * @return
	 */
	public boolean checkEnd(CodeBreaker breaker, Board boardToUpdate) {
		// TODO
		return false;
	}
}
