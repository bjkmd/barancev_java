package bjk.learn.java.barancev;

import org.junit.Assert;
import org.testng.annotations.Test;

public class EquationTest {

    @Test
    public void test0() {
        Equation equation = new Equation(1, 1, 1);
        Assert.assertEquals(equation.rootNumber(),0);
    }

    @Test
    public void test1() {
        Equation equation = new Equation(1, 2, 1);
        Assert.assertEquals(equation.rootNumber(),1);
    }



}