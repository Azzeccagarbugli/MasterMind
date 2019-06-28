package it.unicam.cs.pa.mastermind.factories;


import it.unicam.cs.pa.mastermind.ui.ConsoleGameView;
import it.unicam.cs.pa.mastermind.ui.GameView;

public class ConsoleGameViewFactory implements GameViewFactory {

	@Override
	public GameView getNewInstance() {
		return new ConsoleGameView();
	}

}
