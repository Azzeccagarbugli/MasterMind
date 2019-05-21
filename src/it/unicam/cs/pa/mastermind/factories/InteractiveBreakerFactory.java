package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.InteractiveBreaker;

public class InteractiveBreakerFactory extends BreakerFactory {

	@Override
	public CodeBreaker getBreaker() {
		return new InteractiveBreaker();
	}

}
