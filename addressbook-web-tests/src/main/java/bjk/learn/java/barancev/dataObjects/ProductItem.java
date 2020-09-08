package bjk.learn.java.barancev.dataObjects;

public class ProductItem extends Product {

  String itemId;
  String description;
  String price;

  public ProductItem(String productName,
                     String productId,
                     String itemId,
                     String description,
                     String price) {
    super(productName,productId);
    this.itemId = itemId;
    this.description = description;
    this.price = price;
  }
}
