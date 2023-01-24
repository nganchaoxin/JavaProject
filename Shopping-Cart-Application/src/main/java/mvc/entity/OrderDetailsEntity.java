package mvc.entity;

import javax.persistence.*;

@Entity
@Table(name="OrderDetail")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Column(name = "order_id")
//    private int orderID;
//
//    @Column(name="product_id")
//    private int productID;
    @Column(name = "product_name")
    private String productName;

    private int quantity;

    @ManyToOne
    @JoinColumn(name="order_id")
    private OrdersEntity orders;

    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductEntity product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getOrderID() {
//        return orderID;
//    }
//
//    public void setOrderID(int orderID) {
//        this.orderID = orderID;
//    }
//
//    public int getProductID() {
//        return productID;
//    }
//
//    public void setProductID(int productID) {
//        this.productID = productID;
//    }

    public OrdersEntity getOrders() {
        return orders;
    }

    public void setOrders(OrdersEntity orders) {
        this.orders = orders;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetailsEntity{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
