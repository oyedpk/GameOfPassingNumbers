package com.game.kafka;

import com.game.util.GameUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public final class ConsumerService {

    @Autowired
    GameUtil gameUtil;

    @KafkaListener(topics = "${kafka.consume.topic}", groupId = "${kafka.consumerGroupId}")
    public void consume(Long message) throws ExecutionException {
        if(message!=null) {
            gameUtil.gamePlay(message);
        }
    }
}
