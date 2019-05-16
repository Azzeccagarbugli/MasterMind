package it.unicam.cs.pa.mastermind.players;

import it.unicam.cs.pa.mastermind.ui.GameMode;
import it.unicam.cs.pa.mastermind.ui.InteractionManager;

/**
 * La classe BreakerFactory genera dei player decodificatori all'interno della
 * piattaforma di gioco.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BreakerFactory {

	/**
	 * Il seguente metodo consente di effettuare il get di un player breaker.
	 * 
	 * @param mode       la gamemode con la quale si vuole effettuare la partita
	 * @param intManager l'InteractionManager con il quale effettuare le interazioni
	 *                   di gioco
	 * @return il tipo di player corrente
	 */
	public CodeBreaker getBreaker(GameMode mode, InteractionManager intManager) {
		switch (mode) {
		case HUMANBREAKERVSHUMANMAKER:
		case HUMANBREAKERVSBOTMAKER:
			return new InteractiveBreaker(intManager);
		case BOTBREAKERVSBOTMAKER:
		case BOTBREAKERVSHUMANMAKER:
			return new RandomBotBreaker();
		}
		return null;
	}
}