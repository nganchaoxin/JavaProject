package mvc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.Entity;


//@Entity
//@Scope(value= WebApplicationContext.SCOPE_SESSION, proxyMode= ScopedProxyMode.TARGET_CLASS)
@Component
@SessionScope
public class CartEntity {
    // Product
    // OrderDetails
    private OrderDetailsEntity orderDetails;
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


    public OrderDetailsEntity getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetailsEntity orderDetails) {
        this.orderDetails = orderDetails;
    }
}
