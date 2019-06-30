.. java:import:: it.unicam.cs.pa.mastermind.players CodeBreaker

.. java:import:: it.unicam.cs.pa.mastermind.ui GameView

BreakerFactory
==============

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public interface BreakerFactory extends PlayerFactory

   \ **Responsabilità**\ : fornire istanze di implementazioni di \ ``CodeBreaker``\ . Interfaccia finalizzata all'implementazione di classi factory per le particolari implementazioni dei giocatori \ ``CodeBreaker``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getBreaker
^^^^^^^^^^

.. java:method:: public CodeBreaker getBreaker(GameView view, int seqLength, int attempts)
   :outertype: BreakerFactory

   Ottenimento di un'istanza di un giocatore \ ``CodeBreaker``\ .

   :param view: vista per l'interazione con l'utente fisico
   :param seqLength: lunghezza della sequenza di \ ``ColorPegs``\  da trattare
   :param attempts: numero di tentativi per vincere il gioco
   :return: CodeBreaker istanza di un giocatore \ ``CodeBreaker``\

