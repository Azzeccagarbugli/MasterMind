.. java:import:: it.unicam.cs.pa.mastermind.factories BreakerFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories MakerFactory

.. java:import:: it.unicam.cs.pa.mastermind.gamecore NewGameStats

.. java:import:: it.unicam.cs.pa.mastermind.gamecore SingleMatch

.. java:import:: it.unicam.cs.pa.mastermind.players BadRegistryException

.. java:import:: it.unicam.cs.pa.mastermind.players PlayerFactoryRegistry

StartView
=========

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public abstract class StartView

   \ **Responsabilità**\ : fornire agli utenti fisici coinvolti nel gioco l'interazione per poter iniziare nuove partite.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
startStats
^^^^^^^^^^

.. java:field:: protected StartStats startStats
   :outertype: StartView

   Istanza della classe \ ``StartStats``\ .

Constructors
------------
StartView
^^^^^^^^^

.. java:constructor:: public StartView()
   :outertype: StartView

Methods
-------
askNewAttempts
^^^^^^^^^^^^^^

.. java:method:: protected abstract int askNewAttempts()
   :outertype: StartView

   Gestione dell'interazione con l'utente fisico per l'impostazione di un nuovo valore di numero di tentativi massimi richiesti al \ ``CodeBreaker``\  all'interno della nuova partita.

   :return: int numero di tentativi massimi richiesti al \ ``CodeBreaker``\  all'interno della nuova partita.

askNewGameSettings
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract NewGameStats askNewGameSettings()
   :outertype: StartView

   Interazione con l'utente fisico a fronte della conclusione di una singola partita.

   :return: NewGameStats contenente informazioni relative all'inizio di una nuova partita e alle impostazioni correlate.

askNewLength
^^^^^^^^^^^^

.. java:method:: protected abstract int askNewLength()
   :outertype: StartView

   Gestione dell'interazione con l'utente fisico per l'impostazione di un nuovo valore della lunghezza delle sequenze di elementi presenti nella nuova partita.

   :return: int valore della lunghezza delle sequenze di elementi presenti nella nuova partita.

askNewSettings
^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean askNewSettings()
   :outertype: StartView

   Gestione dell'interazione con l'utente fisico per l'impostazione o meno di nuove impostazioni relative alla nuova partita.

   :return: boolean volontà dell'utente fisico di decidere nuove impostazioni per la nuova partita.

badEnding
^^^^^^^^^

.. java:method:: protected abstract void badEnding(String reason)
   :outertype: StartView

   Gestione anticipata della conclusione dell'intero gioco, richiamata ad esempio per il sollevamento di errori importanti.

   :param reason:

ending
^^^^^^

.. java:method:: protected abstract void ending()
   :outertype: StartView

   Gestione della conclusione dell'intero gioco dopo la fine di ogni singola partita.

getInteractionView
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract InteractionView getInteractionView()
   :outertype: StartView

   Ottenimento dell'oggetto \ ``InteractionView``\  associato alla particolare implementazione di \ ``StartView``\ .

   :return: InteractionView associata all'oggetto \ ``StartView``\ .

getPlayerName
^^^^^^^^^^^^^

.. java:method:: protected abstract String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker)
   :outertype: StartView

   Gestione dell'interazione dell'utente fisico per la scelta della particolare implementazione dei giocatori che verranno coinvolti nella nuova partita.

   :param registry: registro contenente le informazioni sulle classi \ ``PlayerFactory``\  relative alle implementazioni dei giocatori.
   :param isBreaker: flag che indica se la scelta è relativa ad un giocatore \ ``CodeBreaker``\  o meno.
   :return: String rappresentante l'implementazione del giocatore scelta per la nuova partita.

showLogo
^^^^^^^^

.. java:method:: protected abstract void showLogo()
   :outertype: StartView

   Gestione del logo di avvio del gioco.

showNewGameStarting
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract void showNewGameStarting()
   :outertype: StartView

   Gestione del messaggio di avvio di una singola partita.

startUp
^^^^^^^

.. java:method:: public void startUp()
   :outertype: StartView

   Gestione completa dell'interazione con l'utente fisico per poter iniziare una nuova partita.

