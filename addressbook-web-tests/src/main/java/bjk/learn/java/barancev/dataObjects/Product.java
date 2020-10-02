package bjk.learn.java.barancev.dataObjects;


import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
  @Id
  String productId;
  String name;

  public Product(String productName, String productId) {
    this.name = productName;
    this.productId = productId;
  }

  public Product() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return productId.equals(product.productId) &&
            name.equals(product.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, name);
  }

  @Override
  public String toString() {
    return "Product{" +
            "name='" + name + '\'' +
            ", productId='" + productId + '\'' +
            '}';
  }
}
