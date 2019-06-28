package it.unicam.cs.pa.mastermind.ui;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * Implementazione con interazione via console della classe
 * <code>InteractionView</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class ConsoleGameView extends GameView {

	private FilterInputStream fis;

	// TODO JavaDoc
	public ConsoleGameView() {
		fis = new FilterInputStream(System.in) {
			@Override
			public void close() throws IOException {
			}
		};
	}

	@Override
	public List<Integer> getIndexSequence(boolean isBreaker) {
		List<Integer> indexPegs = new ArrayList<Integer>();
		String isBreakerMsg = isBreaker ? "Defining a new attempt" : "Defining the sequence to guess";
		String isBreakerAttempts = "Define the color of each of the pegs knowing that";

		showMenuColor(isBreakerMsg, isBreakerAttempts, isBreaker);
		for (int i = 1; i <= getSubject().getSequenceLength(); i++) {
			this.addIndexOfSinglePeg(indexPegs, i, isBreaker);
			if (indexPegs.contains(0)) {
				break;
			}
		}
		clearScreen();
		return indexPegs;
	}

	/**
	 * Metodo necessario alla creazione del disegno tabulare che contiene le
	 * informazioni di gioco.
	 * 
	 * @param size         la launghezza dell'array che viene inserito come
	 *                     parametro locale
	 * @param attemptLabel il nome dell'etichetta che si vuole dare al titolo dei
	 *                     tentativi inseriti
	 * @param clueLabel    il nome dell'etichetta che si vuole dare al titolo degli
	 *                     indizi generati
	 */
	private void showGameBasingOnLenght(int size, String attemptLabel, String clueLabel) {
		if (size < 5) {
			System.out.format(String.format("\n┏%69s┓\n", " ").replace(' ', '━'));
			System.out.format("%s %53s %26s \n", "┃", AnsiUtility.ANSI_CYAN_BOLD + getSubject().leftAttempts()
					+ " attempts left" + AnsiUtility.ANSI_RESET, "┃");
			System.out.format(String.format("┣%34s┳%34s┫\n", " ", " ").replace(' ', '━'));	
			System.out.format("┃%31s %14s %30s %14s\n", attemptLabel, "┃", clueLabel, "┃");
			System.out.format(String.format("┣%34s╋%34s┫\n", " ", " ").replace(' ', '━'));
		} else {
			System.out
					.format(String.format("\nYour current combination is: [Attempt on left and clue on the right]\n"));
		}
	}

	/**
	 * Metodo necessario alla stampa della scelta dei colori da parte di un
	 * giocatore qualsiasi.
	 * 
	 * @param labelMsg1 il primo messaggio da visualizzare.
	 * @param labelMsg2 il secondo messaggio da visualizzare.
	 * @param isBreaker flag che indica se il giocatore è un
	 *                  <code>CodeBreaker</code>.
	 */
	private void showMenuColor(String labelMsg1, String labelMsg2, boolean isBreaker) {
		System.out.format(String.format("\n┏%51s┓\n", " ").replace(' ', '━'));
		System.out.format("%s %51s %10s \n", "┃", AnsiUtility.ANSI_CYAN_BOLD + labelMsg1 + AnsiUtility.ANSI_RESET, "┃");
		System.out.format(String.format("┣%51s┫\n", " ").replace(' ', '━'));
		System.out.format("%s %s %s \n", "┃", AnsiUtility.ANSI_CYAN_BOLD + labelMsg2 + AnsiUtility.ANSI_RESET, "┃");
		giveUpMessageForBreakers(isBreaker);
		System.out.format(String.format("┣%16s┳%16s┳%17s┫\n", " ", " ", " ", " ").replace(" ", "━"));
		IntStream.range(0, ColorPegs.values().length).mapToObj(index -> selectionColor(index))
				.forEach(System.out::print);
		System.out.format(String.format("\n┗%16s┻%16s┻%17s┛\n\n", " ", " ", " ", " ").replace(' ', '━'));
	}

	/**
	 * Mostra la possibilità di resa al giocatore <code>CodeBreaker</code> durante
	 * la selezione dei colori.
	 * 
	 * @param isBreaker flag che indica se il giocatore è un
	 *                  <code>CodeBreaker</code>.
	 */
	private void giveUpMessageForBreakers(boolean isBreaker) {
		if (isBreaker) {
			String giveUpFormat = "Insert the number 0 to give up";
			System.out.format(String.format("┣%51s┫\n", " ").replace(' ', '━'));
			System.out.format("%s %52s %9s \n", "┃", AnsiUtility.ANSI_RED_BOLD + giveUpFormat + AnsiUtility.ANSI_RESET,
					"┃");
		}
	}

	/**
	 * Metodo necessario alla corretta formattazione tabluare della modalità di
	 * inserimento dei colori.
	 * 
	 * @param index l'indice restituito dallo stream
	 * @return String formattata secondo dei canoni tabulari
	 */
	private String selectionColor(int index) {

		String tabulationColor = "┃";

		if (index == 0) {
			tabulationColor += String.format("  [%s - %d] ┃", beautifyGeneral(ColorPegs.values()[index]), index + 1);
		} else if (index == 2) {
			tabulationColor = String.format("  [%s - %d] %2s", beautifyGeneral(ColorPegs.values()[index]), index + 1,
					"┃");
			tabulationColor += "\n┃";
			tabulationColor += String.format("%17s%17s%18s", "┃", "┃", "┃");
			tabulationColor += "\n┃";
		} else if (index == 5) {
			tabulationColor = String.format("  [%s - %d] %2s", beautifyGeneral(ColorPegs.values()[index]), index + 1,
					"┃");
		} else {
			tabulationColor = " ";
			tabulationColor += String.format(" [%s - %d] ┃", beautifyGeneral(ColorPegs.values()[index]), index + 1);
		}

		return tabulationColor;
	}

	/**
	 * Dato un colore sottoforma di <code>ColorPegs</code> viene restituito il suo
	 * corrispetivo secondo i canoni della decodifica ANSI.
	 * 
	 * @param color <code>ColorPegs</code> che si vuole codificare in una stringa
	 *              colorata
	 * @return String contenente i valori della stringa visualizzati in modalità
	 *         colorata
	 */
	private String beautifyGeneral(ColorPegs color) {
		String colorfulPeg = new String();
		switch (color) {
		case RED:
			colorfulPeg += AnsiUtility.ANSI_RED_BACKGROUND + "      " + AnsiUtility.ANSI_RESET + " ";
			break;
		case YELLOW:
			colorfulPeg += AnsiUtility.ANSI_YELLOW_BACKGROUND + "      " + AnsiUtility.ANSI_RESET + " ";
			break;
		case BLUE:
			colorfulPeg += AnsiUtility.ANSI_BLUE_BACKGROUND + "      " + AnsiUtility.ANSI_RESET + " ";
			break;
		case GREEN:
			colorfulPeg += AnsiUtility.ANSI_GREEN_BACKGROUND + "      " + AnsiUtility.ANSI_RESET + " ";
			break;
		case WHITE:
			colorfulPeg += AnsiUtility.ANSI_WHITE_BACKGROUND + "      " + AnsiUtility.ANSI_RESET + " ";
			break;
		case BLACK:
			colorfulPeg += AnsiUtility.ANSI_BLACK_BACKGROUND + "      " + AnsiUtility.ANSI_RESET + " ";
			break;
		default:
			break;
		}
		return colorfulPeg;
	}

	@Override
	public void endingScreen(String gameEndingMessage) {
		System.out.println(gameEndingMessage);
		System.out.println("\nThe correct sequence was: " + beautifyClues(getSubject().getSequenceToGuess(), false));
	}

	/**
	 * Interazione con l'utente fisico per poter ottenere gli indici relativi ai
	 * valori di <code>ColorPegs</code> contenuti in una sequenza. Il metodo
	 * potrebbe aggiungere alla lista il valore <code>Integer</code> 0,
	 * rappresentante la volontà di un giocatore <code>CodeBreaker</code> di
	 * arrendersi.
	 * 
	 * @param list      in cui inserire gli indici
	 * @param index     rappresentante la posizione del <code>ColorPegs</code>
	 *                  all'interno di una sequenza
	 * @param isBreaker flag che indica se il giocatore è un
	 *                  <code>CodeBreaker</code>
	 * @throws IOException
	 */
	private void addIndexOfSinglePeg(List<Integer> list, int index, boolean isBreaker) {
		int temp = 0;
		try (BufferedReader in = new BufferedReader(new InputStreamReader(fis))) {
			for (;;) {
				System.out.print("Insert value nr." + index + " > ");
				try {
					temp = Integer.parseInt(in.readLine());
					if (isBreaker && temp == 0) {
						System.out.println("You decided to give up");
						break;
					} else if (temp < 0 || temp > ColorPegs.values().length) {
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
		list.add(temp);
	}

	/**
	 * Metodo privato che formatta in maniera corretta la visualizzazione della
	 * tabella in base alla lunghezza della sequenza delle pedine indizio.
	 * 
	 * @param size la dimensione dell'array passato come paramentro locale
	 * @return int distanza dall'ultimo carattere in maniera dinamica per permettere
	 *         una migliore visualizzazione
	 */
	private int dynamicTableLenght(int size) {
		switch (size) {
		case 0:
			return 30;
		case 1:
			return 23;
		case 2:
			return 16;
		case 3:
			return 9;
		case 4:
			return 2;
		default:
			return 4;
		}
	}

	/**
	 * Metodo privato che aggiunge una nota colorata per ogni sequenza di pedine
	 * indizio visualizzata all'interno della tabella ASCII generata dal metodo
	 * <code>showGame</code>.
	 * 
	 * @param cluesList la lista di pedine indizio
	 * @param flag      imposta la stampa anche della tabella
	 * @return String contenente la corrispettiva sequenza colorata
	 */
	private String beautifyClues(List<ColorPegs> cluesList, boolean flag) {
		String clueCombination = "[ ";
		for (ColorPegs clue : cluesList) {
			clueCombination += beautifyGeneral(clue);
		}

		if (!flag) {
			clueCombination += String.format("]");
		} else {
			clueCombination += String.format("] %" + dynamicTableLenght(cluesList.size()) + "s \n", "┃");
			clueCombination += String.format("%s %34s %34s \n", "┃", "┃", "┃");
			clueCombination += String.format("┣%34s╋%34s┫\n", " ", " ").replace(' ', '━');
		}

		return clueCombination;
	}

	/**
	 * 
	 * Metodo privato che aggiunge una nota colorata per ogni sequenza di pedine
	 * tentativo inserite all'interno della tabella ASCII generata dal metodo
	 * <code>showGame</code>.
	 * 
	 * @param attemptsList la lista di pedine tentativo inserite
	 * @param flag         imposta la stampa anche della tabella
	 * @return String contenente la corriespetiva sequenza colorata
	 */
	private String beautifyAttempts(List<ColorPegs> attemptsList, boolean flag) {
		String attemptCombination;
		if (!flag) {
			attemptCombination = "[ ";
			for (ColorPegs attempt : attemptsList) {
				attemptCombination += beautifyGeneral(attempt);
			}
			attemptCombination += String.format(AnsiUtility.ANSI_RESET + "]");
		} else {
			System.out.format("%s %34s %34s\n", "┃", "┃", "┃");
			attemptCombination = "[ ";
			for (ColorPegs attempt : attemptsList) {
				attemptCombination += beautifyGeneral(attempt);
			}
			attemptCombination += String.format("] %" + dynamicTableLenght(attemptsList.size()) + "s", "┃");
		}
		return attemptCombination;
	}

	/**
	 * Si effettua una sorta di pulizia della console di interazione con l'utente
	 * fisico.
	 */
	private void clearScreen() {
		System.out.println(new String(new char[100]).replace("\0", "\r\n"));
	}

	@Override
	public void update() {
		if (!getSubject().isBoardEmpty()) {
			this.showGame();
		}
	}

	@Override
	public void showGame() {
		List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues = getSubject().getAttemptAndClueList();
		if (!attemptsAndClues.isEmpty()) {
			int dynamicTable = attemptsAndClues.get(0).getKey().size();
			showGameBasingOnLenght(dynamicTable, AnsiUtility.ANSI_WHITE_BOLD + "Attempt" + AnsiUtility.ANSI_RESET,
					AnsiUtility.ANSI_WHITE_BOLD + "Clue" + AnsiUtility.ANSI_RESET);
			if (dynamicTable < 5) {
				attemptsAndClues.stream().forEach(entry -> System.out.format("┃ %-34s %-80s",
						beautifyAttempts(entry.getKey(), true), beautifyClues(entry.getValue(), true)));
			} else {
				attemptsAndClues.stream().forEach(entry -> System.out.format("\n%-34s ┃ %-80s\n",
						beautifyAttempts(entry.getKey(), false), beautifyClues(entry.getValue(), false)));
			}
		}
	}

}