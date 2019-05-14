package it.unicam.cs.pa.mastermind.players;

import it.unicam.cs.pa.mastermind.gui.GameMode;
import it.unicam.cs.pa.mastermind.gui.InteractionManager;

public class BreakerFactory {

	public CodeBreaker getBreaker(GameMode mode, InteractionManager intManager) {
		switch(mode) {
		case HUMANBREAKERVSHUMANMAKER:
		case HUMANBREAKERVSBOTMAKER:
			return new InteractiveBreaker(intManager);
		case BOTBREAKERVSBOTMAKER:
		case BOTBREAKERVSHUMANMAKER:
			return new RandomBotBreaker();
		}
		return null;
	}
}