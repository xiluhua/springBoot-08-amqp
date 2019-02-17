package com.springBoot.rabbitmq.listener;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.springBoot.entity.Book;

@Component
public class BookListener {

	@RabbitListener(queues="atguigu")
	public void receive(Map<String, String> map) {
		System.out.println("BookListener: "+map);
		Book book = JSON.parseObject(map.get("book"), Book.class);
		System.out.println("BookListener: "+book);
	}
}
