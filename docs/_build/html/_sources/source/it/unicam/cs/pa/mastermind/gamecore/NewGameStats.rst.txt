NewGameStats
============

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class NewGameStats

   \ **Responsabilità**\ : tenere traccia delle informazioni necessarie per poter iniziare una nuova partita dopo che ne è stata conclusa una.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
NewGameStats
^^^^^^^^^^^^

.. java:constructor:: public NewGameStats(boolean toContinue, boolean keepSettings)
   :outertype: NewGameStats

   Costruttore

   :param toContinue: volontà dell'utente umano di continuare a giocare o meno.
   :param keepSettings: volontà dell'utente umano di continuare a giocare con le medesime impostazioni o meno.

Methods
-------
getContinue
^^^^^^^^^^^

.. java:method:: public boolean getContinue()
   :outertype: NewGameStats

   :return: boolean volontà dell'utente umano di continuare a giocare o meno.

getKeepSettings
^^^^^^^^^^^^^^^

.. java:method:: public boolean getKeepSettings()
   :outertype: NewGameStats

   :return: boolean volontà dell'utente umano di continuare a giocare con le medesime impostazioni o meno.

