package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;

public abstract class BreakerFactory implements PlayerFactory {
	public abstract CodeBreaker getBreaker();
}
