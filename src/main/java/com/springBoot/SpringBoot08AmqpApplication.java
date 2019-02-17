package com.springBoot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * 1. RabbitAutoConfiguration
 * 2. 有自动配置了连接工程 ConnectionFactory
 * 3. RabbitProperties 封装了 rabbitmq 的配置
 * 4. @EnableRabbit + @RabbitListener 监听消息队列的内容
 *
 */
@EnableRabbit	// 开启监听
@SpringBootApplication
public class SpringBoot08AmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot08AmqpApplication.class, args);
	}

}

