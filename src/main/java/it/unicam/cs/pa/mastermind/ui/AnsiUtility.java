package it.unicam.cs.pa.mastermind.ui;

/**
 * La seguente classe ha il solo scopo di rendere la console di gioco più
 * accattivante e user-friendly andando ad aggiungere una nota di colore ai vari
 * ColorPegs che verranno inseriti.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class AnsiUtility {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_WHITE_BOLD = "\033[1;37m";
	public static final String ANSI_RED_BOLD = "\033[1;91m";
	public static final String ANSI_CYAN_BOLD = "\033[1;96m";
	public static final String ANSI_BLACK_BACKGROUND = "\033[40m";
	public static final String ANSI_RED_BACKGROUND = "\033[0;101m";
	public static final String ANSI_GREEN_BACKGROUND = "\033[0;102m";
	public static final String ANSI_YELLOW_BACKGROUND = "\033[0;103m";
	public static final String ANSI_BLUE_BACKGROUND = "\033[0;104m";
	public static final String ANSI_PURPLE_BACKGROUND = "\033[0;105m";
	public static final String ANSI_WHITE_BACKGROUND = "\033[0;107m";
	public static final String ANSI_CYAN_BACKGROUND = "\033[0;106m";
	public static final String ANSI_YELLOW = "\033[0;93m";
}
