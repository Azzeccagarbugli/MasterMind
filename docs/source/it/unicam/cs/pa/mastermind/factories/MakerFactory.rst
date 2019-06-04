.. java:import:: it.unicam.cs.pa.mastermind.players CodeMaker

MakerFactory
============

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public abstract class MakerFactory implements PlayerFactory

   Classe factory astratta estensione di \ ``PlayerFactory``\  da estendere con classi factory concrete finalizzate all'ottenimento di istanze di \ ``CodeMaker``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getMaker
^^^^^^^^

.. java:method:: public abstract CodeMaker getMaker()
   :outertype: MakerFactory

