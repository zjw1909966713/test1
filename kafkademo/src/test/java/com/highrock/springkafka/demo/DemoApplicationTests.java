package com.highrock.springkafka.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MsgProducer msgProducer;


	@Test
	public void test() throws Exception {

		msgProducer.sendMessage("topic-1", "topic--------1");

	//	msgProducer.sendMessage("topic-2", "topic--------2");
	}

}
