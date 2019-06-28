package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

public interface InteractionViewFactory {
	
	public default InteractionView getIntView(BoardModel subject) {
		InteractionView newInstance = getNewInstance();
		newInstance.addSubject(subject);
		return newInstance;
	}

	public InteractionView getNewInstance();
}
