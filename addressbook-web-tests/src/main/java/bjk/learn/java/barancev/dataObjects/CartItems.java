package bjk.learn.java.barancev.dataObjects;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class CartItems extends ForwardingSet<ProductInCartItem> {

  private Set<ProductInCartItem> delegate;

  public CartItems(CartItems cartItems) {
    this.delegate = new HashSet<ProductInCartItem>(cartItems.delegate);
  }

  public CartItems() {
    this.delegate = new HashSet<ProductInCartItem>();
  }

  @Override
  protected Set<ProductInCartItem> delegate() {
    return delegate;
  }


  public CartItems withAdded(ProductInCartItem productInCartItem){
    CartItems cartItems = new CartItems(this);
    cartItems.add(productInCartItem);

    return  cartItems;
  }

  public CartItems without(ProductInCartItem productInCartItem){
    CartItems cartItems = new CartItems(this);
    cartItems.remove(productInCartItem);

    return  cartItems;
  }

}
