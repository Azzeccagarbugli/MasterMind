package it.unicam.cs.pa.mastermind.gamecore;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe astratta impiegata per la definizione di oggetti
 * <code>Observable</code> all'interno del pattern <b>Observer</b>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class Observable {

	/**
	 * Una lista di <code>Observer</code> in cui verranno immagazinati gli observer
	 * dell'istanza attiva secondo il pattern <b>Observer</b>.
	 */
	private List<Observer> observers;

	public void setupObservers() {
		this.observers = new ArrayList<Observer>();
	}

	/**
	 * Metodo il quale registra un nuovo <code>BoardObserver</code> e notifica tutti
	 * i <code>Observer</code> attualmente associati all'istanza di
	 * <code>Observable</code>.
	 * 
	 * @param obs nuova istanza di <code>Observer</code> da aggiungere
	 */
	public void addObserver(Observer obs) {
		if(observers == null) {
			this.setupObservers();
		}
		observers.add(obs);
	}

	/**
	 * Metodo di rimozione di un <code>Observer</code> da <code>observers</code>.
	 * 
	 * @param obs oggetto <code>Observer</code> da rimuovere
	 */
	public void removeObserver(Observer obs) {
		observers.remove(obs);
	}

	/**
	 * Metodo che notifica ogni observer iscritto al registro <code>observers</code>
	 * del cambio di stato dell'istanza di <code>Observable</code> su cui è
	 * chiamato.
	 */
	public void notifyObservers() {
		for (Observer obs : this.observers) {
			obs.update(this);
		}
	}
}
