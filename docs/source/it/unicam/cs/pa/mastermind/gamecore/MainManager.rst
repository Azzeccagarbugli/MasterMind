.. java:import:: it.unicam.cs.pa.mastermind.factories BadRegistryException

.. java:import:: it.unicam.cs.pa.mastermind.factories GameViewFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories StartViewFactory

.. java:import:: it.unicam.cs.pa.mastermind.ui StartView

MainManager
===========

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public abstract class MainManager

   \ **Responsabilità**\ : permettere il corretto svolgimento del gioco, monitorando e tenendo traccia di una partita di MasterMind alla volta. \ **Contratto**\ : le classi che estendono \ ``MainManager``\  devono includere al loro interno il metodo di avvio \ ``main``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
MainManager
^^^^^^^^^^^

.. java:constructor:: public MainManager()
   :outertype: MainManager

Methods
-------
getGameViewFactory
^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract GameViewFactory getGameViewFactory()
   :outertype: MainManager

   Ottenimento dell'istanza di \ ``GameViewFactory``\  che si desidera impiegare all'interno di tutti i match per poter generare istanze di \ ``GameView``\  utili per l'interazione con l'utente fisico durante il loro svolgimento. \ **Contratto**\ : il metodo deve risultare coerente con la particolare estensione di \ ``MainManager``\  in cui viene definito.

   :return: GameViewFactory da impiegare in \ ``SingleMatch``\

getStartViewFactory
^^^^^^^^^^^^^^^^^^^

.. java:method:: protected abstract StartViewFactory getStartViewFactory()
   :outertype: MainManager

   Ottenimento dell'istanza di \ ``StartViewFactory``\  che si desidera impiegare all'interno di \ ``MainManager``\  per poter generare istanze di \ ``StartView``\  utili per l'interazione con l'utente fisico. \ **Contratto**\ : il metodo deve risultare coerente con la particolare estensione di \ ``MainManager``\  in cui viene definito.

   :return: StartViewFactory da impiegare in \ ``MainManager``\

startUp
^^^^^^^

.. java:method:: public void startUp()
   :outertype: MainManager

   Gestione continua di nuovi match, creati, gestiti ed avviati uno alla volta.

