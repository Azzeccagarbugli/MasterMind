package it.unicam.cs.pa.mastermind.players;

import java.util.List;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * Classe astratta relativa ai giocatori che cercano di indovinare la sequenza.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class CodeBreaker {

	private boolean giveUp = false;

	/**
	 * Restituisce la sequenza di pioli valida come singolo tentativo.
	 * 
	 * @param intManager l'InteractionView che si occupa della gestione delle scelte
	 *                   del player
	 * @return la lista dei valori ottenuta
	 */
	public abstract List<ColorPegs> getAttempt(InteractionView intManager);

	/**
	 * Metodo invocabile dal giocatore per segnalare la volontà di arrendersi
	 */
	public void toggleGiveUp() {
		giveUp = true;
	}

	/**
	 * Metodo che restituisce la volontà del giocatore di arrendersi o meno
	 */
	public boolean hasGivenUp() {
		return giveUp;
	}
}
