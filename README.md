## Présentation générale

L'API W40K est une API mettant à disposition des citations de l'univers Warhammer 40,000, un univers de science-fiction grimdark.

Actuellement en cours de développement.

## Stack

Mon choix s'est porté sur les technologies suivantes :

* Java 21
* Maven (Failsafe plugin)
* Spring Boot (Spring Web, Spring Data JPA)
* JUnit, AssertJ, Mockito, Jackson, JSONassert
* H2 (en dév, PostgreSQL en prod)
* Git, Gitflow
* Trello

## Bonnes pratiques

Ce projet est notamment l'occasion pour moi de mettre en application différentes notions-clefs de la programmation orientée objet.

### Architecture logicielle

J'ai opté pour une architecture en couches, ou n-tier, découpée en quatre parties : couche contrôleur, couche business, couche persistance et couche base de données.

De la sorte, la séparation des préoccupations est respectée.

### Principes SOLID

L'application des cinq principes SOLID est un processus diffus tout au long du développement du projet, autant à l'organisation du code qu'à l'écriture du code à proprement parler.

### Tests

Un soin particulier est apporté aux tests, prérequis d'un code résilient et fiable.

Des tests unitaires sont écrits pour tester la logique de chaque classe en isolation, incluant des tests de sérialisation/désérialisation, et des tests d'intégration sont écrits pour tester l'ensemble des endpoints.

De plus j'utilise les possibilités offertes par Spring sous la forme des slice tests, lorsqu'une tranche du contexte plutôt que le contexte dans son intégralité est suffisante.

### Javadoc

Enfin, l'ensemble des classes et des méthodes sont commentées et renseignées conformément à la convention Sun.