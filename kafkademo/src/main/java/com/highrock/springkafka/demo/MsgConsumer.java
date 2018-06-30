package com.highrock.springkafka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
public class MsgConsumer {

    private static final Logger log = LoggerFactory.getLogger(MsgProducer.class);

    @KafkaListener(topics = {"topic-11"})
    public void processMessage(String content) {
        log.info("消息"+content+"被消费");
    }
}
