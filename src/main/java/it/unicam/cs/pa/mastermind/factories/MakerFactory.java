package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

//TODO Introduzione
public interface MakerFactory extends PlayerFactory {
	public CodeMaker getMaker(InteractionView view, int seqLength, int attempts);
}
