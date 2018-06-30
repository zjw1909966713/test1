package com.highrock.springkafka.demo;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

@Component
public class MsgProducer {


    private static final Logger log = LoggerFactory.getLogger(MsgProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public boolean sendMessage(String topicName, String jsonData) {

        boolean flag=true;
        log.info("向kafka推送数据:[{}]", jsonData);
        try {
            kafkaTemplate.send(topicName, jsonData);

            //消息发送的监听器，用于回调返回信息
            kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
                @Override
                public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
                    log.info("===============发送成功===================");
                }

                @Override
                public void onError(String topic, Integer partition, String key, String value, Exception exception) {
                    log.info("===================发送失败============================");
                }

                @Override
                public boolean isInterestedInSuccess() {
                    log.info("数据发送完毕");
                    return false;
                }
            });

        } catch (Exception e) {
            log.error("发送数据出错！！！{}{}", topicName, jsonData);
            log.error("发送数据出错=====>", e);

            flag=false;
        }

        return flag;
    }
}
