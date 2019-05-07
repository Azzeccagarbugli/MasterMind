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
public class HumanBreaker implements CodeBreaker {

	private boolean giveUp = false;
	private InteractionManager manager;
	
	public HumanBreaker(InteractionManager intManager) {
		this.manager = intManager;
	}
	public boolean isGiveUp() {
		return giveUp;
	}

	public void setGiveUp(boolean giveUp) {
		this.giveUp = giveUp;
	}

	@Override
	public List<ColorPegs> getAttempt(int sequenceLength) {
		List<ColorPegs> listAttempt = new ArrayList<ColorPegs>();
		manager.getIndexSequence(sequenceLength, false).stream().map(index -> ColorPegs.values()[index]).forEach(listAttempt::add);
		return listAttempt;
	}

}
