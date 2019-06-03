.. java:import:: it.unicam.cs.pa.mastermind.gamecore BoardModel

BoardObserver
=============

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public abstract class BoardObserver

   Il pattern Observer permette di definire una dipendenza uno a molti fra oggetti, in modo tale che se un oggetto cambia il suo stato interno, ciascuno degli oggetti dipendenti da esso viene notificato e aggiornato automaticamente. L’Observer nasce dall’esigenza di mantenere un alto livello di consistenza fra classi correlate, senza produrre situazioni di forte dipendenza e di accoppiamento elevato.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
subject
^^^^^^^

.. java:field:: protected BoardModel subject
   :outertype: BoardObserver

   L'oggetto che viene osservato.

Methods
-------
addSubject
^^^^^^^^^^

.. java:method:: public void addSubject(BoardModel subject)
   :outertype: BoardObserver

   Metodo per il quale viene aggiunto un altro elemento da osservare alla lista interna.

   :param subject: il soggetto che si vuole osservare

update
^^^^^^

.. java:method:: public abstract void update()
   :outertype: BoardObserver

   Aggiornamento dello stato interno dell'oggetto.

