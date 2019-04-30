/**
 * 
 */
package it.unicam.cs.pa.mastermind.players;

import java.util.List;

import it.unicam.cs.pa.mastermind.gui.InteractionManager;
import it.unicam.cs.pa.mastermind.pegs.CodePegs;

/**
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class HumanBreaker implements CodeBreaker {

	private boolean giveUp = false;

	public boolean isGiveUp() {
		return giveUp;
	}

	public void setGiveUp(boolean giveUp) {
		this.giveUp = giveUp;
	}

	@Override
	public List<CodePegs> getCode(InteractionManager inputManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
