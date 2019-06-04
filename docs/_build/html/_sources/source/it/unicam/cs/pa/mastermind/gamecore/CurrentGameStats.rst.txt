.. java:import:: it.unicam.cs.pa.mastermind.ui BoardObserver

CurrentGameStats
================

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class CurrentGameStats extends BoardObserver

   \ **Responsabilità**\ : tenere traccia delle informazioni necessarie per poter decretare se una partita è terminata o meno.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
CurrentGameStats
^^^^^^^^^^^^^^^^

.. java:constructor:: public CurrentGameStats(BoardModel board)
   :outertype: CurrentGameStats

   Costruttore.

Methods
-------
getAttempts
^^^^^^^^^^^

.. java:method:: public int getAttempts()
   :outertype: CurrentGameStats

   Metodo attraverso il quale vengono restituiti i tentativi rimanenti al player per vincere il game corrente.

   :return: int numero di tentativi che sono stati necessari al Breaker per vincere.

getHasBreakerWon
^^^^^^^^^^^^^^^^

.. java:method:: public boolean getHasBreakerWon()
   :outertype: CurrentGameStats

   Metodo che stabilisce la vittoria del giocatore Breaker o meno.

   :return: boolean che indica se il Breaker ha vinto o meno.

getHasMakerWon
^^^^^^^^^^^^^^

.. java:method:: public boolean getHasMakerWon()
   :outertype: CurrentGameStats

   Metodo che stabilisce la vittoria del giocatore Maker o meno.

   :return: boolean che indica se il Maker ha vinto o meno.

getMessage
^^^^^^^^^^

.. java:method:: public String getMessage()
   :outertype: CurrentGameStats

   Metodo che comunica l'esito finale della partita corrente.

   :return: String che comunica il vincitore attuale della partita

toggleBreakerWin
^^^^^^^^^^^^^^^^

.. java:method:: public void toggleBreakerWin(int attempts)
   :outertype: CurrentGameStats

   Toggle sulle variabili private per indicare la vittoria del Breaker.

   :param attempts: il numero di tentativi impiegati dal Breaker per vincere

toggleMakerWin
^^^^^^^^^^^^^^

.. java:method:: public void toggleMakerWin()
   :outertype: CurrentGameStats

   Toggle sulle variabili private per indicare la vittoria del Maker.

update
^^^^^^

.. java:method:: @Override public void update()
   :outertype: CurrentGameStats

