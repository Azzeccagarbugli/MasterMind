package it.unicam.cs.pa.mastermind.players;

import java.util.List;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * <b>Responsabilità</b>: rappresentazione di un giocatore
 * <code>CodeBreaker</code>, il cui compito è quello di indovinare la sequenza
 * di <code>ColorPegs</code> decisa dal giocatore <code>CodeMaker</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class CodeBreaker {

	/**
	 * Rappresenta la volontà del giocatore <code>CodeBreaker</code> di arrendersi o
	 * meno.
	 */
	private boolean giveUp = false;

	/**
	 * Variabile locale per la memorizzazione locale dell'ultima sequenza indizio
	 * correlata all'ultima sequenza tentativo generata.
	 */
	private List<ColorPegs> lastClue;

	/**
	 * Imposta una volontà del giocatore di arrendersi o meno.
	 * @param giveUp
	 */
	public void setGiveUp(boolean giveUp) {
		this.giveUp = giveUp;
	}

	/**
	 * Ritorna il valore memorizzato dell'ultima sequenza indizio relativa all'ultimo tentativo generato.
	 * @return
	 */
	public List<ColorPegs> getLastClue() {
		return lastClue;
	}

	/**
	 * Imposta il valore memorizzato dell'ultima sequenza indizio relativa all'ultimo tentativo generato.
	 * @param lastClue
	 */
	public void setLastClue(List<ColorPegs> lastClue) {
		this.lastClue = lastClue;
	}

	/**
	 * 
	 * @return List contenente i <code>ColorPegs</code> validi come sequenza
	 *         tentativo.
	 */
	public abstract List<ColorPegs> getAttempt();

	/**
	 * Imposta la volontà del giocatore <code>CodeBreaker</code> di arrendersi.
	 */
	public void toggleGiveUp() {
		giveUp = true;
	}

	/**
	 * 
	 * @return la volontà del giocatore <code>CodeBreaker</code> di arrendersi o
	 *         meno
	 */
	public boolean hasGivenUp() {
		return giveUp;
	}
}
