.. java:import:: it.unicam.cs.pa.mastermind.factories BreakerFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories MakerFactory

.. java:import:: it.unicam.cs.pa.mastermind.gamecore NewGameStats

.. java:import:: it.unicam.cs.pa.mastermind.gamecore SingleGame

.. java:import:: it.unicam.cs.pa.mastermind.players PlayerFactoryRegistry

StartView
=========

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public abstract class StartView

   La classe astratta StartView elenca una serie di caratteristiche fondamentali che verranno poi estese a più alto livello all'interno della classe \ ``ConsoleStartView``\  e tale aggiunta rende il software più elegante e pulito.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
startStats
^^^^^^^^^^

.. java:field:: protected StartStats startStats
   :outertype: StartView

   Instanza della classe \ ``StartStats``\ .

Constructors
------------
StartView
^^^^^^^^^

.. java:constructor:: public StartView()
   :outertype: StartView

   Costruttore dello StartView.

Methods
-------
askNewAttempts
^^^^^^^^^^^^^^

.. java:method:: protected abstract int askNewAttempts()
   :outertype: StartView

   Vengono richiesti quanti nuovi tentativi si vogliono inserire.

   :return: il valore intero che rappresenta tale valore

askNewGameSettings
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract NewGameStats askNewGameSettings()
   :outertype: StartView

   Metodo che chiede le nuove impostazioni di gioco a fine partita.

   :return: vengono restituite tali informazioni sotto forma di \ ``NewGameStats``\

askNewLength
^^^^^^^^^^^^

.. java:method:: protected abstract int askNewLength()
   :outertype: StartView

   Viene richiesta la nuova lunghezza della sequenza.

   :return: il valore intero che rappresenta tale valore

askNewSettings
^^^^^^^^^^^^^^

.. java:method:: protected abstract boolean askNewSettings()
   :outertype: StartView

   Metodo che chiede le nuove impostazioni al player alla fine del game.

   :return: il valore booleano con tale informazione al suo interno

ending
^^^^^^

.. java:method:: protected abstract void ending()
   :outertype: StartView

   Metodo necessario all'ending del gioco.

getInteractionView
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract InteractionView getInteractionView()
   :outertype: StartView

   Metodo che restitusce l'InteractionView richiesta.

   :return: l'InteractionView desiderata

getPlayerName
^^^^^^^^^^^^^

.. java:method:: protected abstract String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker)
   :outertype: StartView

   Metodo getter necessario al get del nome del player.

   :param registry: il registro sul quale si sta cercando tale informazione
   :param isBreaker: valore booleano che rappresenta la veridicità del player breaker o meno
   :return: il nome del giocatore

showLogo
^^^^^^^^

.. java:method:: protected abstract void showLogo()
   :outertype: StartView

   Metodo puramente artistico che visualizza il logo del progetto.

showNewGameStarting
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract void showNewGameStarting()
   :outertype: StartView

   Mostra il primo avvio del gioco.

startUp
^^^^^^^

.. java:method:: public void startUp()
   :outertype: StartView

   Metodo \ ``startUp``\ o che esegue il set-up di un game completo.

