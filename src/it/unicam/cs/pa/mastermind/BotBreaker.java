/**
 * 
 */
package it.unicam.cs.pa.mastermind;

import java.util.List;

/**
 * @author Francesco
 *
 */
public class BotBreaker implements CodeBreaker {

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
