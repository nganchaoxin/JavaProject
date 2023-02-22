package mvc.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Products")
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private int proId;
    @Column(name = "pro_name")
    private String proName;
    @Column(name = "unit_price")
    private Double unitPrice;
    @OneToMany(mappedBy = "products", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> orderDetails;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<OrderDetailsEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
