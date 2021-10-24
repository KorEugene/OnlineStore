package ru.geekbrains.webmarket.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringWebMarketCartApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringWebMarketCartApplication.class, args);
	}
}
