package bjk.learn.java.barancev.helpers;

import bjk.learn.java.barancev.dataObjects.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DBHelper {

  private SessionFactory sessionFactory;

  public DBHelper() {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {
      e.printStackTrace();
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy( registry );
    }

  }

  public List<Product> getProductsForCategory(String category){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Product> productsListFromDB = session.createQuery( "from Product where category = '"+category+"'" ).list();
//    for ( Product product : productsListFromDB ) {
//      System.out.println( product);
//    }
    session.getTransaction().commit();
    session.close();

    return productsListFromDB;

  }

}
