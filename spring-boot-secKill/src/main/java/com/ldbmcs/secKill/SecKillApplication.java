package com.ldbmcs.secKill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SecKillApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecKillApplication.class, args);
	}
}