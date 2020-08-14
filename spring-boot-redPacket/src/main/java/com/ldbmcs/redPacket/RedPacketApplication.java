package com.ldbmcs.redPacket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RedPacketApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedPacketApplication.class, args);
	}
}