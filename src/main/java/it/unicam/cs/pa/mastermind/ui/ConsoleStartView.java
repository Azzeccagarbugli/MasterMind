package it.unicam.cs.pa.mastermind.ui;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.factories.PlayerFactoryRegistry;
import it.unicam.cs.pa.mastermind.gamecore.StartupSettings;

/**
 * Implementazione con interazione via console della classe
 * <code>StartView</code>.
 * Integra il pattern <b>Singleton</b>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class ConsoleStartView implements StartView {

	/**
	 * <code>FilterInputStream</code> fondamentale per le operazioni di Input con
	 * <code>InputStreamReader</code> e <code>BufferedReader</code>
	 */
	private FilterInputStream fis;

	private String mastermindLogo = "\r\n" + "                  _                      _           _ \r\n"
			+ "  /\\/\\   __ _ ___| |_ ___ _ __ _ __ ___ (_)_ __   __| |\r\n"
			+ " /    \\ / _` / __| __/ _ \\ '__| '_ ` _ \\| | '_ \\ / _` |\r\n"
			+ "/ /\\/\\ \\ (_| \\__ \\ ||  __/ |  | | | | | | | | | | (_| |\r\n"
			+ "\\/    \\/\\__,_|___/\\__\\___|_|  |_| |_| |_|_|_| |_|\\__,_|\r\n"
			+ "                                                       \r\n" + "";

	private String mastermindCaptionStart = "Welcome player, play and have fun!";

	private String mastermindCaptionEnd = "Thank you for taking part in this game, see you!";

	/**
	 * Riferimento all'istanza <b>Singleton</b> di <code>ConsoleStartView</code>.
	 */
	private final static ConsoleStartView instance = new ConsoleStartView();

	/**
	 * Inizializzazione della vista con un <code>FilterInputStream</code> che non
	 * porta alla chiusura di <code>System.in</code> all'interno del suo metodo
	 * <code>close()</code>.
	 */
	private ConsoleStartView() {
		super();
		fis = new FilterInputStream(System.in) {
			@Override
			public void close() throws IOException {
			}
		};
	}

	/**
	 * @return ConsoleStartView istanza <b>Singleton</b> di
	 *         <code>ConsoleStartView</code>.
	 */
	public static ConsoleStartView getInstance() {
		return instance;
	}

	@Override
	public void ending() {
		System.out.format(
				AnsiUtility.ANSI_CYAN_BOLD + "%-1s " + AnsiUtility.ANSI_YELLOW + "%50s" + AnsiUtility.ANSI_RESET,
				mastermindLogo, mastermindCaptionEnd);
	}

	@Override
	public StartupSettings askNewStartupSettings() {
		int intInput = 0;
		this.showGameFinalMenu();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(fis))) {
			for (;;) {
				System.out.print("> ");
				try {
					intInput = Integer.parseInt(in.readLine());
					if (!((intInput >= 1) && (intInput <= 3))) {
						throw new NumberFormatException();
					} else {
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("Please insert a valid numeric value");
				}
			}
		} catch (IOException e1) {
			this.badEnding(e1.getMessage());
		}

		return new StartupSettings(settingEnd(intInput)[0], settingEnd(intInput)[1]);
	}

	/**
	 * <b>Contratto</b>: il metodo deve essere impiegato esclusivamente all'interno
	 * di quella che è l'output su console per l'interazione con l'utente fisico.
	 */
	private void showGameFinalMenu() {
		System.out.format(String.format("\n┏%60s┓\n", " ").replace(' ', '━'));
		System.out.format("%s %55s %6s \n", "┃", AnsiUtility.ANSI_CYAN_BOLD
				+ "The game has finished, what would you like to do now?" + AnsiUtility.ANSI_RESET, "┃");
		System.out.format(String.format("┣%3s┳%56s┫\n", " ", " ").replace(' ', '━'));
		System.out.format("%14s ┃ %10s \n", AnsiUtility.ANSI_CYAN_BOLD + "1" + AnsiUtility.ANSI_RESET,
				AnsiUtility.ANSI_CYAN_BOLD + "Start a new game with the same settings" + AnsiUtility.ANSI_RESET);
		System.out.format(String.format("┣%3s╋%56s┫\n", " ", " ").replace(' ', '━'));
		System.out.format("%14s ┃ %10s \n", AnsiUtility.ANSI_CYAN_BOLD + "2" + AnsiUtility.ANSI_RESET,
				AnsiUtility.ANSI_CYAN_BOLD + "Start a new game with different settings" + AnsiUtility.ANSI_RESET);
		System.out.format(String.format("┣%3s╋%56s┫\n", " ", " ").replace(' ', '━'));
		System.out.format("%14s ┃ %10s \n", AnsiUtility.ANSI_CYAN_BOLD + "3" + AnsiUtility.ANSI_RESET,
				AnsiUtility.ANSI_CYAN_BOLD + "Exit from the game" + AnsiUtility.ANSI_RESET);
		System.out.format(String.format("┗%3s┻%56s┛\n", " ", " ").replace(' ', '━'));
	}

	/**
	 * 
	 * @param input
	 * @return boolean[] contenente informazioni per la creazione di un oggetto
	 *         <code>StartupSettings</code>.
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

	@Override
	public void showNewMatchStarting() {
		System.out.println("\nNow starting the game");
	}

	@Override
	public int askNewLength(int lowTreshold, int highTreshhold) {
		int length = 0;

		String askNewLenght = "Insert the length of pegs sequences: [between " + lowTreshold + " and " + highTreshhold
				+ ", inclusive]";

		System.out.format(String.format("┏%70s┓\n", " ").replace(' ', '━'));
		System.out.format("┃ %59s %3s \n", AnsiUtility.ANSI_CYAN_BOLD + askNewLenght + AnsiUtility.ANSI_RESET, "┃");
		System.out.format(String.format("┗%70s┛\n", " ", " ").replace(' ', '━'));

		try (BufferedReader in = new BufferedReader(new InputStreamReader(fis))) {
			for (;;) {
				System.out.print("> ");
				try {
					length = Integer.parseInt(in.readLine());
					if (length < lowTreshold || length > highTreshhold) {
						throw new NumberFormatException();
					} else {
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("Please insert a numeric value between " + lowTreshold + " and " + highTreshhold
							+ ", inclusive");
				}
			}
		} catch (IOException e1) {
			this.badEnding(e1.getMessage());
		}

		return length;
	}

	@Override
	public int askNewAttempts(int lowTreshold) {
		int attempts = 0;

		String askNewAttempts = "Insert the number of attempts: [equal or greater than " + lowTreshold + "]";

		System.out.format(String.format("┏%60s┓\n", " ").replace(' ', '━'));
		System.out.format("┃ %59s %3s \n", AnsiUtility.ANSI_CYAN_BOLD + askNewAttempts + AnsiUtility.ANSI_RESET, "┃");
		System.out.format(String.format("┗%60s┛\n", " ", " ").replace(' ', '━'));

		try (BufferedReader in = new BufferedReader(new InputStreamReader(fis))) {
			for (;;) {
				System.out.print("> ");
				try {
					attempts = Integer.parseInt(in.readLine());
					if (attempts < lowTreshold) {
						throw new NumberFormatException();
					} else {
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("Please insert a numeric value greater than " + lowTreshold);
				}
			}
		} catch (IOException e1) {
			this.badEnding(e1.getMessage());
		}

		return attempts;
	}

	@Override
	public String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker) {
		List<String> names = registry.getPlayersNames();
		List<String> desc = registry.getPlayersDescription();
		this.showMenuSelectMode(isBreaker);
		IntStream.range(0, names.size()).forEach(index -> showMenuChooseMode(names, desc, index));
		int intInput = 0;
		try (BufferedReader in = new BufferedReader(new InputStreamReader(fis))) {
			for (;;) {
				try {
					System.out.print("> ");
					intInput = Integer.parseInt(in.readLine());
					if (intInput < 1 || intInput > names.size()) {
						throw new NumberFormatException();
					} else {
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("Please insert a valid numeric value");
				}
			}
		} catch (IOException e1) {
			this.badEnding(e1.getMessage());
		}

		this.showLogo();
		return names.get(intInput - 1);
	}

	/**
	 * <b>Contratto</b>: il metodo deve essere impiegato esclusivamente all'interno
	 * di quella che è l'output su console per l'interazione con l'utente fisico.Fs
	 */
	private void showMenuSelectMode(boolean isBreaker) {
		String selectionStuff = "Select the " + (isBreaker ? "breaker" : "maker") + " from this list";
		System.out.format(String.format("┏%60s┓\n", " ").replace(' ', '━'));
		System.out.format("%s %59s %11s \n", "┃", AnsiUtility.ANSI_CYAN_BOLD + selectionStuff + AnsiUtility.ANSI_RESET,
				"┃");
		System.out.format(String.format("┣%3s┳%56s┫\n", " ", " ").replace(' ', '━'));
	}

	/**
	 * <b>Contratto</b>: il metodo deve essere impiegato esclusivamente all'interno
	 * di quella che è l'output su console per l'interazione con l'utente fisico.
	 */
	private void showMenuChooseMode(List<String> names, List<String> desc, int index) {
		System.out.format("%14s ┃ %10s • %10s \n", AnsiUtility.ANSI_CYAN_BOLD + (index + 1) + AnsiUtility.ANSI_RESET,
				AnsiUtility.ANSI_CYAN_BOLD + names.get(index) + AnsiUtility.ANSI_RESET,
				AnsiUtility.ANSI_CYAN_BOLD + desc.get(index) + AnsiUtility.ANSI_RESET);
		System.out.format(String.format("%s%4s%56s%s\n", (names.size() -1 == index ? "┗" : "┣"), (names.size() -1 == index ? "┻" : "╋"), " ",
				(names.size() -1 == index ? "┛" : "┫")).replace(' ', '━'));
	}

	@Override
	public boolean askNewLengthsAndAttempts() {
		String strInput = "";
		String askNewLenghtAndAttempts = "Would you like to start a new match using the default settings (9 attempts and 4 pegs long sequences)? [Y/N]";

		System.out.format(String.format("┏%110s┓\n", " ").replace(' ', '━'));
		System.out.format("┃ %59s %s \n", AnsiUtility.ANSI_CYAN_BOLD + askNewLenghtAndAttempts + AnsiUtility.ANSI_RESET,
				"┃");
		System.out.format(String.format("┗%110s┛\n", " ", " ").replace(' ', '━'));

		try (BufferedReader in = new BufferedReader(new InputStreamReader(fis))) {
			for (;;) {
				System.out.print("> ");
				try {
					strInput = in.readLine();
					if ((!(strInput.toLowerCase().equals("y") ^ strInput.toLowerCase().equals("n")))) {
						throw new IllegalArgumentException();
					} else {
						break;
					}
				} catch (IllegalArgumentException e) {
					System.out.println("Please write Y or N");
				}
			}
		} catch (IOException e1) {
			this.badEnding(e1.getMessage());
		}

		return strInput.toLowerCase().equals("n") ? true : false;
	}

	@Override
	public void showLogo() {
		this.clearScreen();
		System.out.format(AnsiUtility.ANSI_CYAN_BOLD + "%-1s " + AnsiUtility.ANSI_YELLOW + "%43s"
				+ AnsiUtility.ANSI_RESET + "\n\n\n", mastermindLogo, mastermindCaptionStart);
	}

	/**
	 * Si effettua una sorta di pulizia della console di interazione con l'utente
	 * fisico. <b>Contratto</b>: il metodo deve essere impiegato esclusivamente
	 * all'interno di quella che è l'output su console per l'interazione con
	 * l'utente fisico.
	 */
	private void clearScreen() {
		System.out.println(new String(new char[100]).replace("\0", "\r\n"));
	}

	@Override
	public void badEnding(String reason) {
		System.out.println("There was an error during the game:");
		System.out.println(reason);
	}

}
