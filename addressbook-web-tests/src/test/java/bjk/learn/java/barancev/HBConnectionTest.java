package bjk.learn.java.barancev;

import bjk.learn.java.barancev.dataObjects.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class HBConnectionTest {

  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
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

  @Test
  public void testHibernateConnection() {

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List result = session.createQuery( "from Product where category = 'FISH'" ).list();
    for ( Product product : (List<Product>) result ) {
      System.out.println( product);
    }


    session.getTransaction().commit();
    session.close();

  }
}
