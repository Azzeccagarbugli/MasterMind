package it.unicam.cs.pa.mastermind.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.gamecore.NewGameStats;
import it.unicam.cs.pa.mastermind.players.PlayerFactoryRegistry;

public class ConsoleStartView extends StartView {

	private BufferedReader reader;

	private String mastermindLogo = "\r\n" + "                  _                      _           _ \r\n"
			+ "  /\\/\\   __ _ ___| |_ ___ _ __ _ __ ___ (_)_ __   __| |\r\n"
			+ " /    \\ / _` / __| __/ _ \\ '__| '_ ` _ \\| | '_ \\ / _` |\r\n"
			+ "/ /\\/\\ \\ (_| \\__ \\ ||  __/ |  | | | | | | | | | | (_| |\r\n"
			+ "\\/    \\/\\__,_|___/\\__\\___|_|  |_| |_| |_|_|_| |_|\\__,_|\r\n"
			+ "                                                       \r\n" + "";
	private String mastermindCaptionStart = "Welcome player, play and have fun!";
	private String mastermindCaptionEnd = "Thank you for taking part in this game, see you!";

	private final static ConsoleStartView instance = new ConsoleStartView();
	
	private ConsoleStartView() {
		super();
		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
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
		System.out.format(AnsiUtility.ANSI_CYAN_BOLD + "%-1s " + AnsiUtility.ANSI_YELLOW + "%50s" + AnsiUtility.ANSI_RESET, mastermindLogo,
				mastermindCaptionEnd);
		System.exit(0);
	}

	@Override
	protected NewGameStats askNewGameSettings() {
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
		do {
			try {
				System.out.print("Insert the length of pegs sequences: [between " + startStats.getLowTresholdLength()
						+ " and " + startStats.getHighTresholdLength() + ", inclusive]" + "\n" + "> ");
				length = Integer.parseInt(reader.readLine());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Please insert a numeric value between " + startStats.getLowTresholdLength()
						+ " and " + startStats.getHighTresholdLength() + ", inclusive");
			}
		} while (length < startStats.getLowTresholdLength() || length > startStats.getHighTresholdLength());
		return length;
	}

	@Override
	protected int askNewAttempts() {
		int attempts = 0;
		do {
			try {
				System.out.print("Insert the number of attempts: [equal or greater than "
						+ startStats.getLowTresholdAttempts() + "]" + "\n" + "> ");
				attempts = Integer.parseInt(reader.readLine());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Please insert a numeric value greater than " + startStats.getLowTresholdAttempts());
			}
		} while (attempts < startStats.getLowTresholdAttempts());
		return attempts;
	}

	@Override
	protected String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker) {
		System.out.println("Select the " + (isBreaker ? "breaker" : "maker") + " from this list");
		List<String> names = registry.getPlayersNames();
		IntStream.range(0, names.size())
				.forEach(index -> System.out.println(index + 1 + " - " + names.get(index).toUpperCase()));
		int intInput = 0;
		do {
			try {
				System.out.print("> ");
				intInput = Integer.parseInt(reader.readLine());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Please insert a numeric value");
			}
		} while (intInput < 1 || intInput > names.size());
		System.out.println("You chose a " + names.get(intInput - 1) + " " + (isBreaker ? "breaker" : "maker"));
		return names.get(intInput - 1);
	}

	@Override
	protected boolean askNewSettings() {
		String strInput = "";
		try {
			while (!(strInput.toLowerCase().equals("y") ^ strInput.toLowerCase().equals("n"))) {
				System.out.print(
						"\nWould you like to start a new match using the default settings (9 attempts and 4 pegs long sequences)? [Y/N]"
								+ "\n" + "> ");
				strInput = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return strInput.toLowerCase().equals("n") ? true : false;
	}

	@Override
	protected void showLogo() {
		System.out.format(AnsiUtility.ANSI_CYAN_BOLD + "%-1s " + AnsiUtility.ANSI_YELLOW + "%43s" + AnsiUtility.ANSI_RESET + "\n\n\n", mastermindLogo,
				mastermindCaptionStart);
	}

	@Override
	protected InteractionView getInteractionView() {
		ConsoleInteractionView temp = ConsoleInteractionView.getInstance();
		temp.init(reader);
		return temp;
	}

	private void clearScreen() {
		System.out.println(new String(new char[100]).replace("\0", "\r\n"));
	}

	public static void main(String[] args) {
		StartView startView = ConsoleStartView.getInstance();
		startView.startUp();
	}
}
