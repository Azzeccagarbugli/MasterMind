package it.unicam.cs.pa.mastermind.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.gamecore.NewGameStats;
import it.unicam.cs.pa.mastermind.players.PlayerFactoryRegistry;

/**
 * Implementazione con interazione via console della classe
 * <code>StartView</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class ConsoleStartView extends StartView {

	/**
	 * Reader associato all'istanza di <code>ConsoleStartView</code>.
	 */
	private BufferedReader reader;

	private String mastermindLogo = "\r\n" + "                  _                      _           _ \r\n"
			+ "  /\\/\\   __ _ ___| |_ ___ _ __ _ __ ___ (_)_ __   __| |\r\n"
			+ " /    \\ / _` / __| __/ _ \\ '__| '_ ` _ \\| | '_ \\ / _` |\r\n"
			+ "/ /\\/\\ \\ (_| \\__ \\ ||  __/ |  | | | | | | | | | | (_| |\r\n"
			+ "\\/    \\/\\__,_|___/\\__\\___|_|  |_| |_| |_|_|_| |_|\\__,_|\r\n"
			+ "                                                       \r\n" + "";
	private String mastermindCaptionStart = "Welcome player, play and have fun!";
	private String mastermindCaptionEnd = "Thank you for taking part in this game, see you!";

	/**
	 * Riferimento all'istanza Singleton di <code>ConsoleStartView</code>.
	 */
	private final static ConsoleStartView instance = new ConsoleStartView();

	private ConsoleStartView() {
		super();
		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * @return ConsoleStartView istanza singleton di <code>ConsoleStartView</code>.
	 */
	public static ConsoleStartView getInstance() {
		return instance;
	}

	@Override
	protected void ending() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.clearScreen();
		System.out.format(
				AnsiUtility.ANSI_CYAN_BOLD + "%-1s " + AnsiUtility.ANSI_YELLOW + "%50s" + AnsiUtility.ANSI_RESET,
				mastermindLogo, mastermindCaptionEnd);
		System.exit(0);
	}

	@Override
	protected NewGameStats askNewGameSettings() {
		int intInput = 0;
		try {
			System.out.println("\nThe game has finished, what would you like to do now?");
			for (;;) {
				System.out.print("• Start a new game with the same settings [1]" + "\n"
						+ "• Start a new game with different settings [2]" + "\n" + "• Exit from the game [3]"
						+ "\n> ");
				try {
					intInput = Integer.parseInt(reader.readLine());
					if (!((intInput >= 1) && (intInput <= 3))) {
						throw new NumberFormatException();
					} else {
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("Please insert a valid numeric value");
				}
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return new NewGameStats(settingEnd(intInput)[0], settingEnd(intInput)[1]);
	}

	/**
	 * 
	 * @param input
	 * @return boolean[] contenente informazioni per la creazione di un oggetto
	 *         <code>NewGameStats</code>.
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
	protected void showNewGameStarting() {
		System.out.println("\nNow starting the game");
	}

	@Override
	protected int askNewLength() {
		int length = 0;
		for (;;) {
			try {
				System.out.print("Insert the length of pegs sequences: [between " + startStats.getLowTresholdLength()
						+ " and " + startStats.getHighTresholdLength() + ", inclusive]" + "\n" + "> ");
				length = Integer.parseInt(reader.readLine());
				if (length < startStats.getLowTresholdLength() || length > startStats.getHighTresholdLength()) {
					throw new NumberFormatException();
				} else {
					break;
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Please insert a numeric value between " + startStats.getLowTresholdLength()
						+ " and " + startStats.getHighTresholdLength() + ", inclusive");
			}
		}
		;

		return length;
	}

	@Override
	protected int askNewAttempts() {
		int attempts = 0;
		for (;;) {
			try {
				System.out.print("Insert the number of attempts: [equal or greater than "
						+ startStats.getLowTresholdAttempts() + "]" + "\n" + "> ");
				attempts = Integer.parseInt(reader.readLine());
				if (attempts < startStats.getLowTresholdAttempts()) {
					throw new NumberFormatException();
				} else {
					break;
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Please insert a numeric value greater than " + startStats.getLowTresholdAttempts());
			}
		}
		;
		return attempts;
	}

	@Override
	protected String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker) {
		System.out.println("Select the " + (isBreaker ? "breaker" : "maker") + " from this list");
		List<String> names = registry.getPlayersNames();
		IntStream.range(0, names.size())
				.forEach(index -> System.out.println(index + 1 + " - " + names.get(index).toUpperCase()));
		int intInput = 0;
		for (;;) {
			try {
				System.out.print("> ");
				intInput = Integer.parseInt(reader.readLine());
				if (intInput < 1 || intInput > names.size()) {
					throw new NumberFormatException();
				} else {
					break;
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Please insert a valid numeric value");
			}
		}
		;
		System.out.println("You chose a " + names.get(intInput - 1) + " " + (isBreaker ? "breaker" : "maker"));
		return names.get(intInput - 1);
	}

	@Override
	protected boolean askNewSettings() {
		String strInput = "";

		for (;;) {
			System.out.print(
					"\nWould you like to start a new match using the default settings (9 attempts and 4 pegs long sequences)? [Y/N]"
							+ "\n" + "> ");
			try {
				strInput = reader.readLine();
				if ((!(strInput.toLowerCase().equals("y") ^ strInput.toLowerCase().equals("n")))) {
					throw new IllegalArgumentException();
				} else {
					break;
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println("Please write Y or N");
			}
		}
		;
		return strInput.toLowerCase().equals("n") ? true : false;
	}

	@Override
	protected void showLogo() {
		System.out.format(AnsiUtility.ANSI_CYAN_BOLD + "%-1s " + AnsiUtility.ANSI_YELLOW + "%43s"
				+ AnsiUtility.ANSI_RESET + "\n\n\n", mastermindLogo, mastermindCaptionStart);
	}

	@Override
	protected InteractionView getInteractionView() {
		ConsoleInteractionView temp = ConsoleInteractionView.getInstance();
		temp.init(reader);
		return temp;
	}

	/**
	 * Si effettua una sorta di pulizia della console di interazione con l'utente
	 * fisico.
	 */
	private void clearScreen() {
		System.out.println(new String(new char[100]).replace("\0", "\r\n"));
	}

	public static void main(String[] args) {
		StartView startView = ConsoleStartView.getInstance();
		startView.startUp();
	}

	@Override
	protected void badEnding(String reason) {
		System.out.println("There was an error during the game:");
		System.out.println(reason);
		System.exit(-1);
	}
}
