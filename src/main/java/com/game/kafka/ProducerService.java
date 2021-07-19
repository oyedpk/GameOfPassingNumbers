package com.game.kafka;

import com.game.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public final class ProducerService {
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private final KafkaTemplate<String, Long> kafkaTemplate;

    @Value("${kafka.produce.topic}")
    private String topic;

    public ProducerService(KafkaTemplate<String, Long> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Long message) throws ExecutionException {
        try {
            this.kafkaTemplate.send(topic, message).get();
        } catch (InterruptedException e) {
            Player.STATUS="IDLE";
        }
    }
}
