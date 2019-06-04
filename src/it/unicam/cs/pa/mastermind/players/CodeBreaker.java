package it.unicam.cs.pa.mastermind.players;

import java.util.List;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * <b>Responsabilità</b>: gestire le interazioni del giocatore Breaker
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class CodeBreaker {

	/**
	 * Rappresenta la volontà del giocatore <code>CodeBreaker</code> di arrendersi o meno.
	 */
	private boolean giveUp = false;

	/**
	 * Restituisce la sequenza di <code>ColorPegs</code> valida come singolo tentativo.
	 * 
	 * @param intView necessario per ottenere informazioni riguardo il gioco
	 * @return List di <code>ColorPegs</code> valida come singolo tentativo
	 */
	public abstract List<ColorPegs> getAttempt(InteractionView intView);

	/**
	 * Imposta la volontà del giocatore <code>CodeBreaker</code> di arrendersi.
	 */
	public void toggleGiveUp() {
		giveUp = true;
	}

	/**
	 * 
	 * @return la volontà del giocatore <code>CodeBreaker</code> di arrendersi
	 */
	public boolean hasGivenUp() {
		return giveUp;
	}
}
