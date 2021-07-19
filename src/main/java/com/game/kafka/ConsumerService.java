package com.game.kafka;

import com.game.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public final class ConsumerService {

    @Autowired
    Player player;

    @KafkaListener(topics = "${kafka.consume.topic}", groupId = "${kafka.consumerGroupId}")
    public void consume(Long message) throws ExecutionException {
        if(message!=null) {
            player.gamePlay(message);
        }
    }
}
