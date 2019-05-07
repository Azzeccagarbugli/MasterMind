/**
 * 
 */
package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.List;

import it.unicam.cs.pa.mastermind.gui.InteractionManager;
import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

/**
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class HumanMaker implements CodeMaker {


	private InteractionManager manager;
	
	public HumanMaker(InteractionManager intManager) {
		this.manager = intManager;
	}
	
	@Override
	public List<ColorPegs> getCodeToGuess(int sequenceLength) {
		List<ColorPegs> listToGuess = new ArrayList<ColorPegs>();
		manager.getIndexSequence(sequenceLength, true).stream().map(index -> ColorPegs.values()[index]).forEach(listToGuess::add);
		return listToGuess;
	}

}
