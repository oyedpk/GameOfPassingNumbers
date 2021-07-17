package com.game.util;

import com.game.kafka.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class GameUtil {

    Logger logger = LoggerFactory.getLogger(GameUtil.class);

    public static transient String STATUS="IDLE";

    @Value("${player.name}")
    private String playerName;

    @Autowired
    private ProducerService messageProducer;

    public void gamePlay(Long a) throws ExecutionException {
        if(a==-1) {
            logger.info("*****************Player [ {} ] LOST", playerName);
            STATUS="IDLE";
        } else if(a==3 || a==2 || a==4 || a==1) {
            logger.info("*****************Player [ {} ] WON", playerName);
            messageProducer.sendMessage((long) -1);
            STATUS="IDLE";
        } else if(a%3==0) {
            logger.info("*****************Player [ {} ] added 0 ||-> received [ {} ] and passed [ {} ] ", playerName,
            a,a/3);
            messageProducer.sendMessage(a/3);
        } else {
            if((a+1)%3==0) {
                logger.info("*****************Player [ {} ] added 1 ||-> received [ {} ] and passed [ {} ] ", playerName,
                        a,(a+1)/3);
                messageProducer.sendMessage((a+1)/3);
            } else if((a-1)%3==0) {
                logger.info("*****************Player [ {} ] subtracted 1 ||-> received [ {} ] and passed [ {} ] ",
                        playerName, a,(a-1)/3);
                messageProducer.sendMessage((a-1)/3);
            }
        }
    }

}
