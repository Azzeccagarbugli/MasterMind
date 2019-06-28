package it.unicam.cs.pa.mastermind.factories;


import it.unicam.cs.pa.mastermind.ui.ConsoleInteractionView;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

public class ConsoleInteractionViewFactory implements InteractionViewFactory {

	@Override
	public InteractionView getNewInstance() {
		return new ConsoleInteractionView();
	}

}
