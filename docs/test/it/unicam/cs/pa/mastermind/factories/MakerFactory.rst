.. java:import:: it.unicam.cs.pa.mastermind.players CodeMaker

.. java:import:: it.unicam.cs.pa.mastermind.ui GameView

MakerFactory
============

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public interface MakerFactory extends PlayerFactory

   \ **Responsabilità**\ : fornire istanze di implementazioni di \ ``CodeMaker``\ . Interfaccia finalizzata all'implementazione di classi factory per le particolari implementazioni dei giocatori \ ``CodeMaker``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getMaker
^^^^^^^^

.. java:method:: public CodeMaker getMaker(GameView view, int seqLength, int attempts)
   :outertype: MakerFactory

   Ottenimento di un'istanza di un giocatore \ ``CodeMaker``\ .

   :param view: vista per l'interazione con l'utente fisico
   :param seqLength: lunghezza della sequenza di \ ``ColorPegs``\  da trattare
   :param attempts: numero di tentativi per vincere il gioco
   :return: CodeMaker istanza di un giocatore \ ``CodeMaker``\

