# Game Of Passing Numbers

Game with two independent units, the players communicating with each other using an API.

## HLD

![alt text](https://github.com/oyedpk/GameOfPassingNumbers/blob/master/design.png?raw=true)

## Installation Pre-requisite (Kafka and ZooKeeper)

Step 1: Download Kafka
```bash
tar -xzf kafka_2.12-2.5.0.tgz
cd kafka_2.12-2.5.0
```
Step 2: Starting The Server
```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
```
on Windows platforms use bin\windows\instead of bin, and change the script extension to .bat.
```bash
bin/kafka-server-start.sh config/server.properties
```
Windows users should again use bin\windows\ directory to run the server.

If the Kafka server runs without any error as well, we are ready to create a Spring Boot project.


## Installing the application

Compile

```bash
mvn clean install
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
Player1 port - 9000
Player1 port - 9001

http://localhost:9000/start?number=22222222

or

http://localhost:9000/start                     -> to start with some random number


## Note
When the other player is not available, game will resume after the player is available again

Result will be displayed in Logs for both player1 and player2
