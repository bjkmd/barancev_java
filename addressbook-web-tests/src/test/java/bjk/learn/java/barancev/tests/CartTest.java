package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.dataObjects.ProductInCartItem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class CartTest extends TestBase {

  @BeforeMethod
  public void before(){
    goTo.cart();
    if (!user.isCartEmpty()){
      user.clearCart();
    }

  }

  @Test
  public void testAddToCart() {

    Set<ProductInCartItem> before;

    action.fillInCart();
    goTo.cart();
    before = user.getProductsInCart();
    action.addToCartFirstProductFromCategory("BIRDS");
    goTo.cart();
    Set<ProductInCartItem> after = user.getProductsInCart();

    assertThat(after.size(),equalTo(before.size()+1));
    ProductInCartItem toRemove = after.iterator().next();
    after.remove(toRemove);
    assertThat(after, equalTo(before));

  }

  @Test
  public void testRemoveFromCart() {

    Set<ProductInCartItem> before;

    action.fillInCart();
    goTo.cart();
    before = user.getProductsInCart();
    ProductInCartItem toRemove = before.iterator().next();

    user.removeFromCart(toRemove);
    goTo.cart();
    Set<ProductInCartItem> after = user.getProductsInCart();

    assertThat(after.size(),equalTo(before.size()-1));
    before.remove(toRemove);
    assertThat(after, equalTo(before));

  }

  @Test
  public void testRemoveFromCartThenAddTheSameProduct() {
    Set<ProductInCartItem> before;

    action.fillInCart();

    goTo.cart();
    before = user.getProductsInCart();
    user.removeFromCartByNumber(0);
    action.addToCartFirstProductFromCategory("FISH");
    goTo.cart();
    Set<ProductInCartItem> after = user.getProductsInCart();
    assertThat(after, equalTo(before));
  }

  @Test
  public void testLambdaTotalPrice() {
    Set<ProductInCartItem> productInCartItems;

    action.fillInCart();
    action.fillInCart();
    goTo.cart();
    productInCartItems = user.getProductsInCart();
    double quantity = productInCartItems.stream().mapToDouble(ProductInCartItem::getQuantity).sum();
    double totalPriceExpected = productInCartItems.stream().mapToDouble(productInCartItem->Double.parseDouble(productInCartItem.getTotalCost().substring(1))).sum();
    double totalPriceActual = user.getTotalPriceInCart();
//    Assert.assertEquals(totalPriceActual,totalPriceExpected);
    assertThat(totalPriceExpected,equalTo(totalPriceActual));

  }

  @Test
  public void testLambdaSort() {
    Set<ProductInCartItem> before;

    action.fillInCart();

    goTo.cart();
    before = user.getProductsInCart();
    user.removeFromCartByNumber(0);
    action.addToCartFirstProductFromCategory("FISH");
    goTo.cart();
    Set<ProductInCartItem> after = user.getProductsInCart();

//    Assert.assertEquals(before,after);
    assertThat(after, equalTo(before));
  }

}
