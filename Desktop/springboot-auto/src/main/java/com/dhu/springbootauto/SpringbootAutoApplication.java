package com.dhu.springbootauto;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Locale;


@EnableRabbit
@EnableCaching
@MapperScan(value = "com.dhu.springbootauto.mapper")
@SpringBootApplication
public class SpringbootAutoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootAutoApplication.class, args);
	}
}
