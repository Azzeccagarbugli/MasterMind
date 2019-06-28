package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.ui.GameView;

public interface GameViewFactory {
	
	public default GameView getIntView(BoardModel subject) {
		GameView newInstance = getNewInstance();
		newInstance.addSubject(subject);
		return newInstance;
	}

	public GameView getNewInstance();
}
