# MeteoProject - Application Météo Microservices

##  Description
Application météo basée sur une architecture microservices, permettant de consulter la météo en temps réel, gérer des villes favorites et recevoir des alertes météo personnalisées.

##  Équipe (Classe 4SSA15-G3)
- Souha Said
- Nadim Sboui
- Chrif Smaya
- Adel Ben Sassi
- Moataz Achour
- Omar Bousrih

##  Architecture Globale
Le projet est divisé en 6 microservices :
1. **Service Accès (Auth + Gateway) :** Gestion des utilisateurs, JWT, routage. (PostgreSQL)
2. **Service Localisation :** Pays, régions, villes. (PostgreSQL)
3. **Service Météo :** Données météo, prévisions, API OpenWeatherMap. (MongoDB)
4. **Service Alertes :** Gestion des seuils et déclenchement d'alertes. (PostgreSQL)
5. **Service Préférences :** Villes favorites, paramètres utilisateur. (MongoDB)
6. **Service Notifications :** Envoi d'emails, SMS, push. (MongoDB)

##  Technologies Utilisées
- **Backend :** Spring Boot (Java) / ASP.NET Core (C#) pour Notifications
- **Frontend :** Angular
- **Infrastructure :** API Gateway, Eureka, Config Server, Keycloak, Docker
- **Bases de données :** PostgreSQL, MongoDB
- **Communication :** OpenFeign (Synchrone), RabbitMQ (Asynchrone)

## Structure du Dépôt
- `Backend/` : Contient les projets de chaque microservice.
- `Frontend/` : Application cliente.
- `Documentation/` : Présentations, Diagrammes et Dossier Technique.
- `README.md` : Ce fichier.

##  Comment lancer le projet
*(À compléter lors de la phase de développement)*
