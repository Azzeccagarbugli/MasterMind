/**
 * 
 */
package it.unicam.cs.pa.mastermind.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

import it.unicam.cs.pa.mastermind.core.SingleGame;
import it.unicam.cs.pa.mastermind.players.*;

/**
 * Interazione iniziale con l'utente via linea di comando
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class CommandLineStartManager implements StartManager {

	private GameMode mode;
	private int attempts;
	private int sequenceLength;
	private boolean toContinue = true;
	private boolean keepSettings = false;
	private SingleGame game;
	private CodeMaker maker;
	private CodeBreaker breaker;
	private InteractionManager intManager;

	public CommandLineStartManager() {
		attempts = 9;
		sequenceLength = 4;
		toContinue = true;
		keepSettings = false;
		intManager = new CommandLineInteractionManager();
	}

	@Override
	public void start() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int intInput = 0;
			while (toContinue) {
				System.out.println("Welcome to MasterMind!");
				if (!keepSettings) {
					while (!((intInput >= 1) && (intInput <= 4))) {
						System.out.print("Select the game mode: " + "\n" + "- Human Breaker VS Human Maker [1]" + "\n"
								+ "- Human Breaker VS Bot Maker [2]" + "\n" + "- Bot Breaker VS Human Maker [3]"
								+ "\n" + "- Bot Breaker VS Bot Maker [4]" + "\n" + "> ");
						try {
							intInput = Integer.parseInt(reader.readLine());
						} catch (NumberFormatException e) {
							System.out.println("Please insert a numeric value");
						}
					}
					mode = (GameMode.values())[intInput - 1];
					System.out.println("Chosen mode: " + mode);

					maker = makerFactory.apply(mode);
					breaker = breakerFactory.apply(mode);

					/*
					 * switch (mode) { case HUMANBREAKERVSHUMANMAKER: maker = new
					 * HumanMaker(this.intManager); breaker = new HumanBreaker(this.intManager);
					 * break; case HUMANBREAKERVSBOTMAKER: maker = new BotMaker(); breaker = new
					 * HumanBreaker(this.intManager); break; case BOTBREAKERVSHUMANMAKER: maker =
					 * new HumanMaker(this.intManager); breaker = new BotBreaker(); break; case
					 * BOTBREAKERVSBOTMAKER: maker = new BotMaker(); breaker = new BotBreaker();
					 * break; }
					 */

					String strInput = "";
					while (!(((strInput.equals("Y") || (strInput.equals("y")))
							^ ((strInput.equals("N") || (strInput.equals("n"))))))) {
						System.out.print(
								"Would you like to start a new match using the default settings (9 attempts and 4 pegs long sequences)? [Y/N]"
										+ "\n" + "> ");
						strInput = reader.readLine();
					}
					if (strInput.equals("N") || strInput.equals("n")) {
						while (attempts <= 0) {
							try {
								System.out.print("Insert the number of attempts: " + "\n" + "> ");
								attempts = Integer.parseInt(reader.readLine());
							} catch (NumberFormatException e) {
								System.out.println("Please insert a numeric value");
							}
						}
						while (sequenceLength <= 0) {
							try {
								System.out.print("Insert the length of pegs sequences: " + "\n" + "> ");
								sequenceLength = Integer.parseInt(reader.readLine());
							} catch (NumberFormatException e) {
								System.out.println("Please insert a numeric value");
							}
						}
					}
				}
				System.out.println("Now starting the game");
				game = new SingleGame(this.maker, this.breaker, this.sequenceLength, this.attempts, this.intManager);
				boolean[] newSettings = game.start();
				this.toContinue = newSettings[0];
				this.keepSettings = newSettings[1];
			}
			reader.close();
			System.out.println("Thank you for taking part in Mastermind!");
			System.exit(0);
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}

	private Function<GameMode, CodeMaker> makerFactory = gm -> (gm.equals(GameMode.HUMANBREAKERVSHUMANMAKER)
			|| gm.equals(GameMode.BOTBREAKERVSHUMANMAKER)) ? new HumanMaker(this.intManager) : new BotMaker();
	private Function<GameMode, CodeBreaker> breakerFactory = gm -> (gm.equals(GameMode.HUMANBREAKERVSHUMANMAKER)
			|| gm.equals(GameMode.HUMANBREAKERVSBOTMAKER)) ? new HumanBreaker(this.intManager) : new BotBreaker();

	public static void main(String[] args) {
		CommandLineStartManager startManager = new CommandLineStartManager();
		startManager.start();
	}

}
