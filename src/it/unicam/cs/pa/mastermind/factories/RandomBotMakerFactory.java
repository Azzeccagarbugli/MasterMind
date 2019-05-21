package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.RandomBotMaker;

public class RandomBotMakerFactory extends MakerFactory {

	@Override
	public CodeMaker getMaker() {
		return new RandomBotMaker();
	}

}
