package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.RandomBotBreaker;

public class RandomBotBreakerFactory extends BreakerFactory {

	@Override
	public CodeBreaker getBreaker() {
		return new RandomBotBreaker();
	}

}
