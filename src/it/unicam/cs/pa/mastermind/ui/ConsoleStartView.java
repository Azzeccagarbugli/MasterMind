package it.unicam.cs.pa.mastermind.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.factories.*;
import it.unicam.cs.pa.mastermind.gamecore.NewGameStats;
import it.unicam.cs.pa.mastermind.gamecore.SingleGame;
import it.unicam.cs.pa.mastermind.players.BreakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.MakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.players.PlayerFactoryRegistry;

/**
 * Interazione iniziale con l'utente via linea di comando.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class ConsoleStartView implements StartView {

	private int attempts;
	private int sequenceLength;
	private boolean toContinue = true;
	private boolean keepSettings = false;
	private ConsoleInteractionView intView;
	int lowTresholdLength;
	int highTresholdLength;
	int lowTresholdAttempts;
	private SingleGame currentGame;
	private MakerFactoryRegistry makers;
	private BreakerFactoryRegistry breakers;
	private CodeMaker currentMaker;
	private CodeBreaker currentBreaker;

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_CYAN_BOLD = "\033[1;96m";
	private static final String ANSI_YELLOW = "\033[0;93m";

	private String mastermindLogo = "\r\n" + "                  _                      _           _ \r\n"
			+ "  /\\/\\   __ _ ___| |_ ___ _ __ _ __ ___ (_)_ __   __| |\r\n"
			+ " /    \\ / _` / __| __/ _ \\ '__| '_ ` _ \\| | '_ \\ / _` |\r\n"
			+ "/ /\\/\\ \\ (_| \\__ \\ ||  __/ |  | | | | | | | | | | (_| |\r\n"
			+ "\\/    \\/\\__,_|___/\\__\\___|_|  |_| |_| |_|_|_| |_|\\__,_|\r\n"
			+ "                                                       \r\n" + "";
	private String mastermindCaptionStart = "Welcome player, play and have fun!";
	private String mastermindCaptionEnd = "Thank you for taking part in this game, see you!";

	/**
	 * Riferimento all'instanza Singleton.
	 */
	private static final ConsoleStartView istance = new ConsoleStartView();

	/**
	 * Costruttore privato della classe ConsoleStartManager.
	 */
	private ConsoleStartView() {
		toContinue = true;
		keepSettings = false;
		lowTresholdLength = 1;
		highTresholdLength = 10;
		lowTresholdAttempts = 1;
		makers = new MakerFactoryRegistry();
		breakers = new BreakerFactoryRegistry();
	}

	/**
	 * Il metodo getInstance garantisce la singolarità della classe all'interno del
	 * parco software.
	 * 
	 * @return l'instanza della classe se presente o meno
	 */
	public static ConsoleStartView getIstance() {
		return istance;
	}

	@Override
	public void start() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {

			while (toContinue) {
				intView = ConsoleInteractionView.getIstance();
				intView.init(reader);
				System.out.format(ANSI_CYAN_BOLD + "%-1s " + ANSI_YELLOW + "%43s" + ANSI_RESET + "\n\n\n",
						mastermindLogo, mastermindCaptionStart);
				if (!keepSettings) {
					attempts = 9;
					sequenceLength = 4;
					setupNewPlayers(reader);

					if (this.askNewSettings(reader)) {
						attempts = askNewAttempts(lowTresholdAttempts, reader);
						sequenceLength = askNewlength(lowTresholdLength, highTresholdLength, reader);
					}
				}
				System.out.println("\nNow starting the game");
				currentGame = new SingleGame(this.sequenceLength, this.attempts, this.intView, currentBreaker,
						currentMaker);
				currentGame.start();
				NewGameStats newStats = this.getNewSettings(reader);
				this.toContinue = newStats.getContinue();
				this.keepSettings = newStats.getKeepSettings();
				this.clearScreen();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.ending();
	}

	private NewGameStats getNewSettings(BufferedReader reader) {
		int intInput = 0;
		try {
			System.out.println("\nThe game has finished, what would you like to do now?");
			while (!((intInput >= 1) && (intInput <= 3))) {
				System.out.print("• Start a new game with the same settings [1]" + "\n"
						+ "• Start a new game with different settings [2]" + "\n" + "• Exit from the game [3]"
						+ "\n> ");
				try {
					intInput = Integer.parseInt(reader.readLine());
				} catch (NumberFormatException e) {
					System.out.println("Please insert a numeric value");
				}
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return new NewGameStats(settingEnd(intInput)[0], settingEnd(intInput)[1]);
	}

	/**
	 * Restituisce le informazioni sull'esito finale della partita, andando a
	 * chiedere all'utente quale settaggi impostare per la prossima.
	 * 
	 * @param input il valore in input selezionato dall'utente
	 * @return l'Array di booleani contenente i settaggi
	 */
	private boolean[] settingEnd(int input) {
		boolean[] endingSettings = new boolean[2];
		switch (input) {
		case 1:
			endingSettings[0] = true;
			endingSettings[1] = true;
			break;
		case 2:
			endingSettings[0] = true;
			endingSettings[1] = false;
			break;
		case 3:
			endingSettings[0] = false;
			endingSettings[1] = false;
			break;
		}
		return endingSettings;
	}

	/**
	 * Metodo privato che esegue il setup dei player da predisporre poi all'interno
	 * della partita corrente.
	 * 
	 * @param reader il buffer con il quale fare il parse delle opzioni passate
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private void setupNewPlayers(BufferedReader reader) throws NumberFormatException, IOException {
		MakerFactory mFactory = (MakerFactory) makers.getFactoryByName(getPlayerName(makers, false, reader));
		BreakerFactory bFactory = (BreakerFactory) breakers.getFactoryByName(getPlayerName(breakers, true, reader));
		currentMaker = mFactory.getMaker();
		currentBreaker = bFactory.getBreaker();
	}

	/**
	 * Metodo privato che stabilisce con quali players si vuole eseguire la partita
	 * corrente.
	 * 
	 * @param registry  il registro che contiene i giocatori disponibili
	 * @param isBreaker valore che stabilisce la veridicità del player breaker o
	 *                  meno
	 * @param reader    il buffer con il quale fare il parse delle opzioni passate
	 * @return la stringa contenente il nome del player
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker, BufferedReader reader)
			throws NumberFormatException, IOException {
		System.out.println("Select the " + (isBreaker ? "breaker" : "maker") + " from this list");
		List<String> names = registry.getPlayersNames();
		IntStream.range(0, names.size())
				.forEach(index -> System.out.println(index + 1 + " - " + names.get(index).toUpperCase()));
		int intInput = 0;
		do {
			try {
				System.out.print("> ");
				intInput = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				System.out.println("Please insert a numeric value");
			}
		} while (intInput < 1 || intInput > names.size());
		System.out.println("You chose a " + names.get(intInput - 1) + " " + (isBreaker ? "breaker" : "maker"));
		return names.get(intInput - 1);
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
	private int askNewAttempts(int lowTres, BufferedReader reader) throws IOException {
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
	private int askNewlength(int lowTres, int highTres, BufferedReader reader) throws IOException {
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
		System.out.println(new String(new char[100]).replace("\0", "\r\n"));
	}

	public static void main(String[] args) {
		/*
		 * Singleton relativo al ConsoleStartManager.
		 */
		ConsoleStartView startView = ConsoleStartView.getIstance();
		startView.start();
	}
}
