# Graphic Engine project

## Done
1. dynamic randering system architechture : ispiredd by game loop (https://java-design-patterns.com/patterns/game-loop/#programmatic-example-of-game-loop-pattern-in-java)


## Issues
 - EngineController from chatgpt
 - Main from chatgpt
 - Scene Architechture from chatgpt

 - drawing basic method : drawLine()
 - definition of mesh
 - 3d projection



 ## Architechture

 ### main.java

 The entree programm of this engine, it initialise the loop and start running it.

 ### EngineLoop.java

 Define an abstract class EngineLoop that orgenize the way the engine work

 ### VariableStepEngineLoop

 Implement EngineLoop in a way that take the time elapsed between two frames in count
