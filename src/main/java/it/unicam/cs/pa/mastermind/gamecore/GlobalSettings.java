package it.unicam.cs.pa.mastermind.gamecore;

import java.io.File;

import it.unicam.cs.pa.mastermind.factories.BadRegistryException;
import it.unicam.cs.pa.mastermind.factories.BreakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.factories.MakerFactoryRegistry;

/**
 * <b>Responsabilità</b>: tenere traccia delle impostazioni globali del gioco,
 * comuni a tutte le partite.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class GlobalSettings {

	private final String parentFolder = "./GameResources";
	private final String makersPath = "GameResources//MakerFactories.txt";
	private final String breakersPath = "GameResources//BreakerFactories.txt";

	private final MakerFactoryRegistry makers;
	private final BreakerFactoryRegistry breakers;

	public MakerFactoryRegistry getMakers() {
		return makers;
	}

	public BreakerFactoryRegistry getBreakers() {
		return breakers;
	}

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
