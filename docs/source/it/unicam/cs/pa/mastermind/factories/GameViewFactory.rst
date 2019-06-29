.. java:import:: it.unicam.cs.pa.mastermind.gamecore BoardModel

.. java:import:: it.unicam.cs.pa.mastermind.ui GameView

GameViewFactory
===============

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public interface GameViewFactory

   Interfaccia finalizzata all'implementazione di classi factory per le particolari implementazioni della vista \ ``GameView``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getGameView
^^^^^^^^^^^

.. java:method:: public GameView getGameView(BoardModel subject)
   :outertype: GameViewFactory

   Ottenimento di un'istanza di una vista \ ``GameView``\ . \ **Contratto**\ : il metodo deve avere come argomento un riferimento ad un oggetto BoardModel in quanto l'istanza restituita appartiene al pattern \ **Observer**\  in cui è coinvolto BoardModel.

   :param subject: l'istanza fondamentale per il pattern \ **Observer**\
   :return: GameView istanza richiesta

getNewInstance
^^^^^^^^^^^^^^

.. java:method:: public GameView getNewInstance()
   :outertype: GameViewFactory

   :return: GameView nuova istanza di \ ``GameView``\  a cui non è stato aggiunto il soggetto da osservare secondo il pattern \ **Observer**\

