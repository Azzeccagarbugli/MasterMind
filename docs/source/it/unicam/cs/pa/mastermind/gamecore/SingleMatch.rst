.. java:import:: it.unicam.cs.pa.mastermind.players CodeBreaker

.. java:import:: it.unicam.cs.pa.mastermind.players CodeMaker

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionView

SingleMatch
===========

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class SingleMatch

   \ **Responsabilità**\ : gestione dello svolgimento di una singola partita di gioco.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
gameStats
^^^^^^^^^

.. java:field::  CurrentGameStats gameStats
   :outertype: SingleMatch

   Oggetto contenente informazioni relative al vincitore della partita in corso.

Constructors
------------
SingleMatch
^^^^^^^^^^^

.. java:constructor:: public SingleMatch(int sequenceLength, int attempts, InteractionView view, CodeBreaker currentBreaker, CodeMaker currentMaker)
   :outertype: SingleMatch

   Costruttore di una singola partita

   :param sequenceLength: relativa alle sequenze di \ ``CodePegs``\  impiegate nella partita.
   :param attempts: massimi per il giocatore Breaker per indovinare.
   :param view: Istanza della particolare implementazione di \ ``InteractionView``\  scelta per l'istanza di partita in corso.
   :param currentBreaker: istanza del giocatore che decodifica.
   :param currentMaker: istanza del giocatore che codifica.

Methods
-------
start
^^^^^

.. java:method:: public void start()
   :outertype: SingleMatch

   Avvio e gestione completa di una singola partita di gioco.

