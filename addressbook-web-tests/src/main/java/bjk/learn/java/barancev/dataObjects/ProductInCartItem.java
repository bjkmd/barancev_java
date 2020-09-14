package bjk.learn.java.barancev.dataObjects;

import java.util.Objects;

public class ProductInCartItem extends ProductItem {

  private String productName;
  private String productId;
  private String itemId;
  private String description;
  private boolean inStock;
  private int quantity;
  private String price;
  private String totalCost;
  public ProductInCartItem(String productName,
                           String productId,
                           String itemId,
                           String description,
                           boolean inStock,
                           int quantity,
                           String price,
                           String totalCost) {
    super(productName, productId, itemId, description, price);
    this.productName = productName;
    this.productId = productId;
    this.itemId = itemId;
    this.description = description;
    this.inStock = inStock;
    this.quantity = quantity;
    this.price = price;
    this.totalCost = totalCost;
  }

  public String getProductId() {
    return productId;
  }

  public String getTotalCost() {
    return totalCost;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getPrice() {
    return price;
  }

  public Double getPriceInDoubleType() {
    return Double.parseDouble(price.substring(1));
  }

  @Override
  public String toString() {
    return "ProductInCartItem{" +
            "productId='" + productId + '\'' +
            ", itemId='" + itemId + '\'' +
            ", price='" + price + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductInCartItem that = (ProductInCartItem) o;
    return productId.equals(that.productId) &&
            itemId.equals(that.itemId) &&
            price.equals(that.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, itemId, price);
  }
}
