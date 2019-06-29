MatchState
==========

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class MatchState extends BoardObserver

   \ **Responsabilità**\ : tenere traccia delle informazioni necessarie per poter decretare se una partita è ancora in corso o meno. Rientra nel pattern \ **Observer**\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
MatchState
^^^^^^^^^^

.. java:constructor:: public MatchState(BoardModel subject)
   :outertype: MatchState

   Inizializzazione con valori di default.

   :param subject: BoardModel coinvolta nel pattern \ **Observer**\

Methods
-------
getBreakerVictoryAttempts
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public int getBreakerVictoryAttempts()
   :outertype: MatchState

   Metodo attraverso il quale vengono restituiti i tentativi usati fino ad ora dal \ ``CodeBreaker``\  in caso abbia vinto.

   :return: int numero di tentativi che sono stati necessari al Breaker per vincere.

getHasBreakerWon
^^^^^^^^^^^^^^^^

.. java:method:: public boolean getHasBreakerWon()
   :outertype: MatchState

   Metodo che stabilisce la vittoria del giocatore Breaker o meno.

   :return: boolean che indica se il Breaker ha vinto o meno.

getHasMakerWon
^^^^^^^^^^^^^^

.. java:method:: public boolean getHasMakerWon()
   :outertype: MatchState

   Metodo che stabilisce la vittoria del giocatore Maker o meno.

   :return: boolean che indica se il Maker ha vinto o meno.

getMessage
^^^^^^^^^^

.. java:method:: public String getMessage()
   :outertype: MatchState

   Metodo che comunica l'esito finale della partita corrente.

   :return: String che comunica il vincitore attuale della partita

toggleBreakerGiveUp
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void toggleBreakerGiveUp()
   :outertype: MatchState

   Toggle sulle variabili private per indicare la resa del Breaker.

toggleBreakerWin
^^^^^^^^^^^^^^^^

.. java:method:: public void toggleBreakerWin(int attempts)
   :outertype: MatchState

   Toggle sulle variabili private per indicare la vittoria del Breaker.

   :param attempts: il numero di tentativi impiegati dal Breaker per vincere

toggleMakerWin
^^^^^^^^^^^^^^

.. java:method:: public void toggleMakerWin()
   :outertype: MatchState

   Toggle sulle variabili private per indicare la vittoria del Maker.

update
^^^^^^

.. java:method:: @Override public void update()
   :outertype: MatchState

