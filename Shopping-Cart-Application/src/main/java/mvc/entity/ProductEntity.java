package mvc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "price")
    private Double price;
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> orderDetails;

    public ProductEntity(int id, String name, String productDescription, Double price) {
        this.id = id;
        this.name = name;
        this.productDescription = productDescription;
        this.price = price;

    }

    public ProductEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public List<OrderDetailsEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
