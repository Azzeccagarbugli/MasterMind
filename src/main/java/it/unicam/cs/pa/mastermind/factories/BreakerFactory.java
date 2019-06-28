package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

//TODO Introduzione
public interface BreakerFactory extends PlayerFactory {
	public CodeBreaker getBreaker(InteractionView view, int seqLength, int attempts);
}
