/**
 * 
 */
package it.unicam.cs.pa.mastermind;

/**
 * @author Francesco
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
	public CodePegs[] getCode(InteractionManager inputManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
