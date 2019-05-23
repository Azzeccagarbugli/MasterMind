package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.InteractiveMaker;

/**
 * Classe concreta, la quale estende la classe astratta
 * <code>MakerFacotry</code>, e consente la creazione di una factory di player
 * interactive.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class InteractiveMakerFactory extends MakerFactory {

	@Override
	public CodeMaker getMaker() {
		return new InteractiveMaker();
	}

}
