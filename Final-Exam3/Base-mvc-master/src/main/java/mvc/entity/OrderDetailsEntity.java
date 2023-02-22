package mvc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orderDetails")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private int orderDetailsId;

//    @Column(name = "order_id")
//    private int orderId;
//    @Column(name = "pro_id")
//    private int proId;
    @Column(name = "quantity_id")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrdersEntity orders;
    @ManyToOne
    @JoinColumn(name = "pro_id")
    private ProductsEntity products;

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrdersEntity getOrders() {
        return orders;
    }

    public void setOrders(OrdersEntity orders) {
        this.orders = orders;
    }

    public ProductsEntity getProducts() {
        return products;
    }

    public void setProducts(ProductsEntity products) {
        this.products = products;
    }
}
