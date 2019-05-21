package it.unicam.cs.pa.mastermind.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.factories.*;
import it.unicam.cs.pa.mastermind.gamecore.SingleGame;
import it.unicam.cs.pa.mastermind.players.BreakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.MakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.players.PlayerFactoryRegistry;

/**
 * Interazione iniziale con l'utente via linea di comando
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class ConsoleStartManager implements StartManager {

	private int attempts;
	private int sequenceLength;
	private boolean toContinue = true;
	private boolean keepSettings = false;
	private InteractionManager intManager;
	int lowTreshholdLength;
	int highTresholdLength;
	int lowTreshholdAttempts;
	private SingleGame currentGame;
	private MakerFactoryRegistry makers;
	private BreakerFactoryRegistry breakers;
	private CodeMaker currentMaker;
	private CodeBreaker currentBreaker;

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

	public ConsoleStartManager() {
		toContinue = true;
		keepSettings = false;
		lowTreshholdLength = 1;
		highTresholdLength = 10;
		lowTreshholdAttempts = 1;
		makers = new MakerFactoryRegistry();
		breakers = new BreakerFactoryRegistry();
	}

	@Override
	public void start() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			while (toContinue) {
				intManager = new ConsoleInteractionManager(reader);
				System.out.format(ANSI_CYAN_BOLD + "%-1s " + ANSI_YELLOW + "%43s" + ANSI_RESET + "\n\n\n",
						mastermindLogo, mastermindCaptionStart);
				if (!keepSettings) {
					attempts = 9;
					sequenceLength = 4;
					setupNewPlayers(reader);

					if (this.askNewSettings(reader)) {
						attempts = askNewAttempts(reader, lowTreshholdAttempts);
						sequenceLength = askNewlength(reader, lowTreshholdLength, highTresholdLength);
					}
				}
				System.out.println("\nNow starting the game");
				currentGame = new SingleGame(this.sequenceLength, this.attempts, this.intManager, currentBreaker,
						currentMaker);
				boolean[] newSettings = currentGame.start();
				this.toContinue = newSettings[0];
				this.keepSettings = newSettings[1];
				this.clearScreen();
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		this.ending();
	}

	private void setupNewPlayers(BufferedReader reader) throws NumberFormatException, IOException {
		MakerFactory mFactory = (MakerFactory) makers.getFactoryByName(getPlayerName(makers, false, reader));
		BreakerFactory bFactory = (BreakerFactory) breakers.getFactoryByName(getPlayerName(breakers, true, reader));
		currentMaker = mFactory.getMaker();
		currentBreaker = bFactory.getBreaker();
	}

	private String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker, BufferedReader reader)
			throws NumberFormatException, IOException {
		System.out.println("Select the " + (isBreaker ? "breaker" : "maker") + " from this list");
		List<String> nomi = registry.getPlayersNames();
		IntStream.range(0, nomi.size())
				.forEach(index -> System.out.println(index + 1 + " - " + nomi.get(index).toUpperCase()));
		int intInput = 0;
		do {
			try {
				System.out.print("> ");
				intInput = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Please insert a numeric value");
			}
		} while (intInput < 1 || intInput > nomi.size());
		System.out.println("You chose a " + nomi.get(intInput - 1) + " " + (isBreaker ? "breaker" : "maker"));
		return nomi.get(intInput - 1);
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

	public static void main(String[] args) {
		ConsoleStartManager startManager = new ConsoleStartManager();
		startManager.start();
	}
}
