package it.unicam.cs.pa.mastermind.players;

import java.util.List;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * <b>Responsabilità</b>: rappresentazione di un giocatore <code>CodeMaker</code>, il cui compito è
 * quello di decretare una sequenza di <code>ColorPegs</code> che il giocatore
 * <code>CodeBreaker</code> deve indovinare.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class CodeMaker {

	/**
	 * 
	 * @return List contenente i <code>ColorPegs</code> validi come sequenza da
	 *         indovinare
	 */
	public abstract List<ColorPegs> getCodeToGuess();

}
