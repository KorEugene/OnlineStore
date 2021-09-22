package ru.geekbrains.springwebappjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringWebAppJsApplication {
	// План на курс:
	// 1. Сделать регистрацию пользователей на отдельной странице
	// 2. Сделать корзину (+ добавить редис)
	// 3. История просмотра товаров
	// 4. Комментарии/рейтинги/отзывы товаров
	// 5. Сделать дерево категорий товаров
	// 6. Блок наиболее популярных товаров
	// 7. Начисление бонусов, личный кабинет пользователя
	// 8. Побольше разделения прав пользователей (юзер, админ, супер-админ)
	// 9. Сделать оформление заказов
	// 10. Добавить платежную систему
	// 11. Фильтрация товаров
	// 12. Почтовая рассылка
	// 13. Поиск по сайту (возможно даже умный)
	// *. ** Акции
	// *. *** Админка
	// *. Рассмотреть MapStruct

	// Домашнее задание:
	// 1. Сделать на backend-е оформление заказа с сохранением его в БД
	// 2. * Привязывать заказ к текущему пользователю

	public static void main(String[] args) {
		SpringApplication.run(SpringWebAppJsApplication.class, args);
	}

}
