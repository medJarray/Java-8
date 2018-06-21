"Java-8-Preview" 

********************************************
* Streams : Les Opérations Intermédiaires et Terminales 
********************************************
Les Streams sont une mise à jour de l’API Java 8 qui vous permet de manipuler des collections de données de manière déclarative (vous exprimez une requête plutôt que de coder une implémentation ad hoc).

Cet exemple montre divers extraits de code pour illustrer les opérations Intermédiaires et Terminale sur les stream.

* Les opérations Intermédiaires renvoient un autre stream qui vous permet d'appeler plusieurs opérations (intermédiaires ou terminal) sous la forme d'une requête.

Exemple de quelques opérations :
	
	- Filter()
	- Map()
	- Peek()
	- Distinct()
	- Sorted()
	- Limit()

	
* Les opérations Terminales produisent un résultat non-stream, tel qu'une valeur primitive, une collection ou aucune valeur.
Les opérations de terminal sont généralement précédées d'opérations intermédiaires qui renvoient un autre flux qui permet aux opérations d'être connectées sous la forme d'une requête.

Exemple de quelques opérations :

	- forEach()
	- toArray()
	- reduce()
	- collect()
	- min()
	- max()
	- count()
	- anymatch()
	- allMatch()
	- noneMatch()
	- findFirst()
	- findAny()
	
********************************************
* Date Time API Java 8 
********************************************

* Java 8 introduit une nouvelle API date-heure sous le package java.time. Voici quelques-unes des classes importantes introduites dans le paquet java.time: 

	-  Local : API de date-heure simplifiée sans complexité de gestion du fuseau horaire.
	-  Zoned : API de date-heure spécialisée pour traiter les différents fuseaux horaires.

* LocalDate représente une date au format ISO (aaaa-MM-jj) sans heure. Il peut être utilisé pour stocker des dates comme les anniversaires et les jours de paie.
Une instance de la date actuelle peut être crée à partir de l'horloge système comme ci-dessous:

	- LocalDate localDate = LocalDate.now ();

La LocalDate représentant un jour, un mois et une année spécifiques peut être obtenue en utilisant la méthode "of" ou en utilisant la méthode "parse". Par exemple, les extraits de code ci-dessous représentent la LocalDate du 20 Juin 2018:

	- LocalDate.of(2018, 06, 20);
 	- LocalDate.parse("2018-06-20");

LocalDate fournit diverses méthodes utilitaires pour obtenir une variété d'informations. Jetons un coup d'œil rapide sur certaines de ces méthodes d'API :

Cet exemple montre comment ajouter un jour, mois et année pour une date :

	- LocalDate currentDate = LocalDate.now();
	- LocalDate addOneYersToCurrentDate = currentDate.minusYears(1);
	
