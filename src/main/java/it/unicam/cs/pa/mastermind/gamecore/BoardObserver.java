package it.unicam.cs.pa.mastermind.gamecore;

/**
 * Classe astratta estendibile da tutte quelle classi coinvolte nel design
 * pattern <b>Observer</b>, aventi quindi necessità di osservare e adattarsi in
 * tempo reale ai cambiamenti di stato di oggetti di tipo BoardModel.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class BoardObserver {

	/**
	 * L'oggetto che viene osservato.
	 */
	private BoardModel subject;

	/**
	 * Aggiornamento dello stato interno dell'oggetto.
	 */
	public abstract void update();

	/**
	 * Metodo per il quale viene aggiunto un altro elemento da osservare alla lista
	 * interna.
	 * 
	 * @param subject il soggetto che si vuole osservare
	 */
	public void addSubject(BoardModel subject) {
		this.subject = subject;
		subject.addObserver(this);
	}
	
	/**
	 * Restituito il riferimento alla <code>BoardModel</code> osservata
	 * @return BoardModel il riferimento richiesto
	 */
	protected BoardModel getSubject() {
		return subject;
	}

}
