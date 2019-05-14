package it.unicam.cs.pa.mastermind.players;

import it.unicam.cs.pa.mastermind.gui.GameMode;
import it.unicam.cs.pa.mastermind.gui.InteractionManager;

public class MakerFactory {

	public CodeMaker getMaker(GameMode mode, InteractionManager intManager) {
		switch(mode) {
		case HUMANBREAKERVSHUMANMAKER:
		case BOTBREAKERVSHUMANMAKER:
			return new InteractiveMaker(intManager);
		case BOTBREAKERVSBOTMAKER:
		case HUMANBREAKERVSBOTMAKER:
			return new RandomBotMaker();
		}
		return null;
	}
}