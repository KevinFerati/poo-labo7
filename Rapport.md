# Labo 7 - Rapport

Auteur : Kevin Ferati

## Pile

Ma classe Pile est générique sur T. Ainsi, elle peut fonctionner avec théoriquement n'importe quel type.

Cette implémentation d'une pile est séparée en 3 classes :

Pile\<T> qui est l'unique classe publique et est le point d'entrée de la pile et dont la structure linéaire est une liste simplement enchaînée permettant d'ajouter des sommets en complexité O(1),

Maillon\<T> qui représente une chaîne dans une liste,
et MaillonIterateur\<T> permettant d'itérer sur une liste simplement enchaînée.

Elle contient un attribut "taille" privée permettant de créer plus facilement un tableau et permettant une méthode taille() retournant la taille de la pile. 

####  Cas de la fonction toArray()
C'était le premier problème que j'ai eu. Je ne voulais pas passer par une fonction rendant un tableau Objet[] afin de garder un typage sur T, sauf qu'il n'est pas possible de créer un tableau de type T[]


Ainsi, la fonction toArray de la Pile prend en paramètre une instance de type Class\<T> (de même type que l'argument générique de Pile) permettant ainsi d'obtenir comme résultat un tableau typé (et pas de type Object[]).

### Tests

Les tests de la pile sont réalisés au moyen de la classe PileTest, une classe de test unitaire JUnit 5.

Les tests sont les suivants:

- Fonction empiler 
- Fonction desempiler 
- Fonction desempiler sur une pile vide
- Boucle foreach 
- Fonction de conversion en array 
- Fonction de conversion en string 

Chacun de ces tests fonctionne. Je n'ai pas eu de problème à la réalisation de la pile.
Voir le fichier PileTest.java pour plus de détails sur les tests.


## Problèmes à la compilation
Il a été compliqué de faire compiler ce programme pour afficher le GUI, mais la solution retenue est :
1. En CLI, naviguer dans le dossier src
2. lancer la compilation avec javac .\HanoiTest.java
3. Lancer l'exécution avec java HanoiTest

J'avais essayé de mettre le fichier HanoiTest.java dans le package test, sans résultat.


## Autres problèmes
Outre la réalisation de la fonction toArray et la compilation, je n'ai pas eu de problème à la résolution de ce labo.









