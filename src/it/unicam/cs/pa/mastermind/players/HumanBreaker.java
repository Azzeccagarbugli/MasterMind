/**
 * 
 */
package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unicam.cs.pa.mastermind.gui.InteractionManager;
import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

/**
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class HumanBreaker implements CodeBreaker {

	private boolean giveUp;
	private InteractionManager manager;
	private Set<List<ColorPegs>> combinationAttempts;

	public HumanBreaker(InteractionManager intManager) {
		giveUp = false;
		this.manager = intManager;
		combinationAttempts = new HashSet<>();
	}

	public boolean isGiveUp() {
		return giveUp;
	}

	public void setGiveUp(boolean giveUp) {
		this.giveUp = giveUp;
	}

	@Override
	public List<ColorPegs> getAttempt(int sequenceLength) {
		List<ColorPegs> listAttempt;
		do {
			listAttempt = new ArrayList<ColorPegs>();
			manager.getIndexSequence(sequenceLength, false).stream().map(index -> ColorPegs.values()[index]).forEach(listAttempt::add);
		} while (combinationAttempts.contains(listAttempt));
		return listAttempt;
	}

}
