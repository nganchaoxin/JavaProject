package entity;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrdersEntity orderId;
    @Column(name = "order_product_name")
    private String productName;
    @Column(name = "order_quantity")
    private int quantity;
    @Column(name = "order_unit_price")
    private double unitPrice;

    public OrderDetailsEntity() {

    }
    public OrdersEntity getOrderId() {
        return orderId;
    }

    public void setOrderId(OrdersEntity orderId) {
        this.orderId = orderId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetailsEntity{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
