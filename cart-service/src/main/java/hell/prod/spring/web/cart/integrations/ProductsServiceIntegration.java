package hell.prod.spring.web.cart.integrations;


import hell.prod.spring.web.api.core.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductsServiceIntegration {
    private final RestTemplate restTemplate;
    private final WebClient productServiceWebclient;

    @Value("${integrations.core-service.url}")
    private String productServiceUrl;

    public Optional<ProductDto> findById(Long id) {
        ProductDto productDto = productServiceWebclient.get().uri("/api/v1/products/" + id).retrieve().bodyToMono(ProductDto.class).block();
        return Optional.ofNullable(productDto);
    }

//    public Optional<ProductDto> findById(Long id) {
//        ProductDto productDto = restTemplate.getForObject(productServiceUrl + "/api/v1/products/" + id, ProductDto.class);
//        return Optional.ofNullable(productDto);
//    }
}
