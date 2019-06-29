.. java:import:: java.io IOException

.. java:import:: java.nio.file Files

.. java:import:: java.nio.file Paths

.. java:import:: java.util Arrays

.. java:import:: java.util List

.. java:import:: org.junit.jupiter.api Assertions

.. java:import:: org.junit.jupiter.api Test

.. java:import:: it.unicam.cs.pa.mastermind.factories BadRegistryException

.. java:import:: it.unicam.cs.pa.mastermind.factories BreakerFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories BreakerFactoryRegistry

.. java:import:: it.unicam.cs.pa.mastermind.factories MakerFactory

.. java:import:: it.unicam.cs.pa.mastermind.factories MakerFactoryRegistry

.. java:import:: it.unicam.cs.pa.mastermind.players CodeBreaker

.. java:import:: it.unicam.cs.pa.mastermind.players CodeMaker

PlayersFactoryRegistry
======================

.. java:package:: it.unicam.cs.pa.mastermind.test
   :noindex:

.. java:type::  class PlayersFactoryRegistry

   Test di controllo utili alla generazione delle factory relativi ai player.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
playersFactory
^^^^^^^^^^^^^^

.. java:field::  List<String> playersFactory
   :outertype: PlayersFactoryRegistry

Methods
-------
testBreakerFactoryRegistry
^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testBreakerFactoryRegistry() throws BadRegistryException
   :outertype: PlayersFactoryRegistry

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.factories.BreakerFactoryRegistry.BreakerFactoryRegistry()`\ .

   :throws BadRegistryException:

testCheckRightPathName
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testCheckRightPathName() throws BadRegistryException, IOException
   :outertype: PlayersFactoryRegistry

   Test method for the check of the existence of the path name passed in the constructor.

   :throws BadRegistryException:
   :throws IOException:

testGetFactoryByName
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testGetFactoryByName() throws BadRegistryException
   :outertype: PlayersFactoryRegistry

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.factories.PlayerFactoryRegistry.getFactoryByName(java.lang.String)`\ .

   :throws BadRegistryException:

testGetPlayersNames
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testGetPlayersNames() throws BadRegistryException
   :outertype: PlayersFactoryRegistry

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.factories.PlayerFactoryRegistry.getPlayersNames()`\ .

   :throws BadRegistryException:

testMakerFactoryRegistry
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Test  void testMakerFactoryRegistry() throws BadRegistryException
   :outertype: PlayersFactoryRegistry

   Test method for \ :java:ref:`it.unicam.cs.pa.mastermind.factories.MakerFactoryRegistry.MakerFactoryRegistry()`\ .

   :throws BadRegistryException:

