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
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class ConsoleStartView implements StartView {

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
	 * Riferimento all'istanza Singleton di <code>ConsoleStartView</code>.
	 */
	private final static ConsoleStartView instance = new ConsoleStartView();

	private ConsoleStartView() {
		super();
		fis = new FilterInputStream(System.in) {
			@Override
			public void close() throws IOException {
			}
		};
	}

	/**
	 * @return ConsoleStartView istanza singleton di <code>ConsoleStartView</code>.
	 */
	public static ConsoleStartView getInstance() {
		return instance;
	}

	@Override
	public void ending() {
		//this.clearScreen();
		System.out.format(
				AnsiUtility.ANSI_CYAN_BOLD + "%-1s " + AnsiUtility.ANSI_YELLOW + "%50s" + AnsiUtility.ANSI_RESET,
				mastermindLogo, mastermindCaptionEnd);
	}

	@Override
	public StartupSettings askNewStartupSettings() {
		int intInput = 0;
		System.out.println("\nThe game has finished, what would you like to do now?");
		System.out.println("• Start a new game with the same settings [1]" + "\n"
				+ "• Start a new game with different settings [2]" + "\n" + "• Exit from the game [3]");
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
			e1.printStackTrace();
			System.exit(-1);
		}
		return new StartupSettings(settingEnd(intInput)[0], settingEnd(intInput)[1]);
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
	public void showNewMatchStarting() {
		System.out.println("\nNow starting the game");
	}

	@Override
	public int askNewLength(int lowTreshold, int highTreshhold) {
		int length = 0;
		System.out.println("Insert the length of pegs sequences: [between " + lowTreshold
				+ " and " + highTreshhold + ", inclusive]");
		try (BufferedReader in = new BufferedReader(new InputStreamReader(fis))) {
			for (;;) {
				System.out.print("> ");
				try {
					length = Integer.parseInt(in.readLine());
					if (length < lowTreshold
							|| length > highTreshhold) {
						throw new NumberFormatException();
					} else {
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("Please insert a numeric value between " + lowTreshold
							+ " and " + highTreshhold + ", inclusive");
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(-1);
		}
		;

		return length;
	}

	@Override
	public int askNewAttempts(int lowTreshold) {
		int attempts = 0;
		System.out.println("Insert the number of attempts: [equal or greater than "
				+ lowTreshold + "]");
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
					System.out.println(
							"Please insert a numeric value greater than " + lowTreshold);
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(-1);
		}
		;
		return attempts;
	}

	@Override
	public String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker) {
		System.out.println("Select the " + (isBreaker ? "breaker" : "maker") + " from this list");
		List<String> names = registry.getPlayersNames();
		List<String> desc = registry.getPlayersDescription();
		IntStream.range(0, names.size())
				.forEach(index -> System.out.println(index + 1 + " - " + names.get(index) + " - " + desc.get(index)));
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
			e1.printStackTrace();
			System.exit(-1);
		}
		;
		System.out.println("You chose a " + names.get(intInput - 1));
		return names.get(intInput - 1);
	}

	@Override
	public boolean askNewLengthsAndAttempts() {
		String strInput = "";
		System.out.println(
				"\nWould you like to start a new match using the default settings (9 attempts and 4 pegs long sequences)? [Y/N]");
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
			e1.printStackTrace();
			System.exit(-1);
		}
		;
		return strInput.toLowerCase().equals("n") ? true : false;
	}

	@Override
	public void showLogo() {
		System.out.format(AnsiUtility.ANSI_CYAN_BOLD + "%-1s " + AnsiUtility.ANSI_YELLOW + "%43s"
				+ AnsiUtility.ANSI_RESET + "\n\n\n", mastermindLogo, mastermindCaptionStart);
	}


	/**
	 * Si effettua una sorta di pulizia della console di interazione con l'utente
	 * fisico.
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
