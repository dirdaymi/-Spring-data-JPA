# 🏥 Système de Gestion Hospitalier (Spring Boot & JPA)

> **Projet académique** réalisé dans le cadre du module JEE / Spring Data.
> **Auteur :** Abdel-hamid Mahamat Louki

---

## 📋 Présentation du Projet
Ce projet est une application backend complète développée avec **Spring Boot**. L'objectif était de mettre en œuvre le **Mapping Objet-Relationnel (ORM)** avec JPA, Hibernate et Spring Data.

L'application gère trois modules principaux :
1.  **Produits** (CRUD simple).
2.  **Gestion Hospitalière** (Patients, Médecins, Rendez-vous, Consultations).
3.  **Sécurité** (Utilisateurs et Rôles).

---

## 🏗️ Architecture du Projet

Le projet respecte une architecture en couches (Layered Architecture) pour séparer la logique métier, l'accès aux données et les entités.

![Architecture](images/03capture.png)
*Vue de l'arborescence : Entités, Repositories, Services et Contrôleurs Web.*

---

## ⚙️ Configuration & Migration (H2 vers MySQL)

### Phase 1 : Base de données H2 (Développement)
Le projet a été initialement développé avec une base de données en mémoire (H2) pour le prototypage rapide.

**Configuration H2 :**
![Config H2](images/09capture.png)

**Interface Console H2 :**
![Console H2](images/05capture.png)
*(Vues supplémentaires disponibles : 06capture.png, 07capture.png)*

---

### Phase 2 : Migration vers MySQL (Production)
Ensuite, une migration vers **MySQL** a été effectuée pour assurer la persistance des données.

**Configuration MySQL (application.properties) :**
![Config MySQL](images/10capture.png)

---

## 💻 Code & Implémentation

L'application utilise l'interface `CommandLineRunner` pour insérer des données de test au démarrage.

**Classe Principale (HospitalApplication) :**
![Code Principal](images/01capture.png)

**Test du module Produits :**
![Test Produit](images/02capture.png)

*(Autres vues du code : 04capture.png)*

---

## 🚀 Exécution et Tests

### Validation Technique
Lancement de l'application et vérification des logs et de la connexion à la base de données via le terminal.

![Preuve MySQL](images/11capture.png)
*Requête SQL prouvant que les produits (Computer, Printer...) sont bien enregistrés dans la base MySQL.*

---

## 🛠️ Stack Technique

* **Langage :** Java 17
* **Framework :** Spring Boot 3 (Spring Web, Spring Data JPA)
* **SGBD :** MySQL 8 (Prod) / H2 (Dev)
* **Outils :** Maven, Lombok, IntelliJ IDEA Ultimate
* **OS :** Fedora Linux

---

## 🏁 Conclusion

Ce TP m'a permis de maîtriser :
* Les relations JPA complexes (`@OneToMany`, `@ManyToOne`, `@OneToOne`, `@ManyToMany`).
* L'injection de dépendances et l'Inversion de Contrôle (IoC).
* La gestion des transactions avec `@Transactional`.
* La transition d'un environnement de développement vers un environnement de production.
