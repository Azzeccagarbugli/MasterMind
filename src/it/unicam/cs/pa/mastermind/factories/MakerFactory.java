package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;

public abstract class MakerFactory implements PlayerFactory {
	public abstract CodeMaker getMaker();
}
