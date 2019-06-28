package it.unicam.cs.pa.mastermind.players;

import java.util.List;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * <b>Responsabilità</b>: gestire le interazioni del giocatore Maker
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class CodeMaker {

//TODO Aggiornare JavaDoc
	public abstract List<ColorPegs> getCodeToGuess();
	
}
