package it.unicam.cs.pa.mastermind.players;

/**
 * Eccezione personalizzata impiegata in tutti quei casi in cui ci sia stato un
 * problema nell'inizializzazione di istanze di
 * <code>PlayerFactoryRegistry</code>
 * 
 * @author Francesco
 *
 */
public class BadRegistryException extends Exception {

	private static final long serialVersionUID = 1L;

	public BadRegistryException(String message) {
		super(message);
	}
}
