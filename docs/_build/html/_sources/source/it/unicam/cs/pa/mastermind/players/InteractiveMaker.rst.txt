.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionView

InteractiveMaker
================

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class InteractiveMaker extends CodeMaker

   Estensione di \ ``CodeMaker``\  mirata ad una gestione del comportamento del giocatore tramite interazioni con l'utente umano.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getCodeToGuess
^^^^^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getCodeToGuess(InteractionView intView)
   :outertype: InteractiveMaker

