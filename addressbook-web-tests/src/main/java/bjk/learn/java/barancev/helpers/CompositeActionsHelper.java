package bjk.learn.java.barancev.helpers;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CompositeActionsHelper extends HelperBase {

  private NavigationHelper goTo;
  private UserActionsHelper user;

  public CompositeActionsHelper(WebDriver driver) {
    super(driver);
    goTo = new NavigationHelper(driver);
    user = new UserActionsHelper(driver);
  }

  public void fillInCart() {
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

  public void addToCartFirstProductFromCategory(String category) {
    goTo.mainPage();
    goTo.category(category);
    goTo.pdpByNumber(0);
    user.addToCartByNumber(0);
  }
}
