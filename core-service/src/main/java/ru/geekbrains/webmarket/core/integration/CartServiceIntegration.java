package ru.geekbrains.webmarket.core.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import ru.geekbrains.webmarket.api.dtos.CartDto;

import java.security.Principal;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final WebClient cartServiceWebClient;

    @Value("${integration.cart-service.url}")
    private String cartServiceUrl;

    public CartDto getUserCartDto(String username) {
        return cartServiceWebClient.get()
                .uri(cartServiceUrl + "/api/v1/cart")
                .headers(httpHeaders -> httpHeaders.add("username", username))
                .retrieve()
                .bodyToMono(CartDto.class)
                .block();
    }

    public void clearUserCart(String username) {
        cartServiceWebClient.get()
                .uri(cartServiceUrl + "/api/v1/cart/0/clear")
                .headers(httpHeaders -> httpHeaders.add("username", username));
    }
}
