# Mes-livres-JEE-sans-Framwork
La création d'une application Web JEE en respectant le pattern MVC sans utiliser aucun Framework.
## les besoins fonctionnels
Insérer, modifier, supprimer, consulter et chercher des livres
## les tâches réalisées
- La création une base de données MySQL
- La création un projet web dynamique basé sur Tomcat  
- La création de la couche DAO pour faire le mapping Objet relationnel avec JDBC.
    - Une classe SingletonConnection qui crée une connexion JDBC en utilisant le pattern Singleton
    - Une entité Livre 
    - Une interface ILivreDao qui énoncer les méthodes permettant de manager les livres
    - Une implémentation JDBC de cette interface
    - Une classe pour tester la couche DAO. 
- La couche Web (Servlet, JSP, JSTL, Bootstrap 4 et MVC)
    - Créer un modèle
    - Créer un contrôleur en utilisant le composant Web Servlet
    - Créer des vues JSP basée sur JSTL en utilisant Bootstrap 4.
    - Déployer la servlet
## Architecture 
![Architecture JEE sans Framwok](https://user-images.githubusercontent.com/58845279/113705936-59e4b900-96de-11eb-9089-0d644068160d.jpg)
- 1 – Le client envoie une requête HTTP de type GET ou POST vers le contrôleur représenté par un composant Web JEE : SERVLET . Pour lire les données de la requête HTTP le contrôleur utilise l’objet request de type HttpServletRequest.
- 2 – Le contrôleur fait appel à la couche métier pour effectuer les traitements et récupère les résultats.
- 3 – la couche métier faite appelle à la couche DAO pour exécuter des requêtes.
- 4 – la couche DAO interagir avec la base de données via JDBC.
- 5 – Le contrôleur Stocke le résultat dans le modèle. Le modèle est généralement une objet qui permet de stocker toutes les données qui seront affichées dans la vue. Généralement, le contrôleur stocke le modèle dans l’objet request ou session.
- 6 – Le contrôleur fait appel à la vue JSP (Java Server Pages) en lui transmettant les mêmes objets request et response. Cette opération s’appel Forwarding.
- 7 – La vue JSP récupère le résultat à partir du modèle. La vue retrouve le modèle dans l’objet request ou session.
- 8 – La vue JSP génère dynamiquement une page HTML qui contient les résultats du modèle en utilisant l’objet response.
- 9 – la servlet envoyée dans le corps de la réponse HTTP la page HTML qui est générée et le Browser Web affiche le rendu de la page HTML reçue.


## Demo
https://user-images.githubusercontent.com/58845279/104625102-a6e36100-5694-11eb-9c7e-fed134f7b3a3.mp4

