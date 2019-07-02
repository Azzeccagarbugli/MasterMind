.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui GameView

InteractiveMaker
================

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class InteractiveMaker extends CodeMaker

   Particolare estensione di \ ``CodeMaker``\ , rappresentante un giocatore umano. Nello specifico l'utente umano può effettuare decisioni ed impartire comandi passando da un'istanza di \ ``GameView``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
InteractiveMaker
^^^^^^^^^^^^^^^^

.. java:constructor:: public InteractiveMaker(GameView newView, int seqLength)
   :outertype: InteractiveMaker

Methods
-------
getCodeToGuess
^^^^^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getCodeToGuess()
   :outertype: InteractiveMaker

