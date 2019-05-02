/**
 * 
 */
package it.unicam.cs.pa.mastermind.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.unicam.cs.pa.mastermind.core.SingleGame;
import it.unicam.cs.pa.mastermind.players.*;

/**
 * Interazione iniziale con l'utente via linea di comando
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class CommandLineStartManager implements StartManager {

	GameMode mode;
	int attempts;
	int sequenceLength;
	boolean toContinue = true;
	boolean keepSettings = false;
	SingleGame game;
	CodeMaker maker;
	CodeBreaker breaker;

	@Override
	public void start() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int intInput = 0;
			while (toContinue) {
				System.out.println("Welcome to MasterMind!");
				if (!keepSettings) {
					while (!((intInput >= 1) && (intInput <= 3))) {
						System.out.print("Select the game mode: " + "\n" + "G1BreakerVSG2Maker [1]" + "\n"
								+ "G1BreakerVSBOTMaker [2]" + "\n" + "BOTBreakerVSBOTMaker [3]" + "\n" + "> ");
						intInput = reader.read();
					}
					mode = (GameMode.values())[intInput - 1];

					switch(mode){
						case PLAYERVSPLAYER:
							maker = new HumanMaker();
							breaker = new HumanBreaker();
							break;
						case PLAYERVSBOT:
							maker = new BotMaker();
							breaker = new HumanBreaker();
							break;		
						case BOTVSBOT:
							maker = new BotMaker();
							breaker = new BotBreaker();
							break;
					}

					String strInput = "";
					while (!((strInput.equals("Y")) ^ (strInput.equals("N")))) {
						System.out.print("\033[H\033[2J");
						System.out.print(
								"Would you like to start a new match using the default settings (9 attempts and 4 pegs long sequences)? [Y/N]"
										+ "\n" + "> ");
						strInput = reader.readLine();
					}
					if (strInput.equals("N")) {
						attempts = 9;
						sequenceLength = 4;
					} else {
						System.out.print("\033[H\033[2J");
						System.out.print("Insert the number of attempts: " + "\n" + "> ");
						attempts = (reader.read());
						System.out.print("Insert the length of pegs sequences: " + "\n" + "> ");
						sequenceLength = (reader.read());
					}
					reader.close();
				}
				
				System.out.print("Now starting the game");
				game = new SingleGame(this.maker, this.breaker, this.sequenceLength, this.attempts, new CommandLineInteractionManager());
				boolean[] newSettings = game.start();
				this.toContinue = newSettings[0];
				this.keepSettings = newSettings[1];
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}
	public static void main(String[] args) {
		CommandLineStartManager startManager = new CommandLineStartManager();
		startManager.start();
	}

}
