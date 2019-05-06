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
	}

	@Override
	public void start() {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

			while (toContinue) {
				int intInput = 0;
				intManager = new CommandLineInteractionManager(reader);
				System.out.println("Welcome to MasterMind!");
				if (!keepSettings) {
					while (!((intInput >= 1) && (intInput <= 4))) {
						System.out.print("Select the game mode: " + "\n" + "- Human Breaker VS Human Maker [1]" + "\n"
								+ "- Human Breaker VS Bot Maker [2]" + "\n" + "- Bot Breaker VS Human Maker [3]" + "\n"
								+ "- Bot Breaker VS Bot Maker [4]" + "\n" + "> ");
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


					String strInput = "";
					while (!(strInput.toLowerCase().equals("y") ^ strInput.toLowerCase().equals("n"))) {
						System.out.print(
								"Would you like to start a new match using the default settings (9 attempts and 4 pegs long sequences)? [Y/N]"
										+ "\n" + "> ");
						strInput = reader.readLine();
					}

					if (strInput.toLowerCase().equals("n")) {
						do {
							try {
								System.out.print("Insert the number of attempts (greater than 1): " + "\n" + "> ");
								attempts = Integer.parseInt(reader.readLine());
							} catch (NumberFormatException e) {
								System.out.println("Please insert a numeric value (greater than 1)");
							}
						} while (attempts < 1);
						do {
							try {
								System.out.print("Insert the length of pegs sequences (between 1 and 20, inclusive): " + "\n" + "> ");
								sequenceLength = Integer.parseInt(reader.readLine());
							} catch (NumberFormatException e) {
								System.out.println("Please insert a numeric value (between 1 and 20, inclusive)");
							}
						} while (sequenceLength < 1 || sequenceLength > 20);
					}
				}

				System.out.println("Now starting the game");
				game = new SingleGame(this.maker, this.breaker, this.sequenceLength, this.attempts, this.intManager);
				boolean[] newSettings = game.start();
				this.toContinue = newSettings[0];
				this.keepSettings = newSettings[1];

			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		System.out.println("\n" + "Thank you for taking part in Mastermind!");
		System.exit(0);
		/* chiusura start */ }

	private Function<GameMode, CodeMaker> makerFactory = gm -> (gm.equals(GameMode.HUMANBREAKERVSHUMANMAKER)
			|| gm.equals(GameMode.BOTBREAKERVSHUMANMAKER)) ? new HumanMaker(this.intManager) : new BotMaker();
	private Function<GameMode, CodeBreaker> breakerFactory = gm -> (gm.equals(GameMode.HUMANBREAKERVSHUMANMAKER)
			|| gm.equals(GameMode.HUMANBREAKERVSBOTMAKER)) ? new HumanBreaker(this.intManager) : new BotBreaker();

	public static void main(String[] args) {
		CommandLineStartManager startManager = new CommandLineStartManager();
		startManager.start();
	}

}
