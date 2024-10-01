Objectif
Ce projet vise à apprendre à insérer et récupérer des données d'une base de données MySQL en utilisant JDBC (Java Database Connectivity) avec Java. Vous allez créer une table, y insérer des données, puis les récupérer.

Prérequis
Java (JDK 8 ou supérieur)
MySQL (Version 5.7 ou supérieure)
NetBeans (ou tout autre IDE supportant Java)
Étapes du projet
Partie 1 : Création du projet
Ouvrir NetBeans :

Sélectionner Java -> Java Application.
Nommer le projet demojdbc.
Ajouter la bibliothèque MySQL :

Accéder aux propriétés du projet et ajouter le driver MySQL à la bibliothèque.
Partie 2 : Création de la table
Ouvrir le terminal MySQL :

Créer la base de données db.
Créer la table site :

Définir la structure de la table avec des colonnes pour id et nom.
Partie 3 : Insertion des données
Créer une classe Site :

Cette classe représentera les objets site avec des attributs pour l'identifiant et le nom.
Créer une méthode pour insérer des données :

Établir une connexion à la base de données, créer une instruction SQL et insérer les données dans la table.
Tester l'insertion dans la méthode principale :

Appeler la méthode d'insertion pour ajouter plusieurs sites.
Partie 4 : Récupération des données
Créer une méthode pour charger les données :

Établir une connexion, exécuter une requête SQL pour sélectionner les données et afficher les résultats.
Tester la récupération dans la méthode principale :

Appeler la méthode de chargement après l'insertion pour afficher les sites.
Exercice 1 : Scripts des développeurs
Création de la table DevData :

Définir la structure de la table pour enregistrer les informations sur les développeurs.
pour ça j'ai crée une interface developpeurdao qui contient des méthode abstract Qui sera mis en œuvre
après l'implementation de cet interface par la classe developpeurdaoimpl Qui contiendra à son tour toutes
les méthodes dont nous aurons besoin pour créer la table, la remplir et récupérer les informations de la
base de données. 
Insérer des données d'exemple :

Ajouter des entrées pour chaque développeur et le nombre de scripts réalisés.
Exercice 2 : Recherche d'informations
Écrire des requêtes SQL pour trouver le développeur avec le maximum de scripts et afficher la liste des développeurs triée par le nombre de scripts.
Exercice 3 : Requêtes libres
Utiliser des métadonnées pour afficher des informations sur les résultats d'une requête, comme le nombre de colonnes et leur type.
Conclusion
Ce TP vous permet d'acquérir une compréhension de base de l'utilisation de JDBC pour interagir avec une base de données MySQL en Java. Testez chaque fonctionnalité après l'implémentation.
