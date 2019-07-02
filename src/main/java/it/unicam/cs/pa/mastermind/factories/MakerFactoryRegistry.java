package it.unicam.cs.pa.mastermind.factories;

/**
 * Estensione di <code>PlayerFactoryRegistry</code> per poter contenere
 * informazioni circa le implementazioni di <code>MakerFactory</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class MakerFactoryRegistry extends PlayerFactoryRegistry {

	/**
	 * @param path associato al file da cui recuperare le informazioni sulle classi
	 *             da caricare dinamicamente
	 * @throws BadRegistryException in caso le istanze caricate non siano
	 *                              appartenenti a classi implementazione di
	 *                              <code>MakerFactory</code>
	 */
	public MakerFactoryRegistry(String path) throws BadRegistryException {
		super(path);
		if (!this.getPlayerFactoriesInstances().stream().allMatch(inst -> inst instanceof MakerFactory)) {
			throw new BadRegistryException(
					"You tried to initiate a MakerFactoryRegistry with PlayerFactory instances that do not extend MakerFactory.\nPlease modify the source file.");
		}
		;
	}

}
