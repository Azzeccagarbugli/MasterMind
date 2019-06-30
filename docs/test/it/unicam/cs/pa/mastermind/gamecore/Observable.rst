.. java:import:: java.util ArrayList

.. java:import:: java.util List

Observable
==========

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public abstract class Observable

   Classe astratta impiegata per la definizione di oggetti \ ``Observable``\  all'interno del pattern \ **Observer**\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
addObserver
^^^^^^^^^^^

.. java:method:: public void addObserver(Observer obs)
   :outertype: Observable

   Metodo il quale registra un nuovo \ ``BoardObserver``\  e notifica tutti i \ ``Observer``\  attualmente associati all'istanza di \ ``Observable``\ .

   :param obs: nuova istanza di \ ``Observer``\  da aggiungere

notifyObservers
^^^^^^^^^^^^^^^

.. java:method:: public void notifyObservers()
   :outertype: Observable

   Metodo che notifica ogni observer iscritto al registro \ ``observers``\  del cambio di stato dell'istanza di \ ``Observable``\  su cui è chiamato.

removeObserver
^^^^^^^^^^^^^^

.. java:method:: public void removeObserver(Observer obs)
   :outertype: Observable

   Metodo di rimozione di un \ ``Observer``\  da \ ``observers``\ .

   :param obs: oggetto \ ``Observer``\  da rimuovere

setupObservers
^^^^^^^^^^^^^^

.. java:method:: public void setupObservers()
   :outertype: Observable

