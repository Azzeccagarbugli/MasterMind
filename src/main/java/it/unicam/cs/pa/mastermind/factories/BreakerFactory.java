package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.ui.GameView;

//TODO Introduzione
public interface BreakerFactory extends PlayerFactory {
	public CodeBreaker getBreaker(GameView view, int seqLength, int attempts);
}
