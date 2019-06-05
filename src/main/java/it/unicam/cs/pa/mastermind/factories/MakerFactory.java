package it.unicam.cs.pa.mastermind.factories;

import it.unicam.cs.pa.mastermind.players.CodeMaker;

/**
 * Classe factory astratta estensione di <code>PlayerFactory</code> da estendere
 * con classi factory concrete finalizzate all'ottenimento di istanze di
 * <code>CodeMaker</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class MakerFactory implements PlayerFactory {
	public abstract CodeMaker getMaker();
}
