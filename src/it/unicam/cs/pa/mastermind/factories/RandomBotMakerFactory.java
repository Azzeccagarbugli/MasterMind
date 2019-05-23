package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.RandomBotMaker;

/**
 * Classe concreta, la quale estende la classe astratta
 * <code>MakerFacotry</code>, e consente la creazione di una factory di player
 * random bot maker.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class RandomBotMakerFactory extends MakerFactory {

	@Override
	public CodeMaker getMaker() {
		return new RandomBotMaker();
	}

}
