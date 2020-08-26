package ua.bjk.java.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PointTest {

    @Test
    public void testDistance() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(10,10);

        Assert.assertEquals(Point.distance(p1,p2),
                14.142135623730951);


    }
}