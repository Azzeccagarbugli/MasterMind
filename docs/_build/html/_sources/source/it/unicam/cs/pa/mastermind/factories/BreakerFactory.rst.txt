.. java:import:: it.unicam.cs.pa.mastermind.players CodeBreaker

BreakerFactory
==============

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public abstract class BreakerFactory implements PlayerFactory

   Classe factory astratta estensione di \ ``PlayerFactory``\  da estendere con classi factory concrete finalizzate all'ottenimento di istanze di \ ``CodeBreaker``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getBreaker
^^^^^^^^^^

.. java:method:: public abstract CodeBreaker getBreaker()
   :outertype: BreakerFactory

