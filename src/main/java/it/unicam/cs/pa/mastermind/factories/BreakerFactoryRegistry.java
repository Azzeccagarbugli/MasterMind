package it.unicam.cs.pa.mastermind.factories;

/**
 * Estensione di <code>PlayerFactoryRegistry</code> per poter contenere
 * informazioni circa le implementazioni di <code>BreakerFactory</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BreakerFactoryRegistry extends PlayerFactoryRegistry {

	/**
	 * @param path associato al file da cui recuperare le informazioni sulle classi
	 *             da caricare dinamicamente
	 * @throws BadRegistryException in caso le istanze caricate non siano
	 *                              appartenenti a classi implementazione di
	 *                              <code>BreakerFactory</code>
	 */
	public BreakerFactoryRegistry(String path) throws BadRegistryException {
		super(path);
		if (!this.getPlayerFactoriesInstances().stream().allMatch(inst -> inst instanceof BreakerFactory)) {
			throw new BadRegistryException(
					"You tried to initiate a MakerFactoryRegistry with PlayerFactory instances that do not extend MakerFactory.\nPlease modify the source file.");
		}
		;
	}

}
