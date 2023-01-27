package mvc.entity;

import org.springframework.stereotype.Component;

@Component
//@SessionScope
//@Scope(value= WebApplicationContext.SCOPE_SESSION, proxyMode= ScopedProxyMode.TARGET_CLASS)
public class CartEntity {
    private ProductEntity product;
    private int quantity;

    public CartEntity() {

    }

    public CartEntity(ProductEntity product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

}
