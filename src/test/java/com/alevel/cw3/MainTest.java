package com.alevel.cw3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void numberSum_positive() throws Exception {
        Assert.assertEquals(10, Main.numberSum(1234));
        Assert.assertEquals(8, Main.numberSum(422));
    }

    @Test(expected = Exception.class)
    public void numberSum_negative() throws Exception {
        Main.numberSum(-1);
    }

    @Test
    public void calculate_positive() throws Exception {
        //Assert.assertEquals(2, Main.calculate("4 - 2"));
        Assert.assertTrue(Main.calculate("4 + 2") == 6.0);
        Assert.assertTrue(Main.calculate("4 - 2") == 2.0);
        Assert.assertTrue(Main.calculate("2 * 2") == 4.0);
        Assert.assertTrue(Main.calculate("2 / 2") == 1.0);
    }

    @Test(expected = Exception.class)
    public void calculate_negativeIncorrectInput() throws Exception {
        Main.calculate("- 1");
        Main.calculate("1-");
        Main.calculate("");
        Main.calculate("1 / 0");
        Main.calculate("1 % 1");
    }
}