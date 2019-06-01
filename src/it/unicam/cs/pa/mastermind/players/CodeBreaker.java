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
	 * @param sequenceLength la lunghezza della sequenza
	 * @throws BreakerGiveUpException eccezione lanciata quando il player decide di
	 *                                effettuare la resa
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
	 * Metodo che restituisce la volont� del giocatore di arrendersi o meno
	 */
	public boolean hasGivenUp() {
		return giveUp;
	}
}
