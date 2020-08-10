package com.ldbmcs.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"app_log"}, groupId = "applog")
    public void receive(String message) {
        log.info("app_log--消费消息:" + message);
    }

    @KafkaListener(topics = {"app_log2"}, groupId = "applog2")
    public void receive2(String message) {
        log.info("app_log2--消费消息:" + message);
    }
}
