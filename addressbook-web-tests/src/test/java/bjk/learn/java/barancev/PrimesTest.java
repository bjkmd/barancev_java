package bjk.learn.java.barancev;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PrimesTest {

  @Test
  public void testIsPrime() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }
  @Test
  public void testIsNotPrime() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
  }

  @Test(enabled = false)
  public void testIsPrimeWhile() {
    Assert.assertTrue(Primes.isPrimeWhile(Integer.MAX_VALUE));
  }
}