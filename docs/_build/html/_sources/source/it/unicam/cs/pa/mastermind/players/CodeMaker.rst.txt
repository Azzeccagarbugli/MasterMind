.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionView

CodeMaker
=========

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public abstract class CodeMaker

   \ **Responsabilità**\ : gestire le interazioni del giocatore Maker

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getCodeToGuess
^^^^^^^^^^^^^^

.. java:method:: public abstract List<ColorPegs> getCodeToGuess(InteractionView intView)
   :outertype: CodeMaker

   Restituisce la sequenza di \ ``ColorPegs``\  valida come sequenza da indovinare.

   :param intView: necessario per ottenere informazioni riguardo il gioco
   :return: List di \ ``ColorPegs``\  valida come sequenza da indovinare

