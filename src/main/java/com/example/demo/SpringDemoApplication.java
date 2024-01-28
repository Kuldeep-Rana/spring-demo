package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringDemoApplication.class, args);
		var restCon = context.getBean(HelloRestController.class);
		System.out.println(restCon.Hello());
		var order = new Order();
		context.getBeanFactory().registerSingleton(Order.class.getCanonicalName(), order);

	}

	@Bean
	@Qualifier("order1")
	public Address createAddress(){
	return new Address();
	}

}
