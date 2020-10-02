package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.dataObjects.Product;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CatalogTest extends TestBase{

  @DataProvider(name = "Collections")
  public static Object[][] categories() {
    return new Object[][]{
            {"BIRDS"},
            {"CATS"},
            {"DOGS"},
            {"FISH"},
            {"REPTILES"}
    };
  }

  @Test(dataProvider = "Collections")
  public void testProductList(String collection) {

    goTo.mainPage();
    goTo.category(collection);

    ArrayList<Product> productsListFromUI = user.getProductsList();
    List<Product> productsListFromDB = db.getProductsForCategory(collection);

    assertThat(new HashSet<Product>(productsListFromDB) , equalTo(new HashSet<Product>(productsListFromUI)));

  }
}
