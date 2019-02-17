package com.springBoot;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.springBoot.entity.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot08AmqpApplicationTests {

	@Resource
	RabbitTemplate rabbitTemplate;
	
	@Test
	public void contextLoads() {
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "这是第一个消息");
		map.put("hi", "Helloworld!");
		rabbitTemplate.convertAndSend("exchange.direct", "atguigu", map);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void contextLoads2() {
		Object object = rabbitTemplate.receiveAndConvert("atguigu");
		System.out.println(object.getClass());
		Map<String, Object> map = ((Map<String, Object>)object);
		System.out.println(map);
		System.out.println(map.get("msg"));
	}
	
	@Test
	public void contextLoads3() {
		Book book = new Book();
		book.setName("西游记");
		book.setPrice(19.9);
		rabbitTemplate.convertAndSend("exchange.direct", "atguigu", book);
	}
	
	@Test
	public void contextLoads4() {
		Object object = rabbitTemplate.receiveAndConvert("atguigu");
		System.out.println(object.getClass());

		Book book = (Book)object;
		System.out.println(book);
	}
	
	@Test
	public void contextLoads5() {
		Map<String, String> map = new HashMap<>();
		Book book = new Book();
		book.setName("西游记");
		book.setPrice(19.9);
		map.put("book", JSON.toJSONString(book));
		rabbitTemplate.convertAndSend("exchange.direct", "atguigu", map);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void contextLoads6() {
		Object object = rabbitTemplate.receiveAndConvert("atguigu");
		System.out.println(object.getClass());
		Map<String, String> map = ((Map<String, String>)object);
		System.out.println(map);
		Book book = JSON.parseObject(map.get("book"), Book.class);
		System.out.println(book);
	}

}

