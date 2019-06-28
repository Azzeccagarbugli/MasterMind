package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.ui.GameView;

//TODO Introduzione
public interface MakerFactory extends PlayerFactory {
	public CodeMaker getMaker(GameView view, int seqLength, int attempts);
}
