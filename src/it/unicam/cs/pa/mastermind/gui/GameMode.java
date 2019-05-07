package it.unicam.cs.pa.mastermind.gui;

/**
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public enum GameMode {
	HUMANBREAKERVSHUMANMAKER("Human Breaker VS Human Maker"), HUMANBREAKERVSBOTMAKER("Human Breaker VS Bot Maker"),
	BOTBREAKERVSHUMANMAKER("Bot Breaker VS Human Maker"), BOTBREAKERVSBOTMAKER("Bot Breaker VS Bot Maker");
	
	private String description;
	private GameMode(String desc) {
		this.description = desc;
	}
	
	public String getDescription() {
		return this.description;
	}
}
