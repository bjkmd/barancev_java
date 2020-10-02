package bjk.learn.java.barancev;

import bjk.learn.java.barancev.dataObjects.Product;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DBConnectionTest {

  @Test
  public void testDBConnect() {

    Connection conn = null;
    Set<Product> products = new HashSet<>();

    try {
      conn =
              DriverManager.getConnection("jdbc:mysql://localhost/jpetstore?" +
                      "user=root&password=root&characterEncoding=utf8");

      Statement statement = conn.createStatement();

      ResultSet resultSet = statement.executeQuery("select * from product");



      while (resultSet.next()){
        products.add(new Product(resultSet.getString("name"),
                resultSet.getString("productId")));
      }

      resultSet.close();
      statement.close();
      conn.close();


    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }

    for (Product product:
         products) {

    System.out.println(product);

    }


  }
}
