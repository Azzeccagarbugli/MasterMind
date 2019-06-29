.. java:import:: it.unicam.cs.pa.mastermind.factories BadRegistryException

.. java:import:: it.unicam.cs.pa.mastermind.factories BreakerFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories BreakerFactoryRegistry

.. java:import:: it.unicam.cs.pa.mastermind.factories MakerFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories MakerFactoryRegistry

.. java:import:: it.unicam.cs.pa.mastermind.factories PlayerFactoryRegistry

.. java:import:: it.unicam.cs.pa.mastermind.gamecore StartupSettings

StartView
=========

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public interface StartView

   \ **Responsabilità**\ : fornire agli utenti fisici coinvolti nel gioco l'interazione per poter iniziare nuove partite.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
askNewAttempts
^^^^^^^^^^^^^^

.. java:method:: public int askNewAttempts(int lowTres)
   :outertype: StartView

   Gestione dell'interazione con l'utente fisico per ottenere un nuovo valore relativo al numero di tentativi utili all'interno del gioco.

   :param lowTres: limite inferiore al valore da scegliere
   :return: int valore scelto

askNewLength
^^^^^^^^^^^^

.. java:method:: public int askNewLength(int lowTres, int highTres)
   :outertype: StartView

   Gestione dell'interazione con l'utente fisico per ottenere un nuovo valore relativo alla lunghezza delle sequenze impiegate nel gioco.

   :param lowTres: limite inferiore al valore da scegliere
   :param highTres: limite superiore al valore da scegliere
   :return: int valore scelto

askNewLengthsAndAttempts
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean askNewLengthsAndAttempts()
   :outertype: StartView

   Gestione dell'interazione con l'utente fisico circa le decisioni per l'impostazione di nuovi valori di lunghezza delle sequenze e di numero di tentativi per un nuovo match.

   :return: boolean volontà dell'utente fisico di decidere nuove impostazioni per un nuovo match.

askNewStartupSettings
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public StartupSettings askNewStartupSettings()
   :outertype: StartView

   Gestione dell'interazione con l'utente fisico circa le decisioni per l'inizio di un nuovo match o meno dopo che uno è stato concluso.

   :return: StartupSettings contenente informazioni utili per iniziare o meno nuovi match

badEnding
^^^^^^^^^

.. java:method:: public void badEnding(String reason)
   :outertype: StartView

   Gestione anticipata della conclusione dell'intero gioco, richiamata ad esempio per il sollevamento di errori importanti.

   :param reason: da presentare all'utente fisico

ending
^^^^^^

.. java:method:: public void ending()
   :outertype: StartView

   Gestione della conclusione dell'intero gioco dopo la fine di ogni singola partita.

getPlayerName
^^^^^^^^^^^^^

.. java:method:: public String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker)
   :outertype: StartView

   Gestione dell'interazione dell'utente fisico per la scelta della particolare implementazione dei giocatori che verranno coinvolti nella nuova partita.

   :param registry: registro contenente le informazioni sulle classi \ ``PlayerFactory``\  relative alle implementazioni dei giocatori.
   :param isBreaker: flag che indica se la scelta è relativa ad una factory finalizzata alla generazione di un giocatore \ ``CodeBreaker``\  o meno.
   :return: String rappresentante l'implementazione del giocatore scelta per la nuova partita.

setupBreaker
^^^^^^^^^^^^

.. java:method:: public BreakerFactory setupBreaker(BreakerFactoryRegistry registry)
   :outertype: StartView

   Gestione dell'interazione con l'utente fisico circa la particolare implementazione di \ ``CodeBreaker``\  da impiegare nel gioco.

   :param registry: da cui recuperare le informazioni
   :return: BreakerFactory per la generazione di nuovi giocatori \ ``CodeBreaker``\

setupMaker
^^^^^^^^^^

.. java:method:: public MakerFactory setupMaker(MakerFactoryRegistry registry)
   :outertype: StartView

   Gestione dell'interazione con l'utente fisico circa la particolare implementazione di \ ``CodeMaker``\  da impiegare nel gioco.

   :param registry: da cui recuperare le informazioni
   :return: MakerFactory per la generazione di nuovi giocatori \ ``CodeMaker``\

showLogo
^^^^^^^^

.. java:method:: public void showLogo()
   :outertype: StartView

   Gestione di interazione con l'utente fisico per mostrare il logo di gioco.

showNewMatchStarting
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void showNewMatchStarting()
   :outertype: StartView

   Gestione dell'interazione con l'utente fisico circa l'inizio di un nuovo match

