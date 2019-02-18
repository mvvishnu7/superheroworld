# superheroworld
A java console game

The game is a basic console application for console game. The below point summarises the current capabilities.  

- As a player I want to create a character
  - User given options to enter the player name
 - As a player I want to explore
    - User gets option to explore different worlds(eg Earth, Atlantis)
- As a player I want to gain experience through fighting
    - Options to fight below opponents in corresponding world(eg Ultron in Earth, Loki in Asgard)
    - Once you fight experience increases
- As a player I want to save and resume a game
    - option to save game any time
    - Reload saved game on start up

###How to run
build using `mvn clean package`
run using `java -jar target/super-hero-world-1.0.0-SNAPSHOT.jar` (_snapshot version to be updated as per pom_)

###Design Principles
 - Programming to interface has been followed through out for extensibility.
 - Application uses **command design pattern** to run various game operations
 - Command creation is via command factory.
 - The project uses **Factory Design Pattern** and **BuilderPattern** for object creation
 - Opponent and Player Fight are controlled by **StrategyPattern**
 - Terminal interface implementation controls all read and write to console
 
####Test coverage
 The project uses jacoco for creating test reports.
 The report will be generated once you run `mvn clean package` or `mvn test`
 You can find the report at `target/site/jacoco/index.html`   
 
####Logging
 Basic java logging has been provided. The log file can be found at `src/main/resources/game_application.log`