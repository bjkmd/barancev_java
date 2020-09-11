package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.dataObjects.ProductInCartItem;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

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

    List<ProductInCartItem> before;

    action.fillInCart();
    goTo.cart();
    before = user.getProductsInCartList();
    action.addToCartFirstProductFromCategory("BIRDS");
    goTo.cart();
    List<ProductInCartItem> after = user.getProductsInCartList();

    Assert.assertEquals(before.size()+1,after.size());
    after.remove(after.size()-1);
    Assert.assertEquals(before,after);

  }

  @Test
  public void testRemoveFromCart() {

    List<ProductInCartItem> before;

    action.fillInCart();
    goTo.cart();
    before = user.getProductsInCartList();
    user.removeFromCartByNumber(0);
    goTo.cart();
    List<ProductInCartItem> after = user.getProductsInCartList();

    Assert.assertEquals(before.size()-1,after.size());
    before.remove(before.size()-1);
    Assert.assertNotEquals(before,after);
  }

  @Test
  public void testRemoveFromCartThenAddTheSameProduct() {
    List<ProductInCartItem> before;

    action.fillInCart();

    goTo.cart();
    before = user.getProductsInCartList();
    user.removeFromCartByNumber(0);
    action.addToCartFirstProductFromCategory("FISH");
    goTo.cart();
    List<ProductInCartItem> after = user.getProductsInCartList();
    Assert.assertEquals(new HashSet<>(before),new HashSet<>(after));
  }

  @Test
  public void testLambdaTotalPrice() {
    List<ProductInCartItem> productInCartItems;

    action.fillInCart();
    action.fillInCart();
    goTo.cart();
    productInCartItems = user.getProductsInCartList();


    double quantity = productInCartItems.stream().mapToDouble(ProductInCartItem::getQuantity).sum();
    double totalPriceCalculated = productInCartItems.stream().mapToDouble(productInCartItem->Double.parseDouble(productInCartItem.getTotalCost().substring(1))).sum();
    double totalPriceInCart = user.getTotalPriceInCart();
    Assert.assertEquals(totalPriceInCart,totalPriceCalculated);

  }

  @Test
  public void testLambdaSort() {
    List<ProductInCartItem> before;

    action.fillInCart();

    goTo.cart();
    before = user.getProductsInCartList();
    user.removeFromCartByNumber(0);
    action.addToCartFirstProductFromCategory("FISH");
    goTo.cart();
    List<ProductInCartItem> after = user.getProductsInCartList();

    Comparator<? super ProductInCartItem> byPrice = (p1,p2)->Double.compare(p1.getPriceInDoubleType(),p2.getPriceInDoubleType());
    before.sort(byPrice);
    after.sort(byPrice);

    Assert.assertEquals(before,after);
  }

//  private void fillInCart() {
//    List<String> categories = new ArrayList<>();
//
//    categories.add("FISH");
//    categories.add("DOGS");
//    categories.add("CATS");
//    categories.add("REPTILES");
//
//    for (String category :
//            categories) {
//      addToCartFirstProductFromCategory(category);
//    }
//  }
//
//  private void addToCartFirstProductFromCategory(String category) {
//    goTo.mainPage();
//    goTo.category(category);
//    goTo.pdpByNumber(0);
//    user.addToCartByNumber(0);
//  }
}
