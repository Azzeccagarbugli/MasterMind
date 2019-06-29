package it.unicam.cs.pa.mastermind.factories;


import it.unicam.cs.pa.mastermind.ui.ConsoleGameView;
import it.unicam.cs.pa.mastermind.ui.GameView;

/**
 * Classe factory estensione di <code>GameViewFactory</code> impiegata per ottenere istanze di <code>ConsoleGameView</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class ConsoleGameViewFactory implements GameViewFactory {

	@Override
	public GameView getNewInstance() {
		return new ConsoleGameView();
	}

}
