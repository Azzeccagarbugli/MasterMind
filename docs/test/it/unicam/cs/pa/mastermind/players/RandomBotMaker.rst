.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Random

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

RandomBotMaker
==============

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class RandomBotMaker extends CodeMaker

   Estensione di \ ``CodeMaker``\  mirata ad una gestione del comportamento del giocatore in maniera casuale.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
RandomBotMaker
^^^^^^^^^^^^^^

.. java:constructor:: public RandomBotMaker(int seqLength)
   :outertype: RandomBotMaker

Methods
-------
getCodeToGuess
^^^^^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getCodeToGuess()
   :outertype: RandomBotMaker

