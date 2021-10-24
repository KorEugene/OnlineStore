package ru.geekbrains.webmarket.core.aspect.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebAppAspectLogging {

    public static final String CART_SERVICE_NAME = "CartService";
    public static final String CATEGORY_SERVICE_NAME = "CategoryService";
    public static final String ORDER_SERVICE_NAME = "OrderService";
    public static final String PRODUCT_SERVICE_NAME = "ProductService";
    public static final String USER_SERVICE_NAME = "UserService";

    public static long cartServiceTime = 0;
    public static long categoryServiceTime = 0;
    public static long orderServiceTime = 0;
    public static long productServiceTime = 0;
    public static long userServiceTime = 0;

    @Around("execution(public * ru.geekbrains.webmarket.core.services.*.*(..))")
    public Object methodLogging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String serviceName = proceedingJoinPoint.getTarget().getClass().getSimpleName();

        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;

        saveTime(serviceName, duration);

        return out;
    }

    private static void saveTime(String serviceName, long duration) {
        if(serviceName.equals(CART_SERVICE_NAME)) {
            cartServiceTime += duration;
        }
        if(serviceName.equals(CATEGORY_SERVICE_NAME)) {
            categoryServiceTime += duration;
        }
        if(serviceName.equals(ORDER_SERVICE_NAME)) {
            orderServiceTime += duration;
        }
        if(serviceName.equals(PRODUCT_SERVICE_NAME)) {
            productServiceTime += duration;
        }
        if(serviceName.equals(USER_SERVICE_NAME)) {
            userServiceTime += duration;
        }
    }
}
