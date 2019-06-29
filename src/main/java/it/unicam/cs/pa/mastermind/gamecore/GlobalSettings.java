package it.unicam.cs.pa.mastermind.gamecore;

import java.io.File;

import it.unicam.cs.pa.mastermind.factories.BadRegistryException;
import it.unicam.cs.pa.mastermind.factories.BreakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.factories.MakerFactoryRegistry;

/**
 * <b>Responsabilità</b>: tenere traccia delle impostazioni globali del gioco,
 * comuni a tutte le partite. <b>Contratto</b>: le istanze vengono gestite
 * all'interno di <code>MainManager</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class GlobalSettings {

	/**
	 * Path della folder in cui inserire i file per la generazione corretta dei
	 * <code>PlayerFactoryRegistry</code>
	 */
	private final String parentFolder = "./GameResources";

	/**
	 * Path della folder in cui inserire i file per la generazione corretta dei
	 * <code>MakerFactoryRegistry</code>
	 */
	private final String makersPath = "GameResources//MakerFactories.txt";

	/**
	 * Path della folder in cui inserire i file per la generazione corretta dei
	 * <code>BreakerFactoryRegistry</code>
	 */
	private final String breakersPath = "GameResources//BreakerFactories.txt";

	/**
	 * Registro contenente le implementazioni di <code>MakerFactory</code>.
	 */
	private final MakerFactoryRegistry makers;

	/**
	 * Registro contenente le implementazioni di <code>BreakerFactory</code>.
	 */
	private final BreakerFactoryRegistry breakers;

	public MakerFactoryRegistry getMakers() {
		return makers;
	}

	public BreakerFactoryRegistry getBreakers() {
		return breakers;
	}

	/**
	 * Inizializzazione con generazione dei registri
	 * 
	 * @throws BadRegistryException in caso di errori con la generazione dei
	 *                              <code>PlayerFactoryRegistry</code>.
	 */
	public GlobalSettings() throws BadRegistryException {
		this.setupParentFolder();
		makers = new MakerFactoryRegistry(makersPath);
		breakers = new BreakerFactoryRegistry(breakersPath);
	}

	private void setupParentFolder() {
		File dir = new File(parentFolder);
		if (!dir.exists()) {
			dir.mkdir();
		}
	}
}
