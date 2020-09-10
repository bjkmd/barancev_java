package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.dataObjects.ProductInCartItem;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CartTest extends TestBase {

  @Test
  public void testAddToCart() {

    List<ProductInCartItem> before;

    fillInCart();
    navigate.openCart();
    before = userActions.getProductsInCartList();
    addToCartFirstProductFromCategory("BIRDS");
    navigate.openCart();
    List<ProductInCartItem> after = userActions.getProductsInCartList();

    Assert.assertEquals(before.size()+1,after.size());
    after.remove(after.size()-1);
    Assert.assertEquals(before,after);

  }

  @Test
  public void testRemoveFromCart() {

    List<ProductInCartItem> before;

    fillInCart();
    navigate.openCart();
    before = userActions.getProductsInCartList();
    userActions.removeFromCartByNumber(0);
    navigate.openCart();
    List<ProductInCartItem> after = userActions.getProductsInCartList();

    Assert.assertEquals(before.size()-1,after.size());
    before.remove(before.size()-1);
    Assert.assertNotEquals(before,after);
  }

  @Test
  public void testRemoveFromCartThenAddTheSameProduct() {
    List<ProductInCartItem> before;

    fillInCart();

    navigate.openCart();
    before = userActions.getProductsInCartList();
    userActions.removeFromCartByNumber(0);
    addToCartFirstProductFromCategory("FISH");
    navigate.openCart();
    List<ProductInCartItem> after = userActions.getProductsInCartList();
    Assert.assertEquals(new HashSet<>(before),new HashSet<>(after));
  }

  private void fillInCart() {
    List<String> categories = new ArrayList<>();

    categories.add("FISH");
    categories.add("DOGS");
    categories.add("CATS");
    categories.add("REPTILES");

    for (String category :
            categories) {
      addToCartFirstProductFromCategory(category);
    }
  }

  private void addToCartFirstProductFromCategory(String category) {
    navigate.openMainPage();
    navigate.openCategory(category);
    navigate.openPDPbyNumber(0);
    userActions.addToCartByNumber(0);
  }
}
