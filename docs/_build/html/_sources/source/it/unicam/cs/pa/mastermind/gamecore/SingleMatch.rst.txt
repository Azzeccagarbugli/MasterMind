.. java:import:: it.unicam.cs.pa.mastermind.factories BreakerFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories GameViewFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories MakerFactory

.. java:import:: it.unicam.cs.pa.mastermind.players CodeBreaker

.. java:import:: it.unicam.cs.pa.mastermind.players CodeMaker

.. java:import:: it.unicam.cs.pa.mastermind.ui AnsiUtility

.. java:import:: it.unicam.cs.pa.mastermind.ui GameView

SingleMatch
===========

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class SingleMatch

   \ **Responsabilità**\ : gestione dello svolgimento di una singola partita di gioco.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
gameState
^^^^^^^^^

.. java:field::  MatchState gameState
   :outertype: SingleMatch

   Oggetto contenente informazioni relative al vincitore della partita in corso.

Constructors
------------
SingleMatch
^^^^^^^^^^^

.. java:constructor:: public SingleMatch(int sequenceLength, int attempts, GameViewFactory viewFactory, BreakerFactory bFactory, MakerFactory mFactory)
   :outertype: SingleMatch

   Costruttore di una singola partita

   :param sequenceLength: relativa alle sequenze di \ ``CodePegs``\  impiegate nella partita.
   :param attempts: massimi per il giocatore Breaker per indovinare.
   :param view: Istanza della particolare implementazione di \ ``InteractionView``\  scelta per l'istanza di partita in corso.
   :param bFactory: istanza della \ ``BreakerFavctory``\  relativa al giocatore \ ``CodeBreaker``\  selezionato per la partita.
   :param mFactory: istanza della \ ``MakerFactory``\  relativa al giocatore \ ``CodeMaker``\  selezionato per la partita.

Methods
-------
start
^^^^^

.. java:method:: public void start()
   :outertype: SingleMatch

   Avvio e gestione completa di una singola partita di gioco.

