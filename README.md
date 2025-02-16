# Graphic Engine project

## Commands
 - compile : javac -d out src/*.java
 - run : java -cp out/*

## Done
1. update system architechture : ispiredd by game loop (https://java-design-patterns.com/patterns/game-loop/#programmatic-example-of-game-loop-pattern-in-java)


## Issues
 - add gitignore
 - update javadoc
 ✓ MeshComponent
 ✓ TransformComponent
 ✓ Triangle

2. Rendering System
 ✓ class GraphicEngine3D
 ~ GraphicEngine3d.projectScene() < prise en compte du transform
 ~ class DisplayWindow > nécessite debug : affiche une fenêtre avec un point en son centre
 - ToString pour Vect3 et Triangle puis afficher la liste de triangles rendus
 - Vérif coord des triangles, conversion int-float dans la projection et dans le rendu, réécrire DisplayWindow.render()



