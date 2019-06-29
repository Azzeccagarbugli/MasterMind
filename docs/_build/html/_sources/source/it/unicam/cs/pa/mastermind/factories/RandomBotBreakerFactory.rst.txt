.. java:import:: it.unicam.cs.pa.mastermind.players CodeBreaker

.. java:import:: it.unicam.cs.pa.mastermind.players RandomBotBreaker

.. java:import:: it.unicam.cs.pa.mastermind.ui GameView

RandomBotBreakerFactory
=======================

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public class RandomBotBreakerFactory implements BreakerFactory

   Classe factory implementazione di \ ``BreakerFactory``\  impiegata per ottenere istanze di \ ``RandomBotBreaker``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getBreaker
^^^^^^^^^^

.. java:method:: @Override public CodeBreaker getBreaker(GameView view, int seqLength, int attempts)
   :outertype: RandomBotBreakerFactory

getDescription
^^^^^^^^^^^^^^

.. java:method:: @Override public String getDescription()
   :outertype: RandomBotBreakerFactory

getName
^^^^^^^

.. java:method:: @Override public String getName()
   :outertype: RandomBotBreakerFactory

