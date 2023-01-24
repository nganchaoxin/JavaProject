package mvc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.Entity;


//@SessionScope
@Entity
@Scope(value= WebApplicationContext.SCOPE_SESSION, proxyMode= ScopedProxyMode.TARGET_CLASS)
public class CartEntity {
    @Autowired
    private OrdersEntity ordersEntity;

    public OrdersEntity getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(OrdersEntity ordersEntity) {
        this.ordersEntity = ordersEntity;
    }
}
