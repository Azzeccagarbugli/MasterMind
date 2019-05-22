.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.lang.reflect InvocationTargetException

.. java:import:: java.nio.charset Charset

.. java:import:: java.nio.file Files

.. java:import:: java.util ArrayList

.. java:import:: java.util LinkedHashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: it.unicam.cs.pa.mastermind.factories PlayerFactory

PlayerFactoryRegistry
=====================

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public abstract class PlayerFactoryRegistry

Constructors
------------
PlayerFactoryRegistry
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public PlayerFactoryRegistry(String pathLettura)
   :outertype: PlayerFactoryRegistry

Methods
-------
getFactoryByName
^^^^^^^^^^^^^^^^

.. java:method:: public PlayerFactory getFactoryByName(String name)
   :outertype: PlayerFactoryRegistry

getPlayersNames
^^^^^^^^^^^^^^^

.. java:method:: public List<String> getPlayersNames()
   :outertype: PlayerFactoryRegistry

