package com.game.service;

import com.game.kafka.ProducerService;
import com.game.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class GameService {

    @Autowired
    private ProducerService messageProducer;

    Logger logger = LoggerFactory.getLogger(GameService.class);

    public synchronized String startGame(Long number) {
        if(Player.STATUS.equals("IDLE")) {
            if(number<=0) {
                logger.info("*****************Invaild Input, Pass whole number [ {} ]", number);
                return "Invaild Input, Pass whole number";
            }
            Player.STATUS="IN_PROGRESS";
            try {
                messageProducer.sendMessage(number);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            logger.info("*****************Started Game with Number : [ {} ]", number);
            return "Game Started";
        } else  {
            logger.info("*****************Game in progress, Try after some time");
            return "Game in progress, Try after some time";
        }
    }



}
