package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.RandomBotMaker;

/**
 * Classe factory estensione di <code>MakerFactory</code> impiegata per ottenere istanze di <code>RandomBotMaker</code>.
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
