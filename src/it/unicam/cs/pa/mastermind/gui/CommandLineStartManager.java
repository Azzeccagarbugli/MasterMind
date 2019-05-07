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
	
	private String mastermindLogo = "\r\n" + 
			"                  _                      _           _ \r\n" + 
			"  /\\/\\   __ _ ___| |_ ___ _ __ _ __ ___ (_)_ __   __| |\r\n" + 
			" /    \\ / _` / __| __/ _ \\ '__| '_ ` _ \\| | '_ \\ / _` |\r\n" + 
			"/ /\\/\\ \\ (_| \\__ \\ ||  __/ |  | | | | | | | | | | (_| |\r\n" + 
			"\\/    \\/\\__,_|___/\\__\\___|_|  |_| |_| |_|_|_| |_|\\__,_|\r\n" + 
			"                                                       \r\n" + 
			"";
	private String mastermindCaptionStart = "Welcome player, play and have fun!";
	private String mastermindCaptionEnd = "Thank you for taking part in this game, see you!";

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
				System.out.format("%-1s %43s\n\n\n", mastermindLogo, mastermindCaptionStart);
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

					System.out.format(String.format("\n+%13s+%26s+\n", " ", " ").replace(' ', '-'));
					System.out.format("| Chosen mode | %12s %" + beautifyGameMode(mode) + "s\n", mode, "|");
					System.out.format(String.format("+%13s+%26s+\n", " ", " ").replace(' ', '-'));

					maker = makerFactory.apply(mode);
					breaker = breakerFactory.apply(mode);

					String strInput = "";
					while (!(strInput.toLowerCase().equals("y") ^ strInput.toLowerCase().equals("n"))) {
						System.out.print(
								"\nWould you like to start a new match using the default settings (9 attempts and 4 pegs long sequences)? [Y/N]"
										+ "\n" + "> ");
						strInput = reader.readLine();
					}

					if (strInput.toLowerCase().equals("n")) {
						do {
							try {
								System.out.print(
										"Insert the number of attempts: [equal or greater than 1]" + "\n" + "> ");
								attempts = Integer.parseInt(reader.readLine());
							} catch (NumberFormatException e) {
								System.out.println("Please insert a numeric value greater than 1");
							}
						} while (attempts < 1);
						do {
							try {
								System.out.print("Insert the length of pegs sequences: [between 1 and 20, inclusive]"
										+ "\n" + "> ");
								sequenceLength = Integer.parseInt(reader.readLine());
							} catch (NumberFormatException e) {
								System.out.println("Please insert a numeric value between 1 and 20, inclusive");
							}
						} while (sequenceLength < 1 || sequenceLength > 20);
					}
				}

				System.out.println("\nNow starting the game");
				game = new SingleGame(this.maker, this.breaker, this.sequenceLength, this.attempts, this.intManager);
				boolean[] newSettings = game.start();
				this.toContinue = newSettings[0];
				this.keepSettings = newSettings[1];
				clearScreen();

			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		/* chiusura start */
		System.out.format("\n%-1s %50s", mastermindLogo, mastermindCaptionEnd);
		System.exit(0);
	}

	private Function<GameMode, CodeMaker> makerFactory = gm -> (gm.equals(GameMode.HUMANBREAKERVSHUMANMAKER)
			|| gm.equals(GameMode.BOTBREAKERVSHUMANMAKER)) ? new HumanMaker(this.intManager) : new BotMaker();
	private Function<GameMode, CodeBreaker> breakerFactory = gm -> (gm.equals(GameMode.HUMANBREAKERVSHUMANMAKER)
			|| gm.equals(GameMode.HUMANBREAKERVSBOTMAKER)) ? new HumanBreaker(this.intManager) : new BotBreaker();

	/**
	 * Metodo privato per una migliore formattazione del riquadro contenente la
	 * modalità di gioco
	 * 
	 * @param gm
	 * @return
	 */
	private int beautifyGameMode(GameMode gm) {
		switch (gm) {
		case HUMANBREAKERVSHUMANMAKER:
			return 1;
		case HUMANBREAKERVSBOTMAKER:
			return 3;
		case BOTBREAKERVSHUMANMAKER:
			return 3;
		case BOTBREAKERVSBOTMAKER:
			return 5;
		default:
			return 0;
		}
	}

	/**
	 * Clear della console.
	 */
	public void clearScreen() {
		System.out.println(new String(new char[50]).replace("\0", "\r\n"));
	}

	public static void main(String[] args) {
		CommandLineStartManager startManager = new CommandLineStartManager();
		startManager.start();
	}

}
