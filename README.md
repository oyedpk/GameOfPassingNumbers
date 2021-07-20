# Game Of Passing Numbers

Game with two independent units, the players communicating with each other using an API.

## HLD

![alt text](https://github.com/oyedpk/GameOfPassingNumbers/blob/master/design.png?raw=true)

## Installation Pre-requisite (Kafka and ZooKeeper)

Step 1: Run docker compose
```bash
docker-compose up -d
```

## Installing the application

Compile (Skip the step if you dont want to compile, simply run the jar from target)

```bash
mvn clean install     (or simply run the jar file from the target)   
```

Run player 1

```bash
java -jar -Dspring.profiles.active=player1 target/demo-0.0.1-SNAPSHOT.jar
```

Run player 2

```bash
java -jar -Dspring.profiles.active=player2 target/demo-0.0.1-SNAPSHOT.jar
```


## Play the Game (You can start the game with any player)
From browser hit below url.

Player1 port - 9000
Player2 port - 9001

http://localhost:9000/start?number=22222222

or

http://localhost:9000/start                     -> to start with some random number


## Note
When the other player is not available, game will resume after the player is available again

Result will be displayed in Logs for both player1 and player2
