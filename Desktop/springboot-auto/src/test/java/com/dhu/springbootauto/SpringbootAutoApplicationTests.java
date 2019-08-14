package com.dhu.springbootauto;

import com.dhu.springbootauto.entites.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAutoApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;


	@Test
	public void contextLoads() throws SQLException{
		Book book = new Book();
		book.setId(56789);
		book.setName("c++primier");
		rabbitTemplate.convertAndSend("exchange.direct","book_borrow",book);

	}

	@Test
	public void receive(){
		Object o = rabbitTemplate.receiveAndConvert("book_borrow");
		System.out.println(o.getClass());
		System.out.println(o);
	}



}
