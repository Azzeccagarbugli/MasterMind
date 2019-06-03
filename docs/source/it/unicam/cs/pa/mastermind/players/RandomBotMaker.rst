.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Random

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionView

RandomBotMaker
==============

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class RandomBotMaker extends CodeMaker

   La seguente classe definisce lo standard per cui un Bot possa essere colui che effettua la scelta della sequenza da indovinare. Questa sequenza poi potrà essere decoficata da altri Bot aventi la sua stessa natura o da player di natura Human.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getCodeToGuess
^^^^^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getCodeToGuess(InteractionView intView)
   :outertype: RandomBotMaker

