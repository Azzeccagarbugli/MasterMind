package it.unicam.cs.pa.mastermind.ui;

/**
 * L'enum descrive attraverso dei label le modalità di gioco disponibili
 * all'interno della piattaforma.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public enum GameMode {
	HUMANBREAKERVSHUMANMAKER("Human Breaker VS Human Maker"), HUMANBREAKERVSBOTMAKER("Human Breaker VS Bot Maker"),
	BOTBREAKERVSHUMANMAKER("Bot Breaker VS Human Maker"), BOTBREAKERVSBOTMAKER("Bot Breaker VS Bot Maker");

	/*
	 * Stringa la quale verrà inizializzata con la descrizione della modalità di
	 * gioco selezionata.
	 */
	private String description;

	/**
	 * Setter per la selezione della descrizione.
	 *
	 * @param desc la descrizione della modalità di gioco
	 */
	private GameMode(String desc) {
		this.description = desc;
	}

	/*
	 * Getter per la descrizione della modalità di gioco.
	 */
	public String getDescription() {
		return this.description;
	}
}
