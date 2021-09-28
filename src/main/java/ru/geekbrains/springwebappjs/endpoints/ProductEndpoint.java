package ru.geekbrains.springwebappjs.endpoints;

import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.geekbrains.springwebappjs.services.ProductService;
import ru.geekbrains.springwebappjs.soap.products.GetAllProductsRequest;
import ru.geekbrains.springwebappjs.soap.products.GetAllProductsResponse;
import ru.geekbrains.springwebappjs.soap.products.GetProductByIdRequest;
import ru.geekbrains.springwebappjs.soap.products.GetProductByIdResponse;

@Endpoint // http://localhost:8189/market/ws
@AllArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.geekbrains.ru/springwebappjs/products";
    private final ProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByIdRequest")
    @ResponsePayload
    public GetProductByIdResponse getProductById(@RequestPayload GetProductByIdRequest request) {
        GetProductByIdResponse response = new GetProductByIdResponse();
        response.setProduct(productService.findByIdAsSoap(request.getId()));
        return response;
    }

    /*
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.geekbrains.ru/springwebappjs/products">
            <soapenv:Header/>
            <soapenv:Body>
                <f:getAllProductsRequest/>
            </soapenv:Body>
        </soapenv:Envelope>
     */

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProductsResponse(@RequestPayload GetAllProductsRequest request) {
        GetAllProductsResponse response = new GetAllProductsResponse();
        productService.findAllAsSoap().forEach(response.getProducts()::add);
        return response;
    }
}
