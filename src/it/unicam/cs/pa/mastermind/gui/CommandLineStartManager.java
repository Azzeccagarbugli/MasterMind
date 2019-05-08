/**
 * 
 */
package it.unicam.cs.pa.mastermind.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.stream.IntStream;

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
	private InteractionManager intManager;

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_CYAN_BOLD = "\033[1;96m";
	private static final String ANSI_YELLOW = "\033[0;93m";
	private static final String ANSI_PURPLE_BOLD = "\033[1;95m";

	private String mastermindLogo = "\r\n" + "                  _                      _           _ \r\n"
			+ "  /\\/\\   __ _ ___| |_ ___ _ __ _ __ ___ (_)_ __   __| |\r\n"
			+ " /    \\ / _` / __| __/ _ \\ '__| '_ ` _ \\| | '_ \\ / _` |\r\n"
			+ "/ /\\/\\ \\ (_| \\__ \\ ||  __/ |  | | | | | | | | | | (_| |\r\n"
			+ "\\/    \\/\\__,_|___/\\__\\___|_|  |_| |_| |_|_|_| |_|\\__,_|\r\n"
			+ "                                                       \r\n" + "";
	private String mastermindCaptionStart = "Welcome player, play and have fun!";
	private String mastermindCaptionEnd = "Thank you for taking part in this game, see you!";

	public CommandLineStartManager() {
		toContinue = true;
		keepSettings = false;
	}

	@Override
	public void start() {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

			while (toContinue) {
				int intInput = 0;
				intManager = new CommandLineInteractionManager(reader);
				System.out.format(ANSI_CYAN_BOLD + "%-1s " + ANSI_YELLOW + "%43s" + ANSI_RESET + "\n\n\n",
						mastermindLogo, mastermindCaptionStart);
				if (!keepSettings) {
					while (!((intInput >= 1) && (intInput <= 4))) {
						System.out.print("Select the game mode: " + "\n");
						IntStream.range(0, GameMode.values().length)
								.mapToObj(index -> String.format("- %s [%d] ",
										GameMode.values()[index].getDescription(), index + 1))
								.forEach(System.out::println);

						try {
							System.out.print("> ");
							intInput = Integer.parseInt(reader.readLine());
						} catch (NumberFormatException e) {
							System.out.println("Please insert a numeric value");
						}
					}
					mode = (GameMode.values())[intInput - 1];

					System.out.format(String.format(ANSI_PURPLE_BOLD + "\n+%13s+%30s+\n", " ", " ").replace(' ', '-'));
					System.out.format("| Chosen mode | %12s %" + beautifyGameMode(mode) + "s\n",
							ANSI_RESET + mode.getDescription() + ANSI_PURPLE_BOLD, "|");
					System.out.format(String.format("+%13s+%30s+\n" + ANSI_RESET, " ", " ").replace(' ', '-'));

					attempts = 9;
					sequenceLength = 4;
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
				game = new SingleGame(makerFactory.apply(mode), breakerFactory.apply(mode), this.sequenceLength, this.attempts, this.intManager);
				boolean[] newSettings = game.start();
				this.toContinue = newSettings[0];
				this.keepSettings = newSettings[1];
				clearScreen();

			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		/* Chiusura del gioco */
		System.out.format(ANSI_CYAN_BOLD + "%-1s " + ANSI_YELLOW + "%50s" + ANSI_RESET, mastermindLogo,
				mastermindCaptionEnd);
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
