package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.InteractiveMaker;

public class InteractiveMakerFactory extends MakerFactory {

	@Override
	public CodeMaker getMaker() {
		return new InteractiveMaker();
	}

}
