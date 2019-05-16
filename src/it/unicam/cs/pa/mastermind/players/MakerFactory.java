package it.unicam.cs.pa.mastermind.players;

import it.unicam.cs.pa.mastermind.ui.GameMode;
import it.unicam.cs.pa.mastermind.ui.InteractionManager;

/**
 * La classe MakerFactory genera dei player codificatori all'interno della
 * piattaforma di gioco.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class MakerFactory {

	/**
	 * Il seguente metodo consente di effettuare il get di un player maker.
	 * 
	 * @param mode       la gamemode con la quale si vuole effettuare la partita
	 * @param intManager l'InteractionManager con il quale effettuare le interazioni
	 *                   di gioco
	 * @return il tipo di player corrente
	 */
	public CodeMaker getMaker(GameMode mode, InteractionManager intManager) {
		switch(mode) {
		case HUMANBREAKERVSHUMANMAKER:
		case BOTBREAKERVSHUMANMAKER:
			return new InteractiveMaker(intManager);
		case BOTBREAKERVSBOTMAKER:
		case HUMANBREAKERVSBOTMAKER:
			return new RandomBotMaker();
		}
		return null;
	}
}