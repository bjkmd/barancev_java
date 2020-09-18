package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.dataObjects.CartItems;
import bjk.learn.java.barancev.dataObjects.ProductInCartItem;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    logger.info("Started test testAddToCart");

    CartItems before;

    action.fillInCart();
    goTo.cart();
    before = user.getProductsInCart();
    action.addToCartFirstProductFromCategory("BIRDS");
    goTo.cart();
    CartItems after = user.getProductsInCart();

    assertThat(after.size(),equalTo(before.size()+1));
    ProductInCartItem toRemove = after.iterator().next();
    assertThat(after.without(toRemove), equalTo(before));

    logger.info("Finished test testAddToCart");

  }

  @Test
  public void testRemoveFromCart() {

    CartItems before;

    action.fillInCart();
    goTo.cart();
    before = user.getProductsInCart();
    ProductInCartItem toRemove = before.iterator().next();

    System.out.println(before.stream().
            map(ProductInCartItem::getProductId).
            collect(Collectors.joining("\n")));

    user.removeFromCart(toRemove);
    goTo.cart();
    Set<ProductInCartItem> after = user.getProductsInCart();

    assertThat(after.size(),equalTo(before.size()-1));
    assertThat(after, equalTo(before.without(toRemove)));

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
    action.fillInCart();
    goTo.cart();
    double totalPriceExpected = user.getProductsInCart().stream().mapToDouble(productInCartItem->Double.parseDouble(productInCartItem.getTotalCost().substring(1))).sum();
    double totalPriceActual = user.getTotalPriceInCart();
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
    assertThat(after, equalTo(before));
  }

  @Test
  public void testAddToCartLong() {

    goTo.mainPage();
    goTo.category("FISH");
    Assert.assertEquals(user.getProductsList().size(), 4);
    goTo.pdpByNumber(2);
    user.addToCartByNumber(1);
    goTo.cart();
    Set<ProductInCartItem> before = user.getProductsInCart();

    goTo.category("DOGS");
    goTo.pdpByNumber(2);
    user.addToCartByNumber(1);
    goTo.cart();
    Set<ProductInCartItem> after = user.getProductsInCart();

    Assert.assertEquals(before.size() + 1, after.size());
    ProductInCartItem toRemove = after.iterator().next();
    after.remove(toRemove);
    Assert.assertEquals(before, after);

  }

}
