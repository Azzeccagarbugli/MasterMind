package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.InteractiveMaker;

/**
 * Classe factory estensione di <code>MakerFactory</code> impiegata per ottenere istanze di <code>InteractiveMaker</code>.
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
