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
	private InteractionManager intManager;
	int lowTreshholdLength;
	int highTresholdLength;
	int lowTreshholdAttempts;

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

	private Function<GameMode, CodeMaker> makerFactory = gm -> (gm.equals(GameMode.HUMANBREAKERVSHUMANMAKER)
			|| gm.equals(GameMode.BOTBREAKERVSHUMANMAKER)) ? new HumanMaker(this.intManager) : new BotMaker();
	private Function<GameMode, CodeBreaker> breakerFactory = gm -> (gm.equals(GameMode.HUMANBREAKERVSHUMANMAKER)
			|| gm.equals(GameMode.HUMANBREAKERVSBOTMAKER)) ? new HumanBreaker(this.intManager) : new BotBreaker();

	public CommandLineStartManager() {
		toContinue = true;
		keepSettings = false;
		lowTreshholdLength = 1;
		highTresholdLength = 10;
		lowTreshholdAttempts = 1;
	}

	@Override
	public void start() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			while (toContinue) {
				intManager = new CommandLineInteractionManager(reader);
				System.out.format(ANSI_CYAN_BOLD + "%-1s " + ANSI_YELLOW + "%43s" + ANSI_RESET + "\n\n\n",
						mastermindLogo, mastermindCaptionStart);
				if (!keepSettings) {
					attempts = 9;
					sequenceLength = 4;
					mode = this.getGameMode(reader);
					if (this.askNewSettings(reader)) {
						attempts = askNewAttempts(reader, lowTreshholdAttempts);
						sequenceLength = askNewlength(reader, lowTreshholdLength, highTresholdLength);
					}
				}
				System.out.println("\nNow starting the game");
				boolean[] newSettings = new SingleGame(makerFactory.apply(mode), breakerFactory.apply(mode),
						this.sequenceLength, this.attempts, this.intManager).start();
				this.toContinue = newSettings[0];
				this.keepSettings = newSettings[1];
				this.clearScreen();
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		this.ending();
	}

	/**
	 * Chiede all'utente quale modalità di gioco desidera per la nuova partita.
	 * 
	 * @param reader il <code>BufferReader</code> passato come argomento
	 * @return la modalità di gioco selezionata
	 * @throws IOException se il valore inserito non è un valore numerico
	 */
	private GameMode getGameMode(BufferedReader reader) throws IOException {
		int intInput = 0;
		do {
			System.out.print("Select the game mode: " + "\n");
			IntStream.range(0, GameMode.values().length)
					.mapToObj(
							index -> String.format("- %s [%d] ", GameMode.values()[index].getDescription(), index + 1))
					.forEach(System.out::println);
			try {
				System.out.print("> ");
				intInput = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Please insert a numeric value");
			}
		} while (!((intInput >= 1) && (intInput <= 4)));

		this.printChosenMode((GameMode.values())[intInput - 1]);
		return (GameMode.values())[intInput - 1];
	}

	/**
	 * Stampa su console la modalità di gioco scelta dall'utente.
	 * 
	 * @param mode la modalità di gioco inserito
	 */
	private void printChosenMode(GameMode mode) {
		System.out.format(String.format(ANSI_PURPLE_BOLD + "\n+%13s+%30s+\n", " ", " ").replace(' ', '-'));
		System.out.format("| Chosen mode | %12s %" + beautifyGameMode(mode) + "s\n",
				ANSI_RESET + mode.getDescription() + ANSI_PURPLE_BOLD, "|");
		System.out.format(String.format("+%13s+%30s+\n" + ANSI_RESET, " ", " ").replace(' ', '-'));
	}

	/**
	 * Chiede all'utente via console se vuole iniziare una nuova partita con le
	 * impostazioni standard o meno.
	 * 
	 * @param reader il <code>BufferReader</code> passato come argomento
	 * @return un array di booleani contenente i settaggi per la prossima partita
	 * @throws IOException se il valore inserito non è un valore numerico
	 */
	private boolean askNewSettings(BufferedReader reader) throws IOException {
		String strInput = "";
		while (!(strInput.toLowerCase().equals("y") ^ strInput.toLowerCase().equals("n"))) {
			System.out.print(
					"\nWould you like to start a new match using the default settings (9 attempts and 4 pegs long sequences)? [Y/N]"
							+ "\n" + "> ");
			strInput = reader.readLine();
		}
		return strInput.toLowerCase().equals("n") ? true : false;
	}

	/**
	 * Chiede all'utente via console il nuovo numero di tentativi per indovinare la
	 * sequenza.
	 * 
	 * @param reader  il <code>BufferReader</code> passato come argomento
	 * @param lowTres il valore di tentativi che si desidera effettuare
	 * @return il nuovo numero di tentativi
	 * @throws IOException se il valore inserito non è un valore numerico
	 */
	private int askNewAttempts(BufferedReader reader, int lowTres) throws IOException {
		int attempts = 0;
		do {
			try {
				System.out
						.print("Insert the number of attempts: [equal or greater than " + lowTres + "]" + "\n" + "> ");
				attempts = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Please insert a numeric value greater than " + lowTres);
			}
		} while (attempts < lowTres);
		return attempts;
	}

	/**
	 * Chiede all'utente via console la nuova lunghezza delle sequenze da indovinare
	 * e tentativo.
	 * 
	 * @param reader   il <code>BufferReader</code> passato come argomento
	 * @param lowTres  il numero precedente dei tentativi
	 * @param highTres il valore numerico della lunghezza della sequenza
	 * @return la nuova lunghezza della sequenza da inserire
	 * @throws IOException se il valore inserito non è un valore numerico
	 */
	private int askNewlength(BufferedReader reader, int lowTres, int highTres) throws IOException {
		int length = 0;
		do {
			try {
				System.out.print("Insert the length of pegs sequences: [between " + lowTres + " and " + highTres
						+ ", inclusive]" + "\n" + "> ");
				length = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				System.out.println(
						"Please insert a numeric value between " + lowTres + " and " + highTres + ", inclusive");
			}
		} while (length < lowTres || length > highTres);
		return length;
	}

	/**
	 * Comunica la fine del gioco e interrompe il processo.
	 */
	private void ending() {
		System.out.format(ANSI_CYAN_BOLD + "%-1s " + ANSI_YELLOW + "%50s" + ANSI_RESET, mastermindLogo,
				mastermindCaptionEnd);
		System.exit(0);
	}

	/**
	 * Viene effettuata una sorta di operazione clean per la console stampando 100
	 * linee di testo vuote.
	 */
	private void clearScreen() {
		System.out.println("##################################################################################");
		System.out.println(new String(new char[100]).replace("\0", "\r\n"));
	}

	/**
	 * Metodo privato per una migliore formattazione del riquadro contenente la
	 * modalità di gioco.
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

	public static void main(String[] args) {
		CommandLineStartManager startManager = new CommandLineStartManager();
		startManager.start();
	}
}
