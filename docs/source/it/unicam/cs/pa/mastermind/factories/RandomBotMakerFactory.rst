.. java:import:: it.unicam.cs.pa.mastermind.players CodeMaker

.. java:import:: it.unicam.cs.pa.mastermind.players RandomBotMaker

.. java:import:: it.unicam.cs.pa.mastermind.ui GameView

RandomBotMakerFactory
=====================

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public class RandomBotMakerFactory implements MakerFactory

   Classe factory implementazione di \ ``MakerFactory``\  impiegata per ottenere istanze di \ ``RandomBotMaker``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getDescription
^^^^^^^^^^^^^^

.. java:method:: @Override public String getDescription()
   :outertype: RandomBotMakerFactory

getMaker
^^^^^^^^

.. java:method:: @Override public CodeMaker getMaker(GameView view, int seqLength, int attempts)
   :outertype: RandomBotMakerFactory

getName
^^^^^^^

.. java:method:: @Override public String getName()
   :outertype: RandomBotMakerFactory

