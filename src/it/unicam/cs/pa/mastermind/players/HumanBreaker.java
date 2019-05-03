/**
 * 
 */
package it.unicam.cs.pa.mastermind.players;

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
	public List<ColorPegs> getCode(int sequenceLength) {
		// TODO Auto-generated method stub
		return null;
	}

}
