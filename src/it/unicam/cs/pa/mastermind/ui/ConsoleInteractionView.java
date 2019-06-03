package it.unicam.cs.pa.mastermind.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * Interazione con l'utente durante il gioco via linea di comando
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class ConsoleInteractionView extends InteractionView {

	/**
	 * Inizializzazione di un nuovo BufferReader.
	 */
	private BufferedReader reader;

	/**
	 * Riferimento all'instanza Singleton.
	 */
	private static final ConsoleInteractionView instance = new ConsoleInteractionView();

	/**
	 * Costruisco l'elemento <code>ConsoleInteractionView</code>, il quale
	 * permette l'interazione tra il gioco e i vari player disponibili.
	 * 
	 * @param newReader il BufferReader necessario alla generazione della classe
	 */
	private ConsoleInteractionView() {
		// Applicazione del pattern relativo al Singleton.
	}

	/**
	 * Il metodo getInstance garantisce la singolarità della classe all'interno del
	 * parco software.
	 * 
	 * @return l'instanza della classe se presente o meno
	 */
	public static ConsoleInteractionView getInstance() {
		return instance;
	}

	/**
	 * Inietto all'interno della classe il parametro desiderato che ha nataura
	 * <code>BufferReader</code>.
	 * 
	 * @param newReader il BufferReader necessario all'instanza della classe
	 */
	public void init(BufferedReader newReader) {
		this.reader = newReader;
	}

	@Override
	public List<Integer> getIndexSequence(boolean isBreaker) {
		List<Integer> indexPegs = new ArrayList<Integer>();
		String isBreakerMsg = isBreaker ? "Defining a new attempt" : "Defining the sequence to guess";
		String isBreakerAttempts = "Please define the color of each of the pegs knowing that";
		try {
			showMenuColor(isBreakerMsg, isBreakerAttempts, isBreaker);
			for (int i = 1; i <= this.getCurrentSequenceLength(); i++) {
				this.askIndexOfSinglePeg(indexPegs, i, isBreaker);
				if (indexPegs.contains(0)) {
					break;
				}
			}
			clearScreen();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
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
			System.out.format("%s %57s %22s \n", "┃",
					AnsiUtility.ANSI_CYAN_BOLD + "Your current combination" + AnsiUtility.ANSI_RESET, "┃");
			System.out.format(String.format("┣%34s┳%34s┫\n", " ", " ").replace(' ', '━'));
			System.out.format("┃%31s %14s %30s %14s\n", attemptLabel, "┃", clueLabel, "┃");
			System.out.format(String.format("┣%34s╋%34s┫\n", " ", " ").replace(' ', '━'));
		} else {
			System.out
					.format(String.format("\nYour current combination is: [Attempt on left and clue on the right]\n"));
		}
	}

	/**
	 * Metodo necessario alla stampa della scelta dei colori da parte di un player
	 * qualsiasi.
	 * 
	 * @param labelMsg1 il primo messaggio da visualizzare
	 * @param labelMsg2 il secondo messaggio da visualizzare
	 */
	public void showMenuColor(String labelMsg1, String labelMsg2, boolean isBreaker) {
		System.out.format(String.format("\n┏%69s┓\n", " ").replace(' ', '━'));
		System.out.format("%s %58s %21s \n", "┃", AnsiUtility.ANSI_CYAN_BOLD + labelMsg1 + AnsiUtility.ANSI_RESET, "┃");
		System.out.format(String.format("┣%69s┫\n", " ").replace(' ', '━'));
		System.out.format("%s %74s %5s \n", "┃", AnsiUtility.ANSI_CYAN_BOLD + labelMsg2 + AnsiUtility.ANSI_RESET, "┃");
		isBreakerMessageGiveUp(isBreaker);
		System.out.format(String.format("┣%16s┳%16s┳%16s┳%18s┫\n", " ", " ", " ", " ").replace(" ", "━"));
		IntStream.range(0, ColorPegs.values().length).mapToObj(index -> selectionColor(index))
				.forEach(System.out::print);
		System.out.format(String.format("\n┗%16s┻%16s┻%16s┻%18s┛\n\n", " ", " ", " ", " ").replace(' ', '━'));
	}

	/**
	 * Mostra la possibilità di resa al player durante la selezione dei colori.
	 * 
	 * @param isBreaker booleano che conferma se il player è un breaker
	 */
	public void isBreakerMessageGiveUp(boolean isBreaker) {
		if (isBreaker) {
			String giveUpFormat = "Insert the number 0 to give up";
			System.out.format(String.format("┣%69s┫\n", " ").replace(' ', '━'));
			System.out.format("%s %61s %18s \n", "┃", AnsiUtility.ANSI_RED_BOLD + giveUpFormat + AnsiUtility.ANSI_RESET,
					"┃");
		}
	}

	/**
	 * Metodo necessario alla corretta formattazione tabluare della modalità di
	 * inserimento dei colori.
	 * 
	 * @param index l'indice restituito dallo stream
	 * @return la stringa formattata secondo dei canoni tabulari
	 */
	public String selectionColor(int index) {

		String tabulationColor = "┃";

		if (index == 0) {
			tabulationColor += String.format("  [%s - %d] ┃", beautifyGeneral(ColorPegs.values()[index]), index + 1);
		} else if (index == 3) {
			tabulationColor = String.format("  [%s - %d] %3s", beautifyGeneral(ColorPegs.values()[index]), index + 1,
					"┃");
			tabulationColor += "\n┃";
			tabulationColor += String.format("%17s%17s%17s%19s", "┃", "┃", "┃", "┃");
			tabulationColor += "\n┃";
		} else if (index == 7) {
			tabulationColor = String.format("  [%s - %d] %3s", beautifyGeneral(ColorPegs.values()[index]), index + 1,
					"┃");
		} else {
			tabulationColor = " ";
			tabulationColor += String.format(" [%s - %d] ┃", beautifyGeneral(ColorPegs.values()[index]), index + 1);
		}

		return tabulationColor;
	}

	/**
	 * Dato un colore sottoforma di ColorPegs viene restituito il suo corrispetivo
	 * secondo i canoni della decodifica ANSI.
	 * 
	 * @param color il colore che si vuole codificare in una stringa colorata
	 * @return la stringa contenente i valori della stringa visualizzati in modalità
	 *         colorata
	 */
	public String beautifyGeneral(ColorPegs color) {
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
		case PURPLE:
			colorfulPeg += AnsiUtility.ANSI_PURPLE_BACKGROUND + "      " + AnsiUtility.ANSI_RESET + " ";
			break;
		case CYAN:
			colorfulPeg += AnsiUtility.ANSI_CYAN_BACKGROUND + "      " + AnsiUtility.ANSI_RESET + " ";
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
	public void endingScreen(String gameEndingMessage, List<ColorPegs> toGuess) {
		System.out.println(gameEndingMessage);
		System.out.println("\nThe correct sequence was: " + beautifyClues(toGuess, false));
	}

	private void askIndexOfSinglePeg(List<Integer> list, int index, boolean isBreaker) throws IOException {
		int temp = 0;
		do {
			System.out.print("Insert value nr." + index + " > ");
			try {
				temp = Integer.parseInt(this.reader.readLine());
				if (isBreaker && temp == 0) {
					System.out.println("You decided to give up");
				}
				;
			} catch (NumberFormatException e) {
				System.out.println("Please insert a numeric value");
			}
		} while (temp < 0 || temp > ColorPegs.values().length);
		list.add(temp);
	}

	/**
	 * Metodo privato che formatta in maniera corretta la visualizzazione della
	 * tabella in base alla lunghezza della sequenza delle pedine indizio.
	 * 
	 * @param size la dimensione dell'array passato come paramentro locale
	 * @return la distanza dall'ultimo carattere in maniera dinamica per permettere
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
	 * @return la stringa contenente la corriespetiva sequenza colorata
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
	 * @return la stringa contenente la corriespetiva sequenza colorata
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
	 * Viene effettuata una sorta di operazione clean per la console stampando 100
	 * linee di testo vuote.
	 */
	private void clearScreen() {
		System.out.println(new String(new char[100]).replace("\0", "\r\n"));
	}

	@Override
	public void update() {
		this.currentSequenceLength = subject.getSequenceLength();
		this.currentSequenceToGuess = subject.getSequenceToGuess();
		if (!subject.isBoardEmpty()) {
			this.lastAttemptAndClue = subject.lastAttemptAndClue();
			List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues = subject.getAttemptAndClueList();
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
}