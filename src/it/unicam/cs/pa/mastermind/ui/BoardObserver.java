package it.unicam.cs.pa.mastermind.ui;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;

/**
 * Il pattern Observer permette di definire una dipendenza uno a molti fra
 * oggetti, in modo tale che se un oggetto cambia il suo stato interno, ciascuno
 * degli oggetti dipendenti da esso viene notificato e aggiornato
 * automaticamente. L’Observer nasce dall’esigenza di mantenere un alto livello
 * di consistenza fra classi correlate, senza produrre situazioni di forte
 * dipendenza e di accoppiamento elevato.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class BoardObserver {

	/**
	 * L'oggetto che viene osservato.
	 */
	protected BoardModel subject;

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

}
