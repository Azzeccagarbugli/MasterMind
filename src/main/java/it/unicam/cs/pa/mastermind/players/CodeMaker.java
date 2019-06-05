package it.unicam.cs.pa.mastermind.players;

import java.util.List;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * <b>Responsabilità</b>: gestire le interazioni del giocatore Maker
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class CodeMaker {

	/**
	 * Restituisce la sequenza di <code>ColorPegs</code> valida come sequenza da indovinare.
	 * 
	 * @param intView necessario per ottenere informazioni riguardo il gioco
	 * @return List di <code>ColorPegs</code> valida come sequenza da indovinare
	 */
	public abstract List<ColorPegs> getCodeToGuess(InteractionView intView);
	
}
