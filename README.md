# boulangerie-project-master

## Introduction

Application de gestion d'une boulangerie de la production jusqu'a la commercialisation

## Set-Up

Le projet est prevu pour etre developper sur vscode dont la configuration du java project se trouve dans `.vscode/settings.json` , et pour que le projet se charge correctement assurez vous d'avoir l'extension `java project` installer car les classes seront compiler automatiquement dans `WEB-INF/classes`

Les librairies seront dans le dossier `WEB-INF/lib` mais qui ne sera pas envoyer sur le repo distant par `.gitignore`

Le developpement de l'application se fera dans le dossier `src`

Les pages (vues) seront dans le dossier pages et les fichiers utils pour l'affichage dans `assets`

### Required Libs

Voici la liste des librairies a ajouter dans le dossier lib

- `servlet-api.jar` qui se trouve dans le dossier `tomcat/lib/`
- `postgresql-42.6.0.jar` a telecharger si necessaire
- `gfja.jar` librairie DAO a recuperer sur dans le projet [moteur-generic](https://github.com/ChanAlex2357/moteur-generic.git)
