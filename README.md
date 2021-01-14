# Mes-livres-JEE-sans-Framwork
La création d'une application Web JEE en respectant le pattern MVC sans utiliser aucun Framework.
## les besoins fonctionnelsr et consulter les livres
Insérer, modifier, supprimer et consulter les livres
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
## Demo
https://user-images.githubusercontent.com/58845279/104625102-a6e36100-5694-11eb-9c7e-fed134f7b3a3.mp4

