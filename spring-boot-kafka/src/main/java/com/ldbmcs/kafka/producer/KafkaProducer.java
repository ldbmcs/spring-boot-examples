package com.ldbmcs.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
@EnableScheduling
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @Scheduled(cron = "00/1 * * * * ?")
    public void send() {
        String message = "第一种类的订阅消息发送";
        ListenableFuture<?> future = kafkaTemplate.send("app_log", message);
        String message2 = "第二种类的订阅消息发送";
        ListenableFuture<?> future2 = kafkaTemplate.send("app_log2", message2);
        future.addCallback(o -> log.info("send-消息发送成功：" + message), throwable -> log.warn("消息发送失败：" + message));
        future2.addCallback(o -> log.info("send-消息发送成功：" + message2), throwable -> log.warn("消息发送失败：" + message2));
    }
}
