# Number Guessing Game

## Game Logic
- Random number between 1 and 100 will be generated as an `actualNumber`
- Each player's score will be started from `100` 
- For every wrong guess, player's score will be decreased by `10`
- If a player cannot find `actualNumber` in 10 attempts, game will be failed.

## User Experience and Statistics
- At the start of the game, players can start, see current scores and quit based on their input. These information will be show in terminal at the start of the game.
- `scores.txt` file used as a database for players' scores.
    - If this file is missing (game has never been played), file will be generated on start.
- Statistics will be shown as `{{name}}` `{{score}}` for example `Anil 10`.

## Tech Stack
- Java 8
- Maven

## How to run the game?
- You can run the game in two different ways.
- Directly from source code:
    - Simply go into `src/main/java/org/anil/Main.java` file and run in your prefered IDE
- From `.jar` file:
    - You can run the from .jar file. To be able to do this you can follow these steps:
        - `mvn clean package` -> this build and create a `.jar` file in target directory
        - `cd <path-to-target>`
        - `java -jar guessing-game-<version>-SNAPSHOT.jar`
