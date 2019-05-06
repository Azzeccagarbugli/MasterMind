/**
 * 
 */
package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unicam.cs.pa.mastermind.gui.InteractionManager;
import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

/**
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BotMaker implements CodeMaker {

	@Override
	public List<ColorPegs> getCodeToGuess(int sequenceLength, InteractionManager intManager) {
		List<ColorPegs> listToGuess = new ArrayList<ColorPegs>();
		new Random().ints(sequenceLength, 1, ColorPegs.values().length).boxed().map(index -> ColorPegs.values()[index]).forEach(listToGuess::add);
		return listToGuess;
	}

}
