.. MasterMind documentation master file, created by
   sphinx-quickstart on Thu May  9 15:20:45 2019.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

Benvenuto alla documentazione di MasterMind!
================================================
    *"Our education might stop, if we so choose. Our brains’ never does. 
    The brain will keep reacting to how we decide to use it. The difference 
    is not whether or not we learn, but what and how we learn."*
	
	*Maria Konnikova* [1]_

All'interno della seguente pagina web sarà possibile trovare la documentazione 
generata per il progetto **MasterMind**, realizzato per il corso di *Programmazione Avanzata*
dell'anno 2018/2019.

Strumenti con cui è stata realizzata
----------------------------------------------
Solitamente per documentare in maniera *raffinata* un progetto **Java** viene utilizzato 
lo strumento fornito dall'IDE di sviluppo stesso **JavaDoc** [2]_.

Esso offre degli incredibili vantaggi, come la facilità d'utilizzo e soprattutto un
layout ben noto all'interno della community dei developers Java che permette 
di trovare informazioni in maniera decisamente veloce.

La pecca più grande di tale strumento però resta la datazione dei vari stili che compongono
i file CSS e l'assenza di un'eleganza generale complessiva.

Per risolvere tale mancanza quindi si è pensato di ricorrere a **Sphinx** [3]_.

Poi mediante l'utilizzo di un'estensione nominata ``javasphinx`` [4]_ è stato possibile 
convertire i vari commenti **JavaDoc** secondo lo standard perseguito da Sphinx stesso, e così
facendo abbiamo ottenuto sia una documentazione piacevole per la vista che
facile ed intutiva da poter seguire.

Autogenerazione della sintassi convertita da JavaDoc a Sphinx
----------------------------------------------------------------
Per fare questa operazione è necessario innanzitutto installare ``javasphinx``
sulla propria macchina, attraverso il seguente comando:

``$ pip install javasphinx``

Una volta effettuato ciò sarà necessario inserire l'estensione ``javasphinx`` appena installata
nel file ``conf.py`` generato da Sphinx.

A questo bisognerà definire lo standard Java da seguire, all'interno del file
``conf.py``, nel seguente modo:

``javadoc_url_map = { '<namespace_here>' : ('<base_url_here>', 'javadoc') }``

Arrivati a questo punto basterà lanciare il comando: 

``$ javasphinx-apidoc -o docs/source/ --title='<name_here>' ../path/to/java_dirtoscan``

La documentazione quindi sarà pronta per essere usata nei vari file con estensione ``.rst`` che, attraverso il comando ``make``, diventaranno file ``.html``.


.. toctree::
	:hidden:
	:maxdepth: 2
	
	introduzione
	source/packages

.. [1] `Maria Konnikova, Mastermind: How to Think Like Sherlock Holmes <https://en.wikipedia.org/wiki/Mastermind:_How_to_Think_Like_Sherlock_Holmes>`_
.. [2] *Javadoc è un applicativo incluso nel Java Development Kit della Sun Microsystems, utilizzato per la generazione automatica della documentazione del codice sorgente scritto in linguaggio Java*
.. [3] *Software Open Source per l'autogenerazione di documentazioni a partire da un codice sorgente generico*
.. [4] `Javasphinx <https://bronto.github.io/javasphinx/>`_