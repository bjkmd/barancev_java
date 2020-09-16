package bjk.learn.java.barancev.dataObjects;

public class ProductInCartItemBuilder {
  private String productName;
  private String productId;
  private String itemId;
  private String description;
  private boolean inStock;
  private int quantity;
  private String price;
  private String totalCost;

  public ProductInCartItemBuilder setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public ProductInCartItemBuilder setProductId(String productId) {
    this.productId = productId;
    return this;
  }

  public ProductInCartItemBuilder setItemId(String itemId) {
    this.itemId = itemId;
    return this;
  }

  public ProductInCartItemBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ProductInCartItemBuilder setInStock(boolean inStock) {
    this.inStock = inStock;
    return this;
  }

  public ProductInCartItemBuilder setQuantity(int quantity) {
    this.quantity = quantity;
    return this;
  }

  public ProductInCartItemBuilder setPrice(String price) {
    this.price = price;
    return this;
  }

  public ProductInCartItemBuilder setTotalCost(String totalCost) {
    this.totalCost = totalCost;
    return this;
  }

  public ProductInCartItem createProductInCartItem() {
    return new ProductInCartItem(productName, productId, itemId, description, inStock, quantity, price, totalCost);
  }
}