WinStats
========

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class WinStats

   Classe che tiene conto del vincitore di una singola partita e del numero di tentativi relativi ad un'eventuale vittoria del breaker.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
WinStats
^^^^^^^^

.. java:constructor:: public WinStats()
   :outertype: WinStats

   Costruttore.

Methods
-------
getAttempts
^^^^^^^^^^^

.. java:method:: public int getAttempts()
   :outertype: WinStats

   Metodo attraverso il quale vengono restituiti i tentativi rimanenti al player per vincere il game corrente.

   :return: il numero di tentativi che sono stati necessari al Breaker per vincere.

getHasBreakerWon
^^^^^^^^^^^^^^^^

.. java:method:: public boolean getHasBreakerWon()
   :outertype: WinStats

   Metodo che stabilisce la vittoria del player breaker o meno.

   :return: boolean che indica se il Breaker ha vinto o meno.

getHasMakerWon
^^^^^^^^^^^^^^

.. java:method:: public boolean getHasMakerWon()
   :outertype: WinStats

   Metodo che stabilisce la vittoria del player maker o meno.

   :return: boolean che indica se il Maker ha vinto o meno.

getMessage
^^^^^^^^^^

.. java:method:: public String getMessage()
   :outertype: WinStats

   Metodo che comunica l'esito finale della partita corrente.

   :return: String che comunica il vincitore attuale della partita. In caso non ci siano vincitori non viene comunicato nulla.

toggleBreakerWin
^^^^^^^^^^^^^^^^

.. java:method:: public void toggleBreakerWin(int attempts)
   :outertype: WinStats

   Operazione di toggle sulle variabili private per indicare la vittoria del Breaker.

   :param attempts: il numero di tentativi

toggleMakerWin
^^^^^^^^^^^^^^

.. java:method:: public void toggleMakerWin()
   :outertype: WinStats

   Operazione di toggle sulle variabili private per indicare la vittoria del Maker.

