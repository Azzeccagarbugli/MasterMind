StartupSettings
===============

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class StartupSettings

   \ **Responsabilità**\ : tenere traccia delle informazioni necessarie per decidere se iniziare una nuova partita e se impostare nuove impostazioni di avvio. \ **Contratto**\ : le istanze vengono gestite all'interno di \ ``MainManager``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
StartupSettings
^^^^^^^^^^^^^^^

.. java:constructor:: public StartupSettings()
   :outertype: StartupSettings

   Nel costruttore senza parametri si manifesta la volontà di continuare a giocare sin dall'inizio e di non voler mantenere impostazioni. Il costruttore è nello specifico finalizzato ad un utilizzo dell'istanza di \ ``StartupSettings``\  sin dall'avvio del gioco, dove si presume si voglia avviare un nuovo match e di fatto non esistono impostazioni passate.

StartupSettings
^^^^^^^^^^^^^^^

.. java:constructor:: public StartupSettings(boolean toContinue, boolean keepSettings)
   :outertype: StartupSettings

   Costruttore in cui è possibile specificare la volontà di effettuare nuove partite e di mantenere o meno le impostazioni per il loro avvio.

   :param toContinue:
   :param keepSettings:

Methods
-------
getContinue
^^^^^^^^^^^

.. java:method:: public boolean getContinue()
   :outertype: StartupSettings

   :return: boolean volontà dell'utente umano di continuare a giocare o meno.

getKeepMatchStartSettings
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean getKeepMatchStartSettings()
   :outertype: StartupSettings

   :return: boolean volontà dell'utente umano di continuare a giocare con le medesime impostazioni o meno.

setKeepMatchStartSettings
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setKeepMatchStartSettings(boolean keepSettings)
   :outertype: StartupSettings

   Impostazione valore personalizzato della volontà di mantenere le impostazioni per l'avvio di nuove partite.

   :param keepSettings: volontà

setToContinue
^^^^^^^^^^^^^

.. java:method:: public void setToContinue(boolean toContinue)
   :outertype: StartupSettings

   Impostazione valore personalizzato della volontà di continuare a giocare.

   :param toContinue: volontà

