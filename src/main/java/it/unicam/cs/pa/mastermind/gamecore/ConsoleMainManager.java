package it.unicam.cs.pa.mastermind.gamecore;

import it.unicam.cs.pa.mastermind.factories.ConsoleGameViewFactory;
import it.unicam.cs.pa.mastermind.factories.GameViewFactory;
import it.unicam.cs.pa.mastermind.ui.ConsoleStartView;
import it.unicam.cs.pa.mastermind.ui.StartView;

public class ConsoleMainManager extends MainManager {

	@Override
	public StartView getStartViewInstance() {
		return ConsoleStartView.getInstance();
	}

	@Override
	public GameViewFactory getGameViewFactory() {
		return new ConsoleGameViewFactory();
	}

	public static void main(String[] args) {
		ConsoleMainManager main = new ConsoleMainManager();
		main.startUp();
	}
}
