package hell.prod.spring.web.cart.exceptions;

public class ProductServiceIntegrationException extends RuntimeException {
    public ProductServiceIntegrationException(String message) {
        super(message);
    }
}
